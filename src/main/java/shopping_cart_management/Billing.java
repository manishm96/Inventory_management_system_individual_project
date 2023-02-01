package shopping_cart_management;

import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.HashSet;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class Billing {
    private static final HashMap<String, Items> checklistItems = new HashMap<>();
    private static final HashSet<String> cardsSet = new HashSet<>();

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception
    {
    	List<String[]> all_rows =fileCSVreader("Dataset - Sheet1.csv");
        List<String[]> all_moneycards =fileCSVreader("Cards.csv");
        
        new FileOutputStream("Output.csv").close();
        new FileOutputStream("Error.txt").close();

        Scanner user_entry = new Scanner(System.in);
        System.out.print("Enter the name of your checkout input file with its extension: ");
        String inputFile = user_entry.nextLine();
        List<String[]> inputs =fileCSVreader(inputFile);

        for(String[] row : all_rows){
            Items itemSample= toItems(Arrays.toString(row));
            if(itemSample!=null)
                checklistItems.put(itemSample.getItem(), itemSample);

        }

        for(String[] cardno:all_moneycards)
        {
            cardsSet.add(cardno[0]);

        }

        Essentials_cat essentials = new Essentials_cat();
        Luxury_cat luxury = new Luxury_cat();
        Misc_cat miscellaneous = new Misc_cat();

        essentials.setShoppingCartCategory(luxury);
        luxury.setShoppingCartCategory(miscellaneous);

        Set<String> corrections = new HashSet<>();

        double totalAmount=0;
        Set<String> essentials_map = new HashSet<>();
        Set<String> luxury_map = new HashSet<>();
        Set<String> Misc_map = new HashSet<>();
        for(String[] map : inputs) {
            cardsSet.add(map[2]);

            double amount= essentials.totalBillCalculation(checklistItems,map[0],Integer.parseInt(map[1]),corrections,essentials_map,luxury_map,Misc_map);
            totalAmount+=amount;
        }

        if(Items_limit_restriction.getEssentials_cat_limit()<0)
            corrections.addAll(essentials_map);

        if(Items_limit_restriction.getLuxury_cat_limit()<0)
            corrections.addAll(luxury_map);

        if(Items_limit_restriction.getMisc_cat_limit()<0)
            corrections.addAll(Misc_map);

        List<String[]> updated_card = new LinkedList<>();
        String[] header= new String[]{"CardNumber"};
        updated_card.add(header);
        for(String cardno :cardsSet)
        {
            String[] add_card= new String[]{cardno};
            updated_card.add(add_card);
        }

        CSVWriter Writer = new CSVWriter(new FileWriter("Cards.csv"), ',');
        Writer.writeAll(updated_card);
        Writer.flush();
        Writer.close();

        if(corrections.size()==0) {
            List<String[]> out_writing= new LinkedList<>();

            out_writing.add(new String[]{"Item", "Quantity", "Price", "Total Price"});
            boolean front_line = false;
            for (int k = 0; k < inputs.size(); k++) {
                Double totalPrice = checklistItems.get(inputs.get(k)[0]).price * Integer.parseInt(inputs.get(k)[1]);
                if (!front_line) {
                    out_writing.add(new String[]{inputs.get(k)[0], inputs.get(k)[1], totalPrice.toString(), String.valueOf(totalAmount)});
                    front_line = true;
                }
                else{
                        out_writing.add(new String[]{inputs.get(k)[0], inputs.get(k)[1], totalPrice.toString()});
                }
            }

            Writer = new CSVWriter(new FileWriter("Output.csv"), ',');
            Writer.writeAll(out_writing);
            Writer.flush();
            Writer.close();
        }

        else
        {
            System.out.println("Output of an unsuccessful transaction can be found in Error.txt");
            File file = new File("Error.txt");

            try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {

                bf.write("Please check the quantity of the following product/products and update as it is exceeding the category limit.");
                bf.newLine();

                for ( String input : corrections) {
                    bf.write(input);
                    bf.newLine();
                }

                bf.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    private static Items toItems(String entrees) {
        entrees = entrees.substring(1,entrees.length()-1);
        String[] entree = entrees.split(",");
        if(entree.length<4)
            return null;

        Items itemSample = new Items();
        itemSample.setCategory(entree[1].trim());
        itemSample.setItem(entree[0].trim());
        itemSample.setQuantity(Integer.valueOf(entree[2].trim()));
        itemSample.setPrice(Double.valueOf(entree[3].trim()));
        return itemSample;
    }

    private static List<String[]> fileCSVreader(String filePath) throws IOException {
        CSVReader readers = new CSVReader(new FileReader(filePath), ',', '"', 1);
        return  readers.readAll();
    }
}



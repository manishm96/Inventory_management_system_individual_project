package shopping_cart_management;

import java.util.HashMap;
import java.util.Set;


public class Essentials_cat implements Shopping_cart {
	
	private  Shopping_cart setCartCategory;
	
	@Override
	public void setShoppingCartCategory(Shopping_cart next_cart) {
		// TODO Auto-generated method stub
		setCartCategory = next_cart;
		
	}
	
	@Override
	public double totalBillCalculation(HashMap<String, Items> Cart, String Item, int quantity,
			Set<String> erroneous_quantities, Set<String> reading_essentials, Set<String> reading_luxury, Set<String> reading_misc) {
		
		Items itemSample = Cart.get(Item);

        if(itemSample.Category.equals("Essentials")){
            reading_essentials.add(Item);
            if(quantity<=itemSample.getQuantity()){
                Items_limit_restriction.setEssentials_cat_limit(Items_limit_restriction.getEssentials_cat_limit()- quantity);
                itemSample.setQuantity(itemSample.getQuantity()-quantity);
                return quantity* itemSample.getPrice();
            }
            else{
                erroneous_quantities.add(Item);
                return 0;
            }
        }
        else {
            return setCartCategory.totalBillCalculation(Cart,Item , quantity,erroneous_quantities,reading_essentials,reading_luxury,reading_misc);
        }
	}
	
	
}



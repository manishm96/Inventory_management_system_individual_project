package shopping_cart_management;

import java.util.HashMap;
import java.util.Set;


public class Misc_cat implements Shopping_cart {
	private  Shopping_cart setCartCategory;

	@Override
	public void setShoppingCartCategory(Shopping_cart next_cart) {
		// TODO Auto-generated method stub
		setCartCategory = next_cart;
		
	}

	@Override
	public double totalBillCalculation(HashMap<String, Items> Cart, String Item, int quantity,
			Set<String> erroneous_quantities, Set<String> reading_essentials, Set<String> reading_luxury, Set<String> reading_misce) {
		Items itemSample = Cart.get(Item);
        if(itemSample.Category.equals("Misc")){
            reading_misce.add(Item);
            if(quantity<=itemSample.getQuantity()){
                Items_limit_restriction.setMisc_cat_limit(Items_limit_restriction.getMisc_cat_limit()-quantity);
                itemSample.setQuantity(quantity);
                return quantity * itemSample.getPrice();
            }
            else{
                erroneous_quantities.add(Item);
                return 0;
            }
        }
        return 0;
    }
	}
	



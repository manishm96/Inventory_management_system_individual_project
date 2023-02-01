package shopping_cart_management;

import java.util.HashMap;
import java.util.Set;


public interface Shopping_cart {
    public void setShoppingCartCategory(Shopping_cart next_cart);
    public double totalBillCalculation(HashMap<String, Items> Cart , String Item , int quantity, Set<String> erroneous_quantities,
                                 Set<String> reading_essentials, Set<String> reading_luxury, Set<String> reading_misce);

}

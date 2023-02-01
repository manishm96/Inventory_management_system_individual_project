package shopping_cart_management;


public class Items_limit_restriction {
	
	   private static Items_limit_restriction essentialTotal = null;
	    static int essentials_cat_limit=3;
	    static int luxury_cat_limit=4;
	    static int misc_cat_limit=6;
	    public static int getEssentials_cat_limit() {
	        return essentials_cat_limit;
	    }
	    public static int getLuxury_cat_limit() {
	        return luxury_cat_limit;
	    }
	    public static int getMisc_cat_limit() {
	        return misc_cat_limit;
	    }
	    public static void setEssentials_cat_limit(int essentials_cat_limit) {
	    	Items_limit_restriction.essentials_cat_limit = essentials_cat_limit;
	    }
	    public static void setLuxury_cat_limit(int luxury_cat_limit) {
	    	Items_limit_restriction.luxury_cat_limit = luxury_cat_limit;
	    }
	    public static void setMisc_cat_limit(int misc_cat_limit) {
	    	Items_limit_restriction.misc_cat_limit = misc_cat_limit;
	    }

}

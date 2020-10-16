package sales;

public class Product {
    private static final double PRODUCT_1 = 2.98;
    private static final double PRODUCT_2 = 4.50;
    private static final double PRODUCT_3 = 9.98;
    private static final double PRODUCT_4 = 4.49;
    private static final double PRODUCT_5 = 6.87;

    private static double priceSale = 0.00;

    public static double getPrice(int numberProduct) {
        switch (numberProduct) {
            case 1:
                return PRODUCT_1;
            case 2:
                return PRODUCT_2;
            case 3:
                return PRODUCT_3;
            case 4:
                return PRODUCT_4;
            case 5:
                return PRODUCT_5;
            default:
                return 0.00;
        }
    }

    public static void setPriceSale(double amount, int numberProduct) {
        priceSale += amount * getPrice(numberProduct);
    }

    public static double getPriceSale() {
        return priceSale;
    }
}

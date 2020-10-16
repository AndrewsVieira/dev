package sales;

public class Store {
    public static void main(String[] args) {
        SalesMan fernando = new SalesMan("Fernando");

        System.out.print(fernando);
        
        fernando.setTotalSoldInTheMonth(5, 5);
        fernando.setTotalSoldInTheMonth(5, 4);
        fernando.setTotalSoldInTheMonth(5, 3);
        fernando.setTotalSoldInTheMonth(5, 2);
        fernando.setTotalSoldInTheMonth(5, 1);

        System.out.print(fernando);
    }
}

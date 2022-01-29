import java.util.Map;
import java.util.TreeMap;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem stockItem = new StockItem("Bread", 0.86, 100);
        stockList.addStock(stockItem);

        stockItem = new StockItem("Cake", 1.10, 7);
        stockList.addStock(stockItem);

        stockItem = new StockItem("Car", 12.50, 2);
        stockList.addStock(stockItem);

        stockItem = new StockItem("Chair", 62.0, 10);
        stockList.addStock(stockItem);

        stockItem = new StockItem("Cup", 0.50, 200);
        stockList.addStock(stockItem);

        stockItem = new StockItem("Door", 72.95, 4);
        stockList.addStock(stockItem);

        stockItem = new StockItem("Juice", 2.50, 36);
        stockList.addStock(stockItem);

        stockItem = new StockItem("Phone", 96.99, 36);
        stockList.addStock(stockItem);

        stockItem = new StockItem("Towel", 2.40, 80);
        stockList.addStock(stockItem);

        stockItem = new StockItem("Vase", 8.76, 40);
        stockList.addStock(stockItem);

//        System.out.println(stockList);

//        for (String s : stockList.Items().keySet()) {
//            System.out.println(s);
//        }

        stockItem = new StockItem("Vase", 5, 1);
        stockList.addStock(stockItem);

        System.out.println(stockList);

        Basket timsBasket = new Basket("Tim");
        sellItem(timsBasket, "Car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "Car", 1);
        System.out.println(timsBasket);

        if (sellItem(timsBasket, "Car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        }

        sellItem(timsBasket, "Car", 1);
        sellItem(timsBasket, "Me", 20);
        System.out.println(timsBasket);

        sellItem(timsBasket, "Juice", 50000);
        sellItem(timsBasket, "Cup", 12);
        sellItem(timsBasket, "Bread", 1);
        System.out.println(timsBasket);

        System.out.println(stockList);

        System.out.println("======");
        TreeMap<StockItem, Integer> timsStorage = new TreeMap<>(timsBasket.Items());

        for (StockItem stockItem1 : timsStorage.keySet()) {
            System.out.println(stockItem1.getName() + " : " + stockItem1.getPrice());
        }

        stockList.Items().get("Car").adjustStock(2000);
        System.out.println(stockList);

        System.out.println("=================");

        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }

        Basket basket = new Basket("Customer");
        sellItem(basket, "Cup", 100);
        sellItem(basket, "Juice", 5);
        removeItem(basket, "Cup", 1);
        sellItem(basket, "Cup", 1);
        System.out.println(basket);

        removeItem(timsBasket, "Car", 1);
        removeItem(timsBasket, "Cup", 9);
        removeItem(timsBasket, "Car", 1);
        System.out.println("Cars removed" + removeItem(timsBasket, "Car", 1));

        removeItem(timsBasket, "Bread", 1);
        removeItem(timsBasket, "Cup", 3);
        removeItem(timsBasket, "Juice", 4);
        removeItem(timsBasket, "Cup", 3);
        System.out.println(timsBasket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        System.out.println("Insufficient quantity");
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        System.out.println("Insufficient quantity");
        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}

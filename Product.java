package mattress;

/** Holds product names (1D array) and monthly sales (2D array) and does the report maths. */
public class Product implements IProduct {
    private final String[] names;   // one entry per product
    private final int[][] sales;    // [product][month]

    public Product(String[] names, int[][] sales) {
        this.names = names;
        this.sales = sales;
    }

    // Sum of every month for every product
    private int productTotal(int index) {
        int sum = 0;
        for (int s : sales[index]) {
            sum += s;
        }
        return sum;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            total += productTotal(i);
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        // average per product per month (153 / 9 = 17)
        int entries = sales.length * sales[0].length;
        return (double) GetTotalProductsSold() / entries;
    }

    @Override
    public String GetMostPopularProduct() {
        int best = 0;
        for (int i = 1; i < sales.length; i++) {
            if (productTotal(i) > productTotal(best)) {
                best = i;
            }
        }
        return names[best] + " (" + productTotal(best) + ")";
    }
}

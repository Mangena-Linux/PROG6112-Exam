package mattress;

import java.util.Scanner;

public class SalesReport {
    public static void main(String[] args) {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = new int[names.length][3];
        Scanner in = new Scanner(System.in);

        // Capture sales for each product, for each of the 3 months
        for (int p = 0; p < names.length; p++) {
            for (int m = 0; m < 3; m++) {
                System.out.print("Enter number of sales for month " + (m + 1)
                        + " for " + names[p] + " mattress: ");
                sales[p][m] = in.nextInt();
            }
            System.out.println();
        }

        PrintProduct printer = new PrintProduct(new Product(names, sales));
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("*".repeat(40));
        printer.PrintTotalProductSales();
        printer.PrintAverageProductSales();
        printer.PrintMostPopularProduct();
    }
}

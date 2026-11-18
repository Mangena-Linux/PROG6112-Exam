package mattress;

import java.util.Scanner;

/** Launcher: choose Q1 (console report) or Q2 (GUI app). */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 1 for Sales Report (Q1) or 2 for GUI App (Q2): ");
        if (in.nextInt() == 1) {
            SalesReport.main(args);
        } else {
            ProductApp.main(args);
        }
    }
}

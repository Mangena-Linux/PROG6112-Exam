package mattress;

import javax.swing.*;
import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductApp extends JFrame {
    private final JTextField txtName = new JTextField();
    private final JComboBox<String> cboProduct = new JComboBox<>(
            new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
    private final JTextField txtPrice = new JTextField();

    public ProductApp() {
        super("Product App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Menu: File > Exit, Tools > Process / Clear
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        JMenu tools = new JMenu("Tools");
        JMenuItem process = new JMenuItem("Process");
        JMenuItem clear = new JMenuItem("Clear");
        file.add(exit);
        tools.add(process);
        tools.add(clear);
        bar.add(file);
        bar.add(tools);
        setJMenuBar(bar);

        JButton btnProcess = new JButton("PROCESS");
        add(new JLabel("  Customer Name:"));
        add(txtName);
        add(new JLabel("  Select Product:"));
        add(cboProduct);
        add(new JLabel("  Enter Price:"));
        add(txtPrice);
        add(new JLabel());
        add(btnProcess);

        // Button and menu item share the same logic
        btnProcess.addActionListener(e -> processSale());
        process.addActionListener(e -> processSale());
        clear.addActionListener(e -> clearForm());
        exit.addActionListener(e -> System.exit(0));
    }

    private void processSale() {
        String name = txtName.getText().trim();
        String product = (String) cboProduct.getSelectedItem();
        double price;
        try {
            price = Double.parseDouble(txtPrice.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.");
            return;
        }
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the customer name.");
            return;
        }

        ProductCalculations calc = new ProductCalculations(price);
        String details = "Customer Name: " + name
                + "\nProduct: " + product
                + "\nVAT: R " + calc.GetVat()
                + "\nCOMMISSION: R " + calc.GetCommission()
                + "\nTOTAL: R " + calc.GetTotal();

        JOptionPane.showMessageDialog(this, details);
        saveToFile(details);
    }

    private void saveToFile(String details) {
        try (PrintWriter out = new PrintWriter(new FileWriter("data.txt", true))) {
            out.println("DATA LOG");
            out.println("*".repeat(40));
            out.println(details);
            out.println("*".repeat(40));
            out.println();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not write data.txt: " + ex.getMessage());
        }
    }

    private void clearForm() {
        txtName.setText("");
        txtPrice.setText("");
        cboProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}

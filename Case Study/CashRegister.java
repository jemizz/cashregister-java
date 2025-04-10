import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;

public class CashRegister {
    private JTable cartTable;  // Add this class field

    public static void main(String[] args) {
        CashRegister sc = new CashRegister();
    }

    // Add these class fields at the top of the class
    private JLabel totalLabel;
    private JLabel balanceLabel;
    private JTextField cashField;
    private double currentTotal = 0.0;

    // Add this method to update the total
    private void updateTotal() {
        currentTotal = 0.0;
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String subtotalStr = ((String) model.getValueAt(i, 3)).replace("₱", "");
            currentTotal += Double.parseDouble(subtotalStr);
        }
        totalLabel.setText(String.format("%.2f", currentTotal));
    }

    // Modify the addToCart method to update total
    private void addToCart(String productInfo) {
        String[] parts = productInfo.split(" – ");
        String itemName = parts[0];
        String price = parts[1].replace("₱", "");
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        
        // Check if item already exists in cart
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(itemName)) {
                // Item exists, increment quantity
                int qty = (int) model.getValueAt(i, 1) + 1;
                double priceVal = Double.parseDouble(price);
                double subtotal = qty * priceVal;
                
                model.setValueAt(qty, i, 1);
                model.setValueAt("₱" + subtotal, i, 3);
                updateTotal();
                return;
            }
        }
        
        // Item doesn't exist, add new row
        model.addRow(new Object[]{itemName, 1, "₱" + price, "₱" + price});
        updateTotal();
    }

    public CashRegister() {
        JFrame frame = new JFrame("CASH REGISTER");
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255, 250, 250));
        frame.setLayout(new BorderLayout(10, 10));

        // Top Panel (Title)
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(255, 250, 250));
        JLabel titleLabel = new JLabel("Point of Sale");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);

        // Center Panel (Left: Product Buttons, Right: Cart Table)
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        centerPanel.setBackground(new Color(255, 250, 250));
        frame.add(centerPanel, BorderLayout.CENTER);

        // Create a left container using CardLayout to switch between main and overlay panels.
        final JPanel leftContainer = new JPanel(new CardLayout());
        leftContainer.setBackground(new Color(255, 250, 250));
        centerPanel.add(leftContainer);

        // Main product panel (grid of product buttons)
        final JPanel productPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        productPanel.setBackground(new Color(255, 250, 250));
        leftContainer.add(productPanel, "main");

        // Define a common action listener for all main product buttons to show the overlay.
        ActionListener showOverlayListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) leftContainer.getLayout();
                cl.show(leftContainer, "overlay");
            }
        };

        // Rice Meal Button
        JButton riceMealButton = new JButton("Rice Meal");
        riceMealButton.setLayout(new BorderLayout());
        riceMealButton.setBackground(new Color(255, 250, 250));
        riceMealButton.addActionListener(showOverlayListener);
        JPanel riceMealWrapper = new JPanel(new BorderLayout());
        riceMealWrapper.setBackground(new Color(255, 250, 250));
        riceMealWrapper.add(riceMealButton, BorderLayout.CENTER);
        productPanel.add(riceMealWrapper);

        // Burger Button
        JButton burgerButton = new JButton("Burger");
        burgerButton.setLayout(new BorderLayout());
        burgerButton.setBackground(new Color(255, 250, 250));
        burgerButton.addActionListener(showOverlayListener);
        JPanel burgerWrapper = new JPanel(new BorderLayout());
        burgerWrapper.setBackground(new Color(255, 250, 250));
        burgerWrapper.add(burgerButton, BorderLayout.CENTER);
        productPanel.add(burgerWrapper);

        // Sundae Button
        JButton sundaeButton = new JButton("Sundae");
        sundaeButton.setLayout(new BorderLayout());
        sundaeButton.setBackground(new Color(255, 250, 250));
        sundaeButton.addActionListener(showOverlayListener);
        JPanel sundaeWrapper = new JPanel(new BorderLayout());
        sundaeWrapper.setBackground(new Color(255, 250, 250));
        sundaeWrapper.add(sundaeButton, BorderLayout.CENTER);
        productPanel.add(sundaeWrapper);

        // Chicken Button
        JButton chickenButton = new JButton("Chicken");
        chickenButton.setLayout(new BorderLayout());
        chickenButton.setBackground(new Color(255, 250, 250));
        chickenButton.addActionListener(showOverlayListener);
        JPanel chickenWrapper = new JPanel(new BorderLayout());
        chickenWrapper.setBackground(new Color(255, 250, 250));
        chickenWrapper.add(chickenButton, BorderLayout.CENTER);
        productPanel.add(chickenWrapper);

        // Fries Button
        JButton friesButton = new JButton("Fries");
        friesButton.setLayout(new BorderLayout());
        friesButton.setBackground(new Color(255, 250, 250));
        friesButton.addActionListener(showOverlayListener);
        JPanel friesWrapper = new JPanel(new BorderLayout());
        friesWrapper.setBackground(new Color(255, 250, 250));
        friesWrapper.add(friesButton, BorderLayout.CENTER);
        productPanel.add(friesWrapper);

        // Drinks Button
        JButton drinksButton = new JButton("Drinks");
        drinksButton.setLayout(new BorderLayout());
        drinksButton.setBackground(new Color(255, 250, 250));
        drinksButton.addActionListener(showOverlayListener);
        JPanel drinksWrapper = new JPanel(new BorderLayout());
        drinksWrapper.setBackground(new Color(255, 250, 250));
        drinksWrapper.add(drinksButton, BorderLayout.CENTER);
        productPanel.add(drinksWrapper);

        // Create the overlay panel
        JPanel overlayPanel = new JPanel(new BorderLayout());
        overlayPanel.setBackground(new Color(240, 240, 255));
        leftContainer.add(overlayPanel, "overlay");

        // Overlay North Panel (Back button)
        JPanel overlayNorth = new JPanel(new BorderLayout());
        overlayNorth.setOpaque(false);
        JButton backButton = new JButton("Back");
        overlayNorth.add(backButton, BorderLayout.EAST);
        overlayPanel.add(overlayNorth, BorderLayout.NORTH);

        // Create panels for each category
        CardLayout overlayCardLayout = new CardLayout();
        JPanel overlayCenter = new JPanel(overlayCardLayout);
        overlayCenter.setBackground(new Color(240, 240, 255));
        overlayPanel.add(overlayCenter, BorderLayout.CENTER);

        // Rice Meal Panel
        JPanel riceMealPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        riceMealPanel.setBackground(new Color(240, 240, 255));
        
        JButton[] riceMealButtons = {
            new JButton("Chicken Teriyaki Bowl – ₱129"),
            new JButton("Beef Bulgogi Bowl – ₱139"),
            new JButton("Spicy Chicken Rice Bowl – ₱125"),
            new JButton("Pork Adobo Rice Bowl – ₱119"),
            new JButton("Shrimp Fried Rice Bowl – ₱135"),
            new JButton("Vegetarian Rice Bowl – ₱109")
        };
        
        for (JButton button : riceMealButtons) {
            button.addActionListener(e -> addToCart(button.getText()));
            riceMealPanel.add(button);
        }

        // Burger Panel
        JPanel burgerPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        burgerPanel.setBackground(new Color(240, 240, 255));
        
        JButton[] burgerButtons = {
            new JButton("Classic Cheeseburger – ₱89"),
            new JButton("Double Bacon Burger – ₱139"),
            new JButton("Spicy Jalapeño Burger – ₱109"),
            new JButton("BBQ Chicken Burger – ₱115"),
            new JButton("Veggie Burger – ₱105"),
            new JButton("Deluxe Mushroom Swiss Burger – ₱129")
        };
        
        for (JButton button : burgerButtons) {
            button.addActionListener(e -> addToCart(button.getText()));
            burgerPanel.add(button);
        }

        // Sundae Panel
        JPanel sundaePanel = new JPanel(new GridLayout(3, 2, 5, 5));
        sundaePanel.setBackground(new Color(240, 240, 255));
        
        JButton[] sundaeButtons = {
            new JButton("Hot Fudge Sundae – ₱59"),
            new JButton("Caramel Crunch Sundae – ₱65"),
            new JButton("Strawberry Sundae – ₱60"),
            new JButton("Oreo Sundae – ₱69"),
            new JButton("Brownie Sundae – ₱75"),
            new JButton("Cherry Nut Sundae – ₱62")
        };
        
        for (JButton button : sundaeButtons) {
            button.addActionListener(e -> addToCart(button.getText()));
            sundaePanel.add(button);
        }

        // Chicken Panel
        JPanel chickenPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        chickenPanel.setBackground(new Color(240, 240, 255));
        
        JButton[] chickenButtons = {
            new JButton("Crispy Fried Chicken (1-pc) – ₱99"),
            new JButton("Chicken Tenders (3 pcs) – ₱109"),
            new JButton("Chicken Nuggets (6 pcs) – ₱95"),
            new JButton("Spicy Chicken Wings (4 pcs) – ₱119"),
            new JButton("Popcorn Chicken – ₱89"),
            new JButton("Grilled Chicken Drumsticks (2 pcs) – ₱129")
        };
        
        for (JButton button : chickenButtons) {
            button.addActionListener(e -> addToCart(button.getText()));
            chickenPanel.add(button);
        }

        // Fries Panel
        JPanel friesPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        friesPanel.setBackground(new Color(240, 240, 255));
        
        JButton[] friesButtons = {
            new JButton("Classic French Fries (Medium) – ₱49"),
            new JButton("Curly Fries – ₱59"),
            new JButton("Loaded Cheese Fries – ₱75"),
            new JButton("Garlic Parmesan Fries – ₱69"),
            new JButton("Sweet Potato Fries – ₱65"),
            new JButton("Chili Cheese Fries – ₱79")
        };
        
        for (JButton button : friesButtons) {
            button.addActionListener(e -> addToCart(button.getText()));
            friesPanel.add(button);
        }

        // Drinks Panel
        JPanel drinksPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        drinksPanel.setBackground(new Color(240, 240, 255));
        
        JButton[] drinksButtons = {
            new JButton("Iced Cola (Regular) – ₱35"),
            new JButton("Fresh Lemonade – ₱45"),
            new JButton("Iced Tea – ₱40"),
            new JButton("Fruit Punch – ₱42"),
            new JButton("Milkshake (Choco/Vanilla/Strawberry) – ₱65"),
            new JButton("Bottled Water – ₱25")
        };
        
        for (JButton button : drinksButtons) {
            button.addActionListener(e -> addToCart(button.getText()));
            drinksPanel.add(button);
        }

        // Add all panels to overlay center
        overlayCenter.add(riceMealPanel, "rice");
        overlayCenter.add(burgerPanel, "burger");
        overlayCenter.add(sundaePanel, "sundae");
        overlayCenter.add(chickenPanel, "chicken");
        overlayCenter.add(friesPanel, "fries");
        overlayCenter.add(drinksPanel, "drinks");

        // Connect main buttons to their respective panels
        riceMealButton.addActionListener(e -> overlayCardLayout.show(overlayCenter, "rice"));
        burgerButton.addActionListener(e -> overlayCardLayout.show(overlayCenter, "burger"));
        sundaeButton.addActionListener(e -> overlayCardLayout.show(overlayCenter, "sundae"));
        chickenButton.addActionListener(e -> overlayCardLayout.show(overlayCenter, "chicken"));
        friesButton.addActionListener(e -> overlayCardLayout.show(overlayCenter, "fries"));
        drinksButton.addActionListener(e -> overlayCardLayout.show(overlayCenter, "drinks"));

        // Back button action
        backButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) leftContainer.getLayout();
            cl.show(leftContainer, "main");
        });

        // Right: Cart Panel with a table
        JPanel cartPanel = new JPanel(new BorderLayout(5, 5));
        cartPanel.setBackground(new Color(255, 250, 250));
        centerPanel.add(cartPanel);
        
        String[] columnNames = {"Item", "Qty", "Price", "Subtotal"};
        DefaultTableModel cartTableModel = new DefaultTableModel(columnNames, 0);
        cartTable = new JTable(cartTableModel);  // Assign to class field
        cartTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cartPanel.add(new JScrollPane(cartTable), BorderLayout.CENTER);

        // Bottom Panel (for additional controls)
        JPanel bottomPanel = new JPanel(null);
        bottomPanel.setBackground(new Color(255, 250, 250));
        bottomPanel.setPreferredSize(new Dimension(1000, 120));
        frame.add(bottomPanel, BorderLayout.SOUTH);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(255, 250, 250));
        deleteButton.setBounds(30, 20, 80, 30);
        bottomPanel.add(deleteButton);

        JLabel totalTextLabel = new JLabel("Total:");
        totalTextLabel.setBackground(new Color(255, 250, 250));
        totalTextLabel.setBounds(130, 25, 40, 20);
        bottomPanel.add(totalTextLabel);

        totalLabel = new JLabel("0.00");
        totalLabel.setBackground(new Color(255, 250, 250));
        totalLabel.setBounds(175, 25, 60, 20);
        bottomPanel.add(totalLabel);

        JLabel cashTextLabel = new JLabel("Cash:");
        cashTextLabel.setBackground(new Color(255, 250, 250));
        cashTextLabel.setBounds(260, 25, 40, 20);
        bottomPanel.add(cashTextLabel);

        cashField = new JTextField();
        cashField.setBackground(new Color(255, 250, 250));
        cashField.setBounds(305, 25, 60, 20);
        bottomPanel.add(cashField);

        JLabel balanceTextLabel = new JLabel("Balance:");
        balanceTextLabel.setBackground(new Color(255, 250, 250));
        balanceTextLabel.setBounds(390, 25, 60, 20);
        bottomPanel.add(balanceTextLabel);

        balanceLabel = new JLabel("0.00");
        balanceLabel.setBackground(new Color(255, 250, 250));
        balanceLabel.setBounds(455, 25, 60, 20);
        bottomPanel.add(balanceLabel);

        JButton payButton = new JButton("Pay");
        payButton.setBackground(new Color(255, 250, 250));
        payButton.setBounds(540, 20, 80, 30);
        bottomPanel.add(payButton);

        JButton printButton = new JButton("Print Receipt");
        printButton.setBackground(new Color(250, 20, 60));
        printButton.setBounds(740, 20, 120, 30);
        bottomPanel.add(printButton);

        // Continue: Add functionality for the bottom panel buttons

        // Delete selected item from the cart
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = cartTable.getSelectedRow();
                if (selectedRow != -1) {
                    ((DefaultTableModel) cartTable.getModel()).removeRow(selectedRow);
                    updateTotal();
                }
            }
        });

        // Process payment by computing the balance
        payButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double cash = Double.parseDouble(cashField.getText());
                    if (cash < currentTotal) {
                        JOptionPane.showMessageDialog(frame, "Not enough cash provided!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        double balance = cash - currentTotal;
                        balanceLabel.setText(String.format("%.2f", balance));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid cash amount!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Print receipt, show details in a dialog, and clear the cart.
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder receipt = new StringBuilder();
        
                // Generate date, time, and receipt number
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String fileDate = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                int receiptNumber = new Random().nextInt(1000000);
        
                receipt.append("==================== HBSHBHVD ======================\n");
                receipt.append("          \tAddress: Lorem Ipsum, 23-10\n");
                receipt.append("                   \tTel: 11223344\n\n");
                receipt.append("                     \tCASH RECEIPT\n");
                receipt.append("--------------------------------------------\n");
                receipt.append("Receipt No: \t").append(receiptNumber).append("\n");
                receipt.append("Date: \t").append(timeStamp).append("\n\n");
                receipt.append("--------------------------------------------\n");
        
                receipt.append(String.format("%-20s %-10s %-10s %-10s\n", "Item", "Qty", "Price", "Subtotal"));
                receipt.append("---------------------------------------------------\n");
        
                DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    String item = model.getValueAt(i, 0).toString();
                    String qty = model.getValueAt(i, 1).toString();
                    String price = model.getValueAt(i, 2).toString();
                    String subtotal = model.getValueAt(i, 3).toString();
        
                    receipt.append(String.format("%-20s %-10s %-10s %-10s\n", item, qty, price, subtotal));
                }
        
                receipt.append("---------------------------------------------------\n");
                double cash = 0;
                double balance = 0;
        
                try {
                    cash = Double.parseDouble(cashField.getText());
                    balance = cash - currentTotal;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid cash input. Cannot generate receipt.");
                    return;
                }
        
                receipt.append(String.format("Total: ₱%.2f\n", currentTotal));
                receipt.append(String.format("Cash: ₱%.2f\n", cash));
                receipt.append(String.format("Balance: ₱%.2f\n", balance));
                receipt.append("===================================================\n");
        
                // Write receipt to file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("receipt_" + fileDate + ".txt"))) {
                    writer.write(receipt.toString());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to write receipt to file.");
                }
        
                // Show receipt in dialog
                JTextArea textArea = new JTextArea(receipt.toString());
                textArea.setEditable(false);
                JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Receipt", JOptionPane.INFORMATION_MESSAGE);
        
                // Clear cart and reset fields
                model.setRowCount(0);
                updateTotal();
                cashField.setText("");
                balanceLabel.setText("0.00");
            }
        });
        
        
        frame.setVisible(true);
    }
}
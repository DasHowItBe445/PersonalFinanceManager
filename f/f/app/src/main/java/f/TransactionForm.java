package f;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TransactionForm extends JFrame {
    private JTextField amountField;
    private JTextField categoryField;
    private JComboBox<String> typeComboBox;
    private JTextField dateField;
    private JTextField descriptionField;
    private JButton addButton;

    public TransactionForm() {
        setTitle("Add Transaction");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));

        // Initialize and add GUI components
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();

        JLabel categoryLabel = new JLabel("Category ID:");
        categoryField = new JTextField();

        JLabel typeLabel = new JLabel("Type:");
        typeComboBox = new JComboBox<>(new String[]{"Debit", "Credit"});

        JLabel dateLabel = new JLabel("Date (yyyy-MM-dd):");
        dateField = new JTextField();

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionField = new JTextField();

        addButton = new JButton("Add Transaction");

        // Add components to the frame
        add(amountLabel);
        add(amountField);
        add(categoryLabel);
        add(categoryField);
        add(typeLabel);
        add(typeComboBox);
        add(dateLabel);
        add(dateField);
        add(descriptionLabel);
        add(descriptionField);
        add(new JLabel()); // Empty label for spacing
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTransaction();
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void addTransaction() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String type = (String) typeComboBox.getSelectedItem();
            int categoryId = Integer.parseInt(categoryField.getText());
            String date = dateField.getText();
            String description = descriptionField.getText();

            Transaction transaction = new Transaction(amount, type, categoryId, date, description);
            TransactionDAO transactionDAO = new TransactionDAO();
            transactionDAO.addTransaction(transaction);

            JOptionPane.showMessageDialog(this, "Transaction added successfully!");

            // Optionally fetch all transactions after adding
            transactionDAO.getAllTransactions();

            // Clear fields
            amountField.setText("");
            categoryField.setText("");
            dateField.setText("");
            descriptionField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Amount and Category ID.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error saving transaction. Please check your database connection.");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TransactionForm();
    }
}

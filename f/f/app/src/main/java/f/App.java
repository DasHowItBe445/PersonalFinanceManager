package f;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    public App() {
        setTitle("Personal finance_manager Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton addTransactionButton = new JButton("Add Transaction");
        addTransactionButton.addActionListener(e -> openTransactionForm());

        add(addTransactionButton);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void openTransactionForm() {
        new TransactionForm(); // Open the transaction form
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }
}

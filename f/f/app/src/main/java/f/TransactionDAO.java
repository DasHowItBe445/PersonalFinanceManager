package f;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;  // Add this import

public class TransactionDAO {

    public void addTransaction(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transactions (amount, type, category_id, date, description) Values (?,?,?,?,?)";
        // sql=sql+transaction.getAmount();
        try (Connection conn = DatabaseConnection.get_Connection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, transaction.getAmount());
            stmt.setString(2, transaction.getType());
            stmt.setInt(3, transaction.getCategoryId());
            stmt.setDate(4, java.sql.Date.valueOf(transaction.getDate()));
            stmt.setString(5, transaction.getDescription());
                System.out.println(stmt);
            // Debugging log for inserted transaction
            System.out.println("Inserting transaction: " + transaction.getAmount() + ", " + transaction.getType() + ", " +
                    transaction.getCategoryId() + ", " + transaction.getDate() + ", " + transaction.getDescription());

            stmt.executeUpdate();
            System.out.println("Transaction inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Optional: Fetch all transactions for debugging
    public void getAllTransactions() throws SQLException {
        String sql = "SELECT * FROM transactions";
        try (Connection conn = DatabaseConnection.get_Connection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                double amount = rs.getDouble("amount");
                String type = rs.getString("type");
                int categoryId = rs.getInt("category_id");
                String date = rs.getString("date");
                String description = rs.getString("description");

                System.out.println("Transaction ID: " + id + ", Amount: " + amount + ", Type: " + type +
                        ", Category ID: " + categoryId + ", Date: " + date + ", Description: " + description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


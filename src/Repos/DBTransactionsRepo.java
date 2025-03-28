package Repos;

import Models.Transactions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBTransactionsRepo extends DBRepo<Transactions> {
    public DBTransactionsRepo(String dbUrl) throws Exception{
        super(dbUrl);
    }

    @Override
    public void create(Transactions obj) {
        String sql = "INSERT INTO transactions (transaction_id, wine_id, transaction_type, date, quantity, price_per_bottle, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, obj.transaction_id);
            statement.setInt(2, obj.wine_id);
            statement.setString(3, obj.transaction_type);
            statement.setString(4, obj.date);
            statement.setInt(5, obj.quantity);
            statement.setInt(6, obj.price_per_bottle);
            statement.setInt(7, obj.user_id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Transactions get(Integer id) {
        String sql = "SELECT * FROM transactions WHERE transaction_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractFromResultSet(resultSet);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Transactions obj) {
        String sql = "UPDATE transactions SET wine_id = ?, transaction_type = ?, date = ?, quantity = ?, price_per_bottle = ?, user_id = ? WHERE transaction_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, obj.wine_id);
            statement.setString(2, obj.transaction_type);
            statement.setString(3, obj.date);
            statement.setInt(4, obj.quantity);
            statement.setInt(5, obj.price_per_bottle);
            statement.setInt(6, obj.user_id);
            statement.setInt(7, obj.transaction_id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM transactions WHERE transaction_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Transactions> getAll() {
        String sql = "SELECT * FROM transactions";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            List<Transactions> transactions = new ArrayList<>();
            while (resultSet.next()) {
                transactions.add(extractFromResultSet(resultSet));
            }
            return transactions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Transactions extractFromResultSet(ResultSet resultSet) throws SQLException {
        Transactions transaction = new Transactions(
                resultSet.getInt("transaction_id"),
                resultSet.getInt("wine_id"),
                resultSet.getString("transaction_type"),
                resultSet.getString("date"),
                resultSet.getInt("quantity"),
                resultSet.getInt("price_per_bottle"),
                resultSet.getInt("user_id")
        );
        return transaction;
    }
}

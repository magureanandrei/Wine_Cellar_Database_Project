package Repos;

import Models.Inventory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBInventoryRepo extends DBRepo<Inventory> {
    public DBInventoryRepo(String dbUrl) throws Exception{
        super(dbUrl);
    }

    @Override
    public void create(Inventory obj) {
        String sql = "INSERT INTO inventory (inventory_id, wine_id, location_id, quantity, bottle_size_ml) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, obj.inventory_id);
            statement.setInt(2, obj.wine_id);
            statement.setInt(3, obj.location_id);
            statement.setInt(4, obj.quantity);
            statement.setInt(5, obj.bottle_size_ml);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Inventory get(Integer id) {
        String sql = "SELECT * FROM inventory WHERE inventory_id = ?";
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
    public void update(Inventory obj) {
        String sql = "UPDATE inventory SET wine_id = ?, location_id = ?, quantity = ?, bottle_size_ml = ? WHERE inventory_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, obj.wine_id);
            statement.setInt(2, obj.location_id);
            statement.setInt(3, obj.quantity);
            statement.setInt(4, obj.bottle_size_ml);
            statement.setInt(5, obj.inventory_id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM inventory WHERE inventory_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Inventory> getAll() {
        String sql = "SELECT * FROM inventory";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            List<Inventory> inventory = new ArrayList<>();
            while (resultSet.next()) {
                inventory.add(extractFromResultSet(resultSet));
            }
            return inventory;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    protected Inventory extractFromResultSet(ResultSet resultSet) throws SQLException {
        return new Inventory(
                resultSet.getInt("inventory_id"),
                resultSet.getInt("wine_id"),
                resultSet.getInt("location_id"),
                resultSet.getInt("quantity"),
                resultSet.getInt("bottle_size_ml")
        );
    }
}

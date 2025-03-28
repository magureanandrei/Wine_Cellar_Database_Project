package Repos;

import Models.Supplier;
import Models.WineType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBSupplierRepo extends DBRepo<Supplier> {
    public DBSupplierRepo(String dbUrl) throws Exception{
        super(dbUrl);
    }

    @Override
    public void create(Supplier obj) {
        String sql = "INSERT INTO supplier (supplier_id, supplier_name, contact_email, phone, address) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, obj.supplier_id);
            statement.setString(2, obj.supplier_name);
            statement.setString(3, obj.contact_email);
            statement.setString(4, obj.phone);
            statement.setString(5, obj.address);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Supplier get(Integer id) {
        String sql = "SELECT * FROM supplier WHERE supplier_id = ?";
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
    public void update(Supplier obj) {
        String sql = "UPDATE supplier SET supplier_name = ?, contact_email = ?, phone = ?, address = ? WHERE supplier_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, obj.supplier_name);
            statement.setString(2, obj.contact_email);
            statement.setString(3, obj.phone);
            statement.setString(4, obj.address);
            statement.setInt(5, obj.supplier_id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM supplier WHERE supplier_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Supplier> getAll() {
        String sql = "SELECT * FROM supplier";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            List<Supplier> suppliers = new ArrayList<>();
            while (resultSet.next()) {
                suppliers.add(extractFromResultSet(resultSet));
            }
            return suppliers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Supplier extractFromResultSet(ResultSet resultSet) throws SQLException {
        return new Supplier(
                resultSet.getInt("supplier_id"),
                resultSet.getString("supplier_name"),
                resultSet.getString("contact_email"),
                resultSet.getString("phone"),
                resultSet.getString("address")
        );
    }
}

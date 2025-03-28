package Repos;

import Models.WineType;
import Models.Wines;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBWinesRepo extends DBRepo<Wines> {
    public DBWinesRepo(String dbUrl) throws Exception {
        super(dbUrl);
    }

    @Override
    public void create(Wines obj) {
        String sql = "INSERT INTO wines (wine_id, name, type_id, region_id, vintage_year, alcohol_percentage, supplier_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, obj.wine_id);
            statement.setString(2, obj.name);
            statement.setInt(3, obj.type_id);
            statement.setInt(4, obj.region_id);
            statement.setInt(5, obj.vintage_year);
            statement.setInt(6, obj.alcohol_percentage);
            statement.setInt(7, obj.supplier_id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Wines get(Integer id) {
        String sql = "SELECT * FROM wines WHERE wine_id = ?";
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
    public void update(Wines obj) {
        String sql = "UPDATE wines SET name = ?, type_id = ?, region_id = ?, vintage_year = ?, alcohol_percentage = ?, supplier_id = ?  WHERE wine_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, obj.name);
            statement.setInt(2, obj.type_id);
            statement.setInt(3, obj.region_id);
            statement.setInt(4, obj.vintage_year);
            statement.setInt(5, obj.alcohol_percentage);
            statement.setInt(6, obj.supplier_id);
            statement.setInt(7, obj.wine_id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM wines WHERE wine_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Wines> getAll() {
        String sql = "SELECT * FROM wines";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            List<Wines> wines = new ArrayList<>();
            while (resultSet.next()) {
                wines.add(extractFromResultSet(resultSet));
            }
            return wines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Wines extractFromResultSet(ResultSet resultSet) throws SQLException {
        return new Wines(
                resultSet.getInt("wine_id"),
                resultSet.getString("name"),
                resultSet.getInt("type_id"),
                resultSet.getInt("region_id"),
                resultSet.getInt("vintage_year"),
                resultSet.getInt("alcohol_percentage"),
                resultSet.getInt("supplier_id")
        );
    }
}

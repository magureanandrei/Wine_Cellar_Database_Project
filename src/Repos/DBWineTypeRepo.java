package Repos;

import Models.WineType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBWineTypeRepo extends DBRepo<WineType>{
    public DBWineTypeRepo(String dbUrl) throws Exception{
        super(dbUrl);
    }

    @Override
    public void create(WineType obj) {
        String sql = "INSERT INTO WineType (type_id, type_name) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, obj.wineType_id);
            statement.setString(2, obj.name);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WineType get(Integer id) {
        String sql = "SELECT * FROM WineType WHERE type_id = ?";
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
    public void update(WineType obj) {
        String sql = "UPDATE WineType SET type_name = ? WHERE type_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, obj.name);
            statement.setInt(2, obj.wineType_id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM WineType WHERE type_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<WineType> getAll() {
        String sql = "SELECT * FROM ";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            List<WineType> wineTypes = new ArrayList<>();
            while (resultSet.next()) {
                wineTypes.add(extractFromResultSet(resultSet));
            }
            return wineTypes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static WineType extractFromResultSet(ResultSet resultSet) throws SQLException {
        return new WineType(
                resultSet.getInt("type_id"),
                resultSet.getString("type_name")
        );
    }

}

package Repos;

import Models.CellarLocation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBCellarLocationRepo extends DBRepo<CellarLocation> {
    public DBCellarLocationRepo(String dbUrl) throws Exception{
        super(dbUrl);
    }

    @Override
    public void create(CellarLocation obj) {
        String sql = "INSERT INTO cellarlocation (location_id, section, rack_number, bottle_position) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, obj.location_id);
            statement.setString(2, obj.section);
            statement.setInt(3, obj.rack_number);
            statement.setInt(4, obj.bottle_position);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CellarLocation get(Integer id) {
        String sql = "SELECT * FROM cellarlocation WHERE location_id = ?";
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
    public void update(CellarLocation obj) {
        String sql = "UPDATE cellarlocation SET section = ?, rack_number = ?, bottle_position = ? WHERE location_id = ?";


        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, obj.section);
            statement.setInt(2, obj.rack_number);
            statement.setInt(3, obj.bottle_position);
            statement.setInt(4, obj.location_id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM cellarlocation WHERE location_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CellarLocation> getAll() {
        String sql = "SELECT * FROM cellarlocation";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            List<CellarLocation> locations = new ArrayList<>();
            while (resultSet.next()) {
                locations.add(extractFromResultSet(resultSet));
            }
            return locations;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    protected CellarLocation extractFromResultSet(ResultSet resultSet) throws SQLException {
        return new CellarLocation(
                resultSet.getInt("location_id"),
                resultSet.getString("section"),
                resultSet.getInt("rack_number"),
                resultSet.getInt("bottle_position")
        );
    }
}

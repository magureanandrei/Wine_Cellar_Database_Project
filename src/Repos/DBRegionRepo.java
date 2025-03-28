package Repos;

import Models.Region;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBRegionRepo extends DBRepo<Region>{
    public DBRegionRepo(String dbUrl) throws Exception{
        super(dbUrl);
    }

    @Override
    public void create(Region obj) {
            String sql = "INSERT INTO region (region_id, region_name, country) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, obj.region_id);
            statement.setString(2, obj.region_name);
            statement.setString(3, obj.country);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Region get(Integer id) {
        String sql = "SELECT * FROM region WHERE region_id = ?";
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
    public void update(Region obj) {
        String sql = "UPDATE region SET region_name = ? WHERE region_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, obj.region_name);
            statement.setString(2,obj.country);
            statement.setInt(3, obj.region_id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM region WHERE region_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Region> getAll() {
        String sql = "SELECT * FROM region";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            List<Region> regions = new ArrayList<>();
            while (resultSet.next()) {
                regions.add(extractFromResultSet(resultSet));
            }
            return regions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    protected Region extractFromResultSet(ResultSet resultSet) throws SQLException {
        return new Region(
                resultSet.getInt("region_id"),
                resultSet.getString("region_name"),
                resultSet.getString("country")
        );
    }
}

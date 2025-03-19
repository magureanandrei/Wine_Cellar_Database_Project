package Repos;

import Models.HasID;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBRepo <T extends HasID> implements Repository<T>,AutoCloseable {
    protected final Connection conn;

    public DBRepo(String dbUrl)  {
        try {
            conn = DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        conn.close();
    }
}

package dao;

import entity.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDAO extends BaseDAO {

    public Game save(Game g)
    {
        Connection conn = null;
        boolean autocommit = false;
        try {
            conn = getConn();
            autocommit = conn.getAutoCommit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new IllegalStateException("Onverwachte Connection error");
        }

        try(PreparedStatement ps = conn.prepareStatement("insert into Game values (?, ?)"))
        {
            conn.setAutoCommit(false);
            int key = -1;
            try(PreparedStatement ps2 = conn.prepareStatement("insert into Media values (NULL, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS))
            {
                ps2.setString(1, g.getTitel());
                ps2.setString(2, g.getBeschrijving());
                ps2.setDouble(3, g.getRating());
                ps2.executeUpdate();
                ResultSet rs = ps2.getGeneratedKeys();
                if(rs.next())
                    key = rs.getInt(1);
            }


            if(key!=-1)
            {
                ps.setInt(1, key);
                ps.setString(2, g.getUitgever());
                ps.executeUpdate();
            }
            conn.commit();
            g.setId(key);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(autocommit);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return g;
    }
}

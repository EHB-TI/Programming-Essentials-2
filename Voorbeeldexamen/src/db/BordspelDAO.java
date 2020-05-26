package db;

import entity.Bordspel;

import java.sql.*;
import java.util.ArrayList;

public class BordspelDAO extends BaseDAO{

    public void voegBordspelToe(Bordspel b)
    {
        try(Connection c = getConn())
        {
            PreparedStatement ps = c.prepareStatement("insert into Bordspel values (NULL, ?, ?, ?)");
            ps.setString(1, b.getNaam());
            ps.setDouble(2, b.getPrijs());
            ps.setInt(3, b.getSpeelduur());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Bordspel> geefAlleBordspellen()
    {
        ArrayList<Bordspel> spelen = new ArrayList<>();
        try(Connection c = getConn()) {
            Statement s = c.createStatement();
           ResultSet rs =  s.executeQuery("select * from Bordspel");
           while(rs.next())
           {
               spelen.add(new Bordspel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return spelen;
    }


}

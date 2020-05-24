package oefening2.db;

import java.sql.*;
import java.util.ArrayList;

import oefening2.entity.BoekVO;

public class BoekDAO extends BaseDAO {

    public BoekDAO() {
    }

    // andere manier van werken
    public BoekDAO(Connection con) {
        setConnection(con);
    }

    public int insert(BoekVO boekVO) throws SQLException {

        String sql = "INSERT INTO boeken VALUES(?,?,?)";

        Connection con = null;

        try {
            con = getConnection();
        } catch (SQLException throwables) {
            throw new IllegalStateException("Unexpected Error");
        }

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, boekVO.getIsbn());
            ps.setString(2, boekVO.getTitel());
            ps.setString(3, boekVO.getAuteur());
            return ps.executeUpdate();
        }
    }

    public ArrayList<BoekVO> selectAll() {
        ArrayList<BoekVO> list = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM boeken";


		Connection con = null;

		try {
			con = getConnection();
		} catch (SQLException throwables) {
			throw new IllegalStateException("Unexpected Error");
		}

        try(Statement s = con.createStatement()) {
            rs = s.executeQuery(sql);
            list = new ArrayList<BoekVO>();

            while (rs.next()) {
                list.add(fillVO(rs));
            }

            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public BoekVO selectOne(long isbn) {
        ResultSet rs = null;

        String sql = "SELECT * FROM boeken WHERE isbn=?";


		Connection con = null;

		try {
			con = getConnection();
		} catch (SQLException throwables) {
			throw new IllegalStateException("Unexpected Error");
		}

		try(PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, isbn);
            rs = ps.executeQuery();
            if (rs.next())
                return fillVO(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return null;
    }

    private BoekVO fillVO(ResultSet rs) throws SQLException {
        BoekVO boekVO = new BoekVO();
        boekVO.setIsbn(rs.getLong(1));
        boekVO.setAuteur(rs.getString("auteur"));
        boekVO.setTitel(rs.getString("titel"));
        return boekVO;
    }

    public int delete(BoekVO boekVO) {
        ResultSet rs = null;
        int resultaat = 0;
        String sql = "DELETE FROM boeken WHERE isbn=?";

		Connection con = null;

		try {
			con = getConnection();
		} catch (SQLException throwables) {
			throw new IllegalStateException("Unexpected Error");
		}

        try(PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, boekVO.getIsbn());
            resultaat = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return resultaat;
    }
}

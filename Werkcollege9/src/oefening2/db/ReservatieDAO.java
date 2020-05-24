package oefening2.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oefening2.entity.BoekVO;
import oefening2.entity.LidVO;
import oefening2.entity.ReservatieVO;


public class ReservatieDAO extends BaseDAO
{
	public int insert(ReservatieVO reservatieVO)
	{
		String sql = "INSERT INTO reservaties VALUES(?,?)";

		Connection con = null;

		try {
			con = getConnection();
		} catch (SQLException throwables) {
			throw new IllegalStateException("Unexpected Error");
		}
		 
		try (PreparedStatement ps = con.prepareStatement(sql))
		{
			ps.setInt(1, reservatieVO.getLidVO().getId());
			ps.setLong(2, reservatieVO.getBoekVO().getIsbn());

			return ps.executeUpdate();
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());;
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	public ArrayList<BoekVO> selectVanLid(LidVO lidVO)
	{
		ResultSet rs = null;
		ArrayList<BoekVO> list = null;
		String sql = "SELECT * FROM reservaties WHERE id=?";

		Connection con = null;

		try {
			con = getConnection();
		} catch (SQLException throwables) {
			throw new IllegalStateException("Unexpected Error");
		}

		try (PreparedStatement ps = con.prepareStatement(sql))
		{
			ps.setLong(1, lidVO.getId());
			rs = ps.executeQuery();
			list = new ArrayList<BoekVO>();
			while (rs.next())
				list.add(fillBoekVO(rs));
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());;
		}

		return list;
	}

	private BoekVO fillBoekVO(ResultSet rs) throws SQLException
	{
		BoekDAO boekDAO = new BoekDAO();
		return boekDAO.selectOne(rs.getLong("isbn"));
	}
}

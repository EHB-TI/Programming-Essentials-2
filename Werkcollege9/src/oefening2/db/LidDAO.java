package oefening2.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oefening2.entity.LidVO;


public class LidDAO extends BaseDAO
{
	public int insert(LidVO lidVO)
	{
		String sql = "INSERT INTO leden VALUES(?,?,?)";

		Connection con = null;

		try {
			con = getConnection();
		} catch (SQLException throwables) {
			throw new IllegalStateException("Unexpected Error");
		}

		try (PreparedStatement ps = con.prepareStatement(sql))
		{
			ps.setLong(1, lidVO.getId());
			ps.setString(2, lidVO.getNaam());
			ps.setString(3, lidVO.getPaswoord());
			return ps.executeUpdate();
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());;
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public ArrayList<LidVO> selectAll()
	{
		ArrayList<LidVO> list = null;

		ResultSet rs = null;
			
		String sql = "SELECT * FROM tblBIBBoeken";

		Connection con = null;

		try {
			con = getConnection();
		} catch (SQLException throwables) {
			throw new IllegalStateException("Unexpected Error");
		}

		try (PreparedStatement ps = con.prepareStatement(sql))
		{
			rs = ps.executeQuery();
			list = new ArrayList<LidVO>();
			
			while (rs.next())
			{
				list.add(fillVO(rs));
			}
				
			return list;
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());;
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public LidVO selectOne(String naam)
	{
		ResultSet rs = null;
			
		String sql = "SELECT * FROM leden WHERE naam=?";

		Connection con = null;

		try {
			con = getConnection();
		} catch (SQLException throwables) {
			throw new IllegalStateException("Unexpected Error");
		}

		try (PreparedStatement ps = con.prepareStatement(sql))
		{
			ps.setString(1,naam);
			rs = ps.executeQuery();
			if (rs.next())
				return fillVO(rs);
			else
				return null;
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());;
			throw new RuntimeException(e.getMessage());
		}
	}

	private LidVO fillVO(ResultSet rs) throws SQLException
	{
		LidVO lidVO = new LidVO();
		lidVO.setId(rs.getInt(1));
		lidVO.setNaam(rs.getString("naam"));
		lidVO.setPaswoord(rs.getString("paswoord"));
		
		return lidVO;
	}
}

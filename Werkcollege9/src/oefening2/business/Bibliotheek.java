package oefening2.business;

import java.sql.SQLException;

import oefening2.db.BoekDAO;
import oefening2.db.DatabaseSingleton;
import oefening2.db.LidDAO;
import oefening2.db.ReservatieDAO;
import oefening2.entity.BoekVO;
import oefening2.entity.LidVO;
import oefening2.entity.ReservatieVO;

public class Bibliotheek {
	// databank vullen
	public void initializeDatabase() {
		// boek toevoegen
		BoekVO boekVO = new BoekVO();
		boekVO.setAuteur("Douglas Adams");
		boekVO.setTitel("The Hitchhiker's Guide to the Galaxy");
		boekVO.setIsbn(1000);
		BoekDAO boekDAO = new BoekDAO();

		try {
			boekDAO.insert(boekVO);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		// lid toevoegen
		LidVO lidVO = new LidVO();

		lidVO.setNaam("van den Broek");
		lidVO.setPaswoord("1234");
		LidDAO lidDAO = new LidDAO();

		lidDAO.insert(lidVO);

		// reservatie aanmaken
		ReservatieVO reservatieVO = new ReservatieVO();
		reservatieVO.setBoekVO(boekVO);
		reservatieVO.setLidVO(lidDAO.selectOne("van den Broek"));
		ReservatieDAO reservatieDAO = new ReservatieDAO();
		reservatieDAO.insert(reservatieVO);

	}

	public static void main(String[] str) {
		Bibliotheek bibliotheek = new Bibliotheek();
		bibliotheek.initializeDatabase();
		// ...
		try {
			DatabaseSingleton.getDatabaseSingleton().getConnection(true)
					.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

package logic;

import dao.GameDAO;
import entity.Game;

public class VoorbeeldMainDAO {
    public static void main(String[] args) {
        GameDAO gdao = new GameDAO();
        gdao.save(new Game("Half-Life", "Half-Life is a series of first-person shooter games developed and published by Valve. The games combine shooting combat, puzzles, and storytelling.", 9.6, "Valve"));
        gdao.save(new Game("Overwatch" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", 6.7, "Blizzard"));
        gdao.save(new Game("Minecraft", "Lorem ipsum dolor sit amet, consectetur adipiscing...", 7.5, "Majong Studios"));
    }
}

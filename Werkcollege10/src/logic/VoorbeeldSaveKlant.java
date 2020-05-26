package logic;

import entity.Film;
import entity.Game;
import entity.Klant;

public class VoorbeeldSaveKlant {

    public static void main(String[] args) {

        Klant jos = new Klant("Jos");
        jos.huur(new Film("The Shawshank Redemption", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", 9.3, "Frank Darabont", Film.Disktype.DVD));
        jos.huur(new Film("The Godfather ", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", 9.2, "Francis Ford Coppola", Film.Disktype.BD));
        jos.huur(new Game("Half-Life", "Half-Life is a series of first-person shooter games developed and published by Valve. The games combine shooting combat, puzzles, and storytelling.", 9.6, "Valve"));
        jos.save();

        Klant jef = new Klant("Jef");
        jef.huur(new Game("Overwatch" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", 6.7, "Blizzard"));
        jef.huur(new Game("Minecraft", "Lorem ipsum dolor sit amet, consectetur adipiscing...", 7.5, "Majong Studios"));
        jef.save();
    }
}

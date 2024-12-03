
import gameAndStats.Difficulties;
import gameAndStats.Game;
import gameAndStats.rulesets.InvalidRulesException;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

import players.Computer;
import players.Player;

public class Main {
    public static void main(String[] args) throws InvalidRulesException {
        Player p = new Player();
        Difficulties difficulty = p.selectDifficulty();
        Computer computer = new Computer(difficulty);
        Game game = new Game(p, computer);
        game.run();
        game.getFinalScore();
    }
}

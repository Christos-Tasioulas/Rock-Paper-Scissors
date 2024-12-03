import gameAndStats.Difficulties;
import gameAndStats.Game;
import gameAndStats.rulesets.InvalidRulesException;
import players.Computer;
import players.Origin;
import players.Player;

public class Main {
    public static void main(String[] args) throws InvalidRulesException {
        Player p = new Player(Origin.TERMINAL);
        Difficulties difficulty = p.selectDifficulty();
        Computer computer = new Computer(difficulty);
        Game game = new Game(p, computer);
        game.run();
        game.getFinalScore();
    }
}

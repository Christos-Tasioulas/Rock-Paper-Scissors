package gameAndStats;

import gameAndStats.rulesets.BasicRuleSet;
import gameAndStats.rulesets.BigBangTheoryRuleSet;
import gameAndStats.rulesets.InvalidRulesException;
import gameAndStats.rulesets.RuleSet;
import gameAndStats.stats.Results;
import gameAndStats.stats.Score;
import org.apache.commons.lang3.StringUtils;
import players.Computer;
import players.Player;

import java.util.Arrays;
import java.util.List;

public class Game {
    Player player;
    Computer computer;
    List<String> validOptions;
    Score score;
    RuleSet ruleSet;

    public Game(Player p, Computer computer) {
        this.player = p;
        this.computer = computer;
        validOptions = Arrays.asList(computer.getGameDifficulty().getValidOptions());
        score = new Score();
        ruleSet = createRuleSet(computer.getGameDifficulty());
    }

    private RuleSet createRuleSet(Difficulties difficulty) {
        switch (difficulty) {
            case BASIC:
                return new BasicRuleSet();
            case BIG_BANG_THEORY:
                return new BigBangTheoryRuleSet();
            default:
                throw new IllegalArgumentException("Invalid Difficulty");
        }
    }

    private boolean isValid(String userChoice) {
        return validOptions.stream().anyMatch(e -> e.equalsIgnoreCase(userChoice));
    }

    private void handleResult(Results result) {
        switch (result) {
            case TIE:
                score.addTie();
                break;
            case PLAYER_WIN:
                score.addWin("PLAYER");
                break;
            case COMPUTER_WIN:
                score.addWin("COMPUTER");
                break;
        }
    }

    public void run() throws InvalidRulesException {
        while(true) {
            System.out.println(String.join(" ", validOptions));
            player.select();
            if (StringUtils.containsIgnoreCase(player.getCurrentSelection(), "Done")) break;
            else if (!isValid(player.getCurrentSelection())) {
                System.out.println("Your choice is invalid! Select Again!");
                continue;
            }
            computer.select();
            Results result = ruleSet.applyRules(player.getCurrentSelection(), computer.getCurrentSelection());
            handleResult(result);
            System.out.println(result.getMessage() + " Computer Selected: " + computer.getCurrentSelection() + ".");
        }
    }

    public void getFinalScore() {
        System.out.println(score.toString());
    }
}

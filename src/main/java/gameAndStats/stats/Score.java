package gameAndStats.stats;

public class Score {
    int playerWins;
    int ties;
    int computerWins;

    public Score() {
        playerWins = 0;
        ties = 0;
        computerWins = 0;
    }

    public void addWin(String competitor) {
        if (competitor.equalsIgnoreCase("Player")) playerWins++;
        else if (competitor.equalsIgnoreCase("Computer")) computerWins++;
        else throw new IllegalArgumentException("Player and Computer are the only valid competitors");
    }

    public void addTie() {
        ties++;
    }

    @Override
    public String toString() {
        return "Final score: " + "\n"
                + "Player Wins: " + playerWins + "\n"
                + "Computer Wins: " + computerWins + "\n"
                + "Ties: " + ties;
    }
}

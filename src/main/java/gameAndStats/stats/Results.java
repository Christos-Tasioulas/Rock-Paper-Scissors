package gameAndStats.stats;

public enum Results {
    TIE("Game tied!"), COMPUTER_WIN("You Lost!"), PLAYER_WIN("You Won!");
    final String message;

    Results(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

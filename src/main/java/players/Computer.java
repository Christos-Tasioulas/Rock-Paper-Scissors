package players;

import gameAndStats.Difficulties;

import java.util.Random;

public class Computer extends User {
    Difficulties gameDifficulty;
    public Computer(Difficulties difficulty) {
        this.gameDifficulty = difficulty;
    }

    public Difficulties getGameDifficulty() {
        return gameDifficulty;
    }

    @Override
    public void select() {
        String[] validOptions = gameDifficulty.getValidOptions();
        Random random = new Random();
        int index = random.nextInt(validOptions.length);
        currentSelection = validOptions[index];
    }
}

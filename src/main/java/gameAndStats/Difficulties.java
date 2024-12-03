package gameAndStats;

import java.util.ArrayList;
import java.util.List;

public enum Difficulties {
    BASIC("Basic", new String[]{"Rock", "Paper", "Scissors"}),
    BIG_BANG_THEORY("Big Bang Theory", new String[]{"Rock", "Paper", "Scissors", "Lizard", "Spock"});

    private final String difficultyName;
    private final String[] validOptions;

    Difficulties(String difficultyName, String[] validOptions) {
        this.difficultyName = difficultyName;
        this.validOptions = validOptions;
    }

    public String getDifficultyName() {
        return difficultyName;
    }

    public String[] getValidOptions() {
        return validOptions;
    }

    public static List<String> allDifficulties() {
        List<String> difficulties = new ArrayList<String>();
        for (Difficulties d : Difficulties.values()) {
            difficulties.add(d.difficultyName);
        }
        return difficulties;
    }

    public static Difficulties getDifficultyByName(String selectedDifficulty) {
        if (selectedDifficulty == null || selectedDifficulty.isEmpty()) {
            throw new IllegalArgumentException("Difficulty name cannot be null or empty.");
        }

        for (Difficulties d : Difficulties.values()) {
            if (d.difficultyName.equalsIgnoreCase(selectedDifficulty)) {
                return d;
            }
        }

        throw new IllegalArgumentException("No difficulty found with name: " + selectedDifficulty);
    }
}

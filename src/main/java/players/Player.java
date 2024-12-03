package players;

import gameAndStats.Difficulties;

import java.util.List;
import java.util.Scanner;

public class Player extends User{
    Origin origin;

    public Player(Origin origin) {
        this.origin = origin;
    }

    public Difficulties selectDifficulty() {
        System.out.println("Select Difficulty:");
        List<String> difficulties = Difficulties.allDifficulties();
        System.out.println(String.join(" ", difficulties));
        Scanner scanner = new Scanner(System.in);
        String selectedDifficulty = scanner.nextLine();
        return Difficulties.getDifficultyByName(selectedDifficulty);
    }

    @Override
    public void select() {
        switch (this.origin) {
            case APP:
                System.out.println("No App yet.");
                break;
            case TERMINAL:
                selectFromTerminal();
        }
    }

    private void selectFromTerminal() {
        Scanner scanner = new Scanner(System.in);
        currentSelection = scanner.nextLine();
    }
}

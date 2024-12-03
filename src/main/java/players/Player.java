package players;

import gameAndStats.Difficulties;

import java.util.List;
import java.util.Scanner;

public class Player extends User{
    public Player() {
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
        Scanner scanner = new Scanner(System.in);
        currentSelection = scanner.nextLine();
    }
}

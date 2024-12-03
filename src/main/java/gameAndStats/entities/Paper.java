package gameAndStats.entities;

import gameAndStats.Difficulties;

public class Paper extends Entity{
    public Paper() {
        entityType = "Paper";
        validDifficulties.add(Difficulties.BASIC);
        validDifficulties.add(Difficulties.BIG_BANG_THEORY);
        strongerEntities.add("Scissors");
        strongerEntities.add("Lizard");
        weakerEntities.add("Rock");
        weakerEntities.add("Spock");
    }
}

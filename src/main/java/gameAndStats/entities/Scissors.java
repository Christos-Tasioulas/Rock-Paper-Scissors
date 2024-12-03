package gameAndStats.entities;

import gameAndStats.Difficulties;

public class Scissors extends Entity{
    public Scissors() {
        entityType = "Scissors";
        validDifficulties.add(Difficulties.BASIC);
        validDifficulties.add(Difficulties.BIG_BANG_THEORY);
        strongerEntities.add("Rock");
        strongerEntities.add("Spock");
        weakerEntities.add("Paper");
        weakerEntities.add("Lizard");
    }
}

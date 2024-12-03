package gameAndStats.entities;

import gameAndStats.Difficulties;

public class Spock extends Entity {
    public Spock() {
        entityType = "Spock";
        validDifficulties.add(Difficulties.BIG_BANG_THEORY);
        weakerEntities.add("Scissors");
        weakerEntities.add("Rock");
        strongerEntities.add("Paper");
        strongerEntities.add("Lizard");
    }
}

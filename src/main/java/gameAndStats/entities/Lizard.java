package gameAndStats.entities;

import gameAndStats.Difficulties;

public class Lizard extends Entity {
    public Lizard() {
        entityType = "Lizard";
        validDifficulties.add(Difficulties.BIG_BANG_THEORY);
        strongerEntities.add("Scissors");
        strongerEntities.add("Rock");
        weakerEntities.add("Paper");
        weakerEntities.add("Spock");
    }
}

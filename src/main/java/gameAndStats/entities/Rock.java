package gameAndStats.entities;

import gameAndStats.Difficulties;

public class Rock extends Entity{
    public Rock() {
        entityType = "Rock";
        validDifficulties.add(Difficulties.BASIC);
        validDifficulties.add(Difficulties.BIG_BANG_THEORY);
        strongerEntities.add("Paper");
        strongerEntities.add("Spock");
        weakerEntities.add("Scissors");
        weakerEntities.add("Lizard");
    }
}

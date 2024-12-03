package gameAndStats.entities;

import gameAndStats.Difficulties;

import java.util.ArrayList;
import java.util.List;

public class Entity {
    protected final List<Difficulties> validDifficulties = new ArrayList<>();
    protected final List<Entity> beats = new ArrayList<>();
    protected final List<String> weakerEntities = new ArrayList<>();
    protected final List<Entity> loses = new ArrayList<>();
    protected final List<String> strongerEntities = new ArrayList<>();
    String entityType;

    public List<String> getWeakerEntities() {
        return weakerEntities;
    }

    public List<String> getStrongerEntities() {
        return strongerEntities;
    }

    public String getEntityType() {
        return entityType;
    }

    public boolean isInValidDifficulties(Difficulties difficulty) {
        return validDifficulties.contains(difficulty);
    }

    public void addEntityItBeats(Entity e) {
        beats.add(e);
    }

    public void addEntityItLosesFrom(Entity e) {
        loses.add(e);
    }

    public boolean beatsEntity(Entity e) {
        return beats.contains(e);
    }
    
    public boolean losesToEntity(Entity e) {
        return loses.contains(e);
    }
}

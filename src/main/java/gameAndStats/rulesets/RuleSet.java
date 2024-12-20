package gameAndStats.rulesets;

import gameAndStats.Difficulties;
import gameAndStats.entities.Entity;
import gameAndStats.stats.Results;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class RuleSet {
    private static Difficulties difficulty;
    static List<Entity> allEntities = new ArrayList<>();

    public RuleSet(Difficulties difficulty) {
        RuleSet.difficulty = difficulty;
    }

    public Results applyRules(String playerSelection, String computerSelection) throws InvalidRulesException {
        Entity playerEntity = findEntityByType(playerSelection);
        Entity computerEntity = findEntityByType(computerSelection);
        Results result;
        if (playerEntity == computerEntity) {
            result = Results.TIE;
        }
        else if (playerEntity.beatsEntity(computerEntity) && computerEntity.losesToEntity(playerEntity)) {
            result = Results.PLAYER_WIN;
        }
        else if (computerEntity.beatsEntity(playerEntity) && playerEntity.losesToEntity(computerEntity)) {
            result = Results.COMPUTER_WIN;
        }
        else throw new InvalidRulesException("The game rules are invalid!");
        return result;
    }

    protected void createRules() {
        for (Entity entity : allEntities) {
            createRulesForEntity(entity);
        }
    }

    private void createRulesForEntity(Entity e) {
        addEntities(e.getWeakerEntities(), e::addEntityItBeats);
        addEntities(e.getStrongerEntities(), e::addEntityItLosesFrom);
    }

    private void addEntities(List<String> entities, Consumer<Entity> addEntityMethod) {
        for (String entity : entities) {
            Entity foundEntity = findEntityByType(entity);
            if (foundEntity != null) {
                addEntityMethod.accept(foundEntity);
            }
        }
    }

    public static Entity findEntityByType(String type) {
        Optional<Entity> entity = allEntities.stream()
                .filter(p -> p.getEntityType().equals(type))
                .filter(p -> p.isInValidDifficulties(difficulty))
                .findFirst();
        return entity.orElse(null);
    }
}

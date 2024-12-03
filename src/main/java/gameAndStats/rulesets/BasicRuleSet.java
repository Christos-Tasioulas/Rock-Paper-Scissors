package gameAndStats.rulesets;

import gameAndStats.Difficulties;
import gameAndStats.entities.*;

import java.util.List;
import java.util.Optional;

public class BasicRuleSet extends RuleSet {

    public BasicRuleSet() {
        super(Difficulties.BASIC);
        allEntities.add(new Rock());
        allEntities.add(new Paper());
        allEntities.add(new Scissors());
        createRules();
    }

    private void createRulesForEntity(Entity e) {
        addEntitiesItLosesFrom(e);
        addEntitiesItBeats(e);
    }

    protected void createRules() {
        for (Entity entity : allEntities) {
            createRulesForEntity(entity);
        }
    }

    private void addEntitiesItBeats(Entity e) {
        List<String> weakerEntities = e.getWeakerEntities();
        for (String entity : weakerEntities) {
            e.addEntityItBeats(findEntityByType(entity));
        }
    }

    private void addEntitiesItLosesFrom(Entity e) {
        List<String> strongerEntities = e.getStrongerEntities();
        for (String entity : strongerEntities) {
            e.addEntityItLosesFrom(findEntityByType(entity));
        }
    }

    public static Entity findEntityByType(String type) {
        Optional<Entity> entity = allEntities.stream()
                .filter(p -> p.getEntityType().equals(type))
                .filter(p -> p.isInValidDifficulties(Difficulties.BASIC))
                .findFirst();
        return entity.orElse(null);
    }
}

package gameAndStats.rulesets;

import gameAndStats.Difficulties;
import gameAndStats.entities.Paper;
import gameAndStats.entities.Rock;
import gameAndStats.entities.Scissors;

public class BasicRuleSet extends RuleSet {

    public BasicRuleSet() {
        super(Difficulties.BASIC);
        allEntities.add(new Rock());
        allEntities.add(new Paper());
        allEntities.add(new Scissors());
        createRules();
    }
}

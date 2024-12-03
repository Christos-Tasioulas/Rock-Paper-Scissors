package gameAndStats.rulesets;

import gameAndStats.Difficulties;
import gameAndStats.entities.*;

public class BigBangTheoryRuleSet extends RuleSet{
    public BigBangTheoryRuleSet() {
        super(Difficulties.BIG_BANG_THEORY);
        allEntities.add(new Rock());
        allEntities.add(new Paper());
        allEntities.add(new Scissors());
        allEntities.add(new Lizard());
        allEntities.add(new Spock());
        createRules();
    }
}

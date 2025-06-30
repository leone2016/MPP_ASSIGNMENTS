package lab5.prob1.rulesets;

import lab5.prob1.gui.BookWindow;
import lab5.prob1.gui.CDWindow;

import java.awt.Component;
import java.util.HashMap;


final public class RuleSetFactory {
	private RuleSetFactory(){}
	static HashMap<Class<? extends Component>, RuleSet> map = new HashMap<>();

	static {
		map.put(BookWindow.class, new BookRuleSet());
		map.put(CDWindow.class, new CDRuleSet());
	}

	public static RuleSet getRuleSet(Component c) {
		RuleSet ruleset = map.get(c.getClass());
		if (ruleset == null) {
			throw new IllegalArgumentException("No RuleSet found for this component.");
		}
		return ruleset;
	}
}

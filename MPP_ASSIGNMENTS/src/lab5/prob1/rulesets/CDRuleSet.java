package lab5.prob1.rulesets;

import lab5.prob1.gui.CDWindow;

import java.awt.Component;


/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class CDRuleSet implements RuleSet {

	@Override
	public void applyRules(Component ob) throws RuleException {
		CDWindow cdWin = (CDWindow) ob;

		String artist = cdWin.getArtistValue();
		String title = cdWin.getTitleValue();
		String price = cdWin.getPriceValue();

		if (artist.isEmpty() || title.isEmpty() || price.isEmpty()) {
			throw new RuleException("Please fill up all fields");
		}
		if (!price.matches("\\d+\\.\\d{2}")) {
			throw new RuleException("Price must be a valid number with two decimal places.");
		}
		if (Double.parseDouble(price) <= 0.49) {
			throw new  RuleException("Price must be greater than 0.49.");
		}
		
	}
	
}

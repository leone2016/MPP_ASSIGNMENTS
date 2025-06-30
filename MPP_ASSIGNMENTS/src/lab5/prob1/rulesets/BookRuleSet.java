package lab5.prob1.rulesets;

import lab5.prob1.gui.BookWindow;

import java.awt.Component;



/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places 
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {

	@Override
	public void applyRules(Component ob) throws RuleException {
		BookWindow bookWin = (BookWindow) ob;

		String isbn = bookWin.getIsbnValue();
		String title = bookWin.getTitleValue();
		String price = bookWin.getPriceValue();

		if (isbn.isEmpty() || title.isEmpty() || price.isEmpty()) {
			throw new RuleException("All fields must be nonempty.");
		}

		if (!isbn.matches("\\d{10}|\\d{13}")) {
			throw new RuleException("ISBN must be numeric and contain 10 or 13 digits.");
		}

		if (isbn.length() == 10 && !(isbn.startsWith("0") || isbn.startsWith("1"))) {
			throw new RuleException("10-digit ISBN must start with 0 or 1.");
		}

		if (isbn.length() == 13 && !(isbn.startsWith("978") || isbn.startsWith("979"))) {
			throw new RuleException("13-digit ISBN must start with 978 or 979.");
		}

		if (!price.matches("\\d+\\.\\d{2}")) {
			throw new RuleException("Price must be a valid number with two decimal places.");
		}

		if (Double.parseDouble(price) <= 0.49) {
			throw new RuleException("Price must be greater than 0.49.");
		}
		
	}

}

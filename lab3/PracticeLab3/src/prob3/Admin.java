package prob3;


public class Admin {
	public static double computeTotalRent(Property[] properties) {
		double totalRent = 0;
		for (Property property : properties) {
//			if (o instanceof House) {
//				House h = (House) o;
				totalRent += property.computeRent();
//			}
//			else if (o instanceof Condo) {
//				Condo h = (Condo) o;
//				totalRent += h.computeRent();
//			}
//			else if (o instanceof Trailer) {
//				Trailer h = (Trailer) o;
//				totalRent += h.computeRent();
//			}
		}
		return totalRent;
	}

	/**
	 * Finds properties in the given array that are located in the specified city.
	 *
	 * @param city the city to search for properties
	 * @return an array of properties located in the specified city
	 */
	public static Property[] findPropertyByCity(Property[] properties, String city) {
		Property[] result = new Property[properties.length];
		int count = 0;
		for (Property property : properties) {
			if (property.getAddress().getCity().equalsIgnoreCase(city)) {
				result[count++] = property;
			}
		}
		// Resize the result array to the actual number of found properties
		Property[] finalResult = new Property[count];
		System.arraycopy(result, 0, finalResult, 0, count);
		return finalResult;
	}
}

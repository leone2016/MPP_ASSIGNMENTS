package lab3.PracticeLab3.src.prob3;



public class Trailer extends Property {
	private static final double RENT = 500;
	public Trailer(Address address) {
		super(address);
	}

	@Override
	public double computeRent(){
		return RENT;
	}
	
}

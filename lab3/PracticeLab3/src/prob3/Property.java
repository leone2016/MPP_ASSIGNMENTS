package lab3.PracticeLab3.src.prob3;


public abstract class Property {
    private Address address;

    public Property(Address address) {
        this.address = address;
    }
    public Address getAddress() {
        return address;
    }

    public abstract double computeRent();

    @Override
    public String toString() {
        return "\nProperty{" +
                "address=" + address.getCity() + " " + address.getStreet() + ", " + address.getState() + " " + address.getZip() +
                ", rent=" + computeRent() +
                "}\n";
    }
}

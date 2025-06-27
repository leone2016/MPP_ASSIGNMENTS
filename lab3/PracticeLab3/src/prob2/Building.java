package prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private double maintenanceCost;
    private List<Apartment> apartments;

    public Building(double  maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
//        this.rent = rent;
        apartments = new ArrayList<Apartment>();
    }

    public void addApartment(Apartment apartment) {
        this.apartments.add(apartment);
    }

    public double calcProfit() {
        double profits = 0;
        for(Apartment apartment: apartments) {
            profits+= apartment.getRent();
        }
        return profits-maintenanceCost;
    }



}

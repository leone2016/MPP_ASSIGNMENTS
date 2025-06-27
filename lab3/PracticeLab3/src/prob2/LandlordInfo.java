package prob2;


import java.util.ArrayList;
import java.util.List;

public class LandlordInfo {
    private List<Building> buildings;

    public LandlordInfo() {
        this.buildings = new ArrayList<>();
    }
    public double calcProfits() {
        double profits = 0;
        for(Building b: buildings) {
            profits += b.calcProfit();
        }
        return profits;
    }

    public void addBuilding(Building newBuilding) {
        this.buildings.add(newBuilding);
    }
}

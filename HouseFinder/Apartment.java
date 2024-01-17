public class Apartment extends House {
    private int floor;
    private int energyCode;
    private double cost;

    public Apartment(double area, int numOfRooms, String address, String city, double cost, int energyCode, int floor) {
        super(area, numOfRooms, address, city, cost);
        this.floor = floor;
        this.energyCode = energyCode;
        this.cost = cost;
    }

    public int getFloor() {
        return floor;
    }
    
    public int getEnergyCode() {
        return energyCode;
    }
    
    public double getCost() {
        return cost;
    }
}

public class Villa extends House {
    private boolean pool;
    private int numFloors;
    private double cost;

    public Villa(double area, int numOfRooms, String address, String city, double cost, boolean pool, int numFloors) {
        super(area, numOfRooms, address, city, cost);
        this.pool = pool;
        this.numFloors = numFloors;
        this.cost = cost;
    }

    public boolean hasPool() {
        return pool;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public double getCost() {
        return cost;
    }
}

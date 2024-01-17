public class House {
    private double area;
    private int numOfRooms;
    private String address;
    private String city;
    private double cost;

    public House(double area, int numOfRooms, String address, String city, double cost) {
        this.area = area;
        this.numOfRooms = numOfRooms;
        this.address = address;
        this.city = city;
        this.cost = cost;
    }

    public double getArea() {
        return area;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }
  
    public double getCost() {
        return cost;
    }
}

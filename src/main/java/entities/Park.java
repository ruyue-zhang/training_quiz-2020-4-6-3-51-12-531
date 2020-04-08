package entities;

public class Park {
    private int id;
    private String parkingSpace;
    private String carNumber;

    public Park() {
    }

    public Park(int id, String parkingSpace) {
        this.id = id;
        this.parkingSpace = parkingSpace;
    }

    public Park(int id, String parkingSpace, String licenseNumber) {
        this.id = id;
        this.parkingSpace = parkingSpace;
        this.carNumber = licenseNumber;
    }

    public int getId() {
        return id;
    }

    public String getParkingSpace() {
        return parkingSpace;
    }

    public String getCarNumber() {
        return carNumber;
    }

    @Override
    public String toString() {
        return  parkingSpace + "," + id + "," + carNumber;
    }
}

package entities;

public class Park {
    private int id;
    private String ParkingSpace;
    private String licenseNumber;

    public Park() {
    }

    public Park(int id, String parkingSpace) {
        this.id = id;
        ParkingSpace = parkingSpace;
    }

    public Park(int id, String parkingSpace, String licenseNumber) {
        this.id = id;
        ParkingSpace = parkingSpace;
        this.licenseNumber = licenseNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParkingSpace() {
        return ParkingSpace;
    }

    public void setParkingSpace(String parkingSpace) {
        ParkingSpace = parkingSpace;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return  id + "," + ParkingSpace + "," + licenseNumber;
    }
}

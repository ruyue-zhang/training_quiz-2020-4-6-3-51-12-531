package entities;

public class Park {
    private int id;
    private String parkingSpace;
    private String licenseNumber;

    public Park() {
    }

    public Park(int id, String parkingSpace) {
        this.id = id;
        this.parkingSpace = parkingSpace;
    }

    public Park(int id, String parkingSpace, String licenseNumber) {
        this.id = id;
        this.parkingSpace = parkingSpace;
        this.licenseNumber = licenseNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(String parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return  parkingSpace + "," + id + "," + licenseNumber;
    }
}

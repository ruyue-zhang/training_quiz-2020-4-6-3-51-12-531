package repositories;

import entities.Park;

import java.sql.Connection;
import java.util.List;

public interface ParkRepositoryI {
    void initPark(Connection conn, List<Park> parkList);
    int updateLicenseNumber(Connection conn, String licenseNumber);
    Park selectByLicenseNumber(Connection conn, String licenseNumber);
    int emptyLicenseNumberByIdAndParkingSpace(Connection conn, int id, String parkingSpace);
    Park selectByPark(Connection conn, Park park);
    void deleteAll(Connection conn);
}

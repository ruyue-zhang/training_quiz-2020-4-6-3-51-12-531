package repositories;

import entities.Park;

import java.sql.Connection;
import java.util.List;

public interface ParkRepositoryI {
    void initPark(Connection conn, List<Park> parkList);
    int updateLicenseNumber(Connection conn, String licenseNumber);
    Park selectByLicenseNumber(Connection conn, String licenseNumber);
    int emptyLicenseNumberByLicenseNumber(Connection conn, String licenseNumber);
    Park selectByPark(Connection conn, Park park);
}

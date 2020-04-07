package repositories;

import entities.Park;

import java.sql.Connection;
import java.util.List;

public interface ParkRepositoryI {
    int initPark(Connection conn, List<Park> parkList);
    int updateLicenseNumber(Connection conn, String licenseNumber);
    Park selectByLicenseNumber(Connection conn, String licenseNumber);
    int emptyLicenseNumberByLicenseNumber(Connection conn, String licenseNumber);
    int selectByPark(Connection conn, Park park);
}

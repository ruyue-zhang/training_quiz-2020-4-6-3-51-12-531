package repositories;

import entities.Park;

import java.sql.Connection;
import java.util.List;

public class ParkRepository extends BaseDAO<Park> implements ParkRepositoryI  {
    @Override
    public int initPark(Connection conn, List<Park> parkList) {
        return 0;
    }

    @Override
    public int updateLicenseNumber(Connection conn, String licenseNumber) {
        return 0;
    }

    @Override
    public Park selectByLicenseNumber(Connection conn, String licenseNumber) {
        return null;
    }

    @Override
    public int emptyLicenseNumberByLicenseNumber(Connection conn, String licenseNumber) {
        return 0;
    }

    @Override
    public int selectByPark(Connection conn, Park park) {
        return 0;
    }
}
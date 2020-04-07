package repositories;

import entities.Park;
import java.sql.Connection;
import java.util.List;

public class ParkRepository extends BaseDAO<Park> implements ParkRepositoryI  {
    @Override
    public void initPark(Connection conn, List<Park> parkList) {
        for (Park park : parkList) {
            String sql = "insert into park(id,Parking_space) values(?,?)";
            update(conn,sql,park.getId(),park.getParkingSpace());
        }
    }

    @Override
    public int updateLicenseNumber(Connection conn, String licenseNumber) {
        String sql = "update park set license_number = ? where license_number is null";
        return update(conn,licenseNumber);
    }

    @Override
    public Park selectByLicenseNumber(Connection conn, String licenseNumber) {
        String sql = "select id,parking_space parkingSpace,license_number licenseNumber from park where license_number = licenseNumber";
        return query(conn,sql);
    }

    @Override
    public int emptyLicenseNumberByLicenseNumber(Connection conn, String licenseNumber) {
        String sql = "update park set license_number = null where license_number = ?";
        return update(conn,sql,licenseNumber);
    }

    @Override
    public Park selectByPark(Connection conn, Park park) {
        String sql = "select id,parking_space parkingSpace,license_number licenseNumber from park where id = ? and parking_space = ? and license_number = ?";
        return query(conn,sql,park.getId(),park.getParkingSpace(),park.getLicenseNumber());
    }
}

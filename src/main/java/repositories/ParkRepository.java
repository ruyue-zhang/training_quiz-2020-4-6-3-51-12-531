package repositories;

import entities.Park;
import java.sql.Connection;
import java.util.List;

public class ParkRepository extends BaseDAO<Park> implements ParkRepositoryI  {
    @Override
    public void initPark(Connection conn, List<Park> parkList) {
        for (Park park : parkList) {
            String sql = "insert into park(id,ParkingSpace) values(?,?)";
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
        String sql = "select (id,parking_space,license_number) from park where license_number = licenseNumber";
        return query(conn,sql);
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

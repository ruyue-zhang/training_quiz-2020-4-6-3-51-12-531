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
    public int updateCarNumber(Connection conn, String carNumber) {
        String sql = "update park set car_number = ? where car_number is null limit 1";
        return update(conn,sql,carNumber);
    }

    @Override
    public Park selectByCarNumber(Connection conn, String carNumber) {
        String sql = "select id,parking_space parkingSpace,car_number carNumber from park where car_number = ?";
        return query(conn,sql,carNumber);
    }

    @Override
    public void emptyCarNumberByIdAndParkingSpace(Connection conn, int id, String parkingSpace) {
        String sql = "update park set car_number = null where id = ? and parking_space = ?";
        update(conn,sql,id,parkingSpace);
    }

    @Override
    public Park selectByPark(Connection conn, Park park) {
        String sql = "select id,parking_space parkingSpace,car_number carNumber from park where id = ? and parking_space = ? and car_number = ?";
        return query(conn,sql,park.getId(),park.getParkingSpace(),park.getCarNumber());
    }

    @Override
    public void deleteAll(Connection conn) {
        String sql = "delete from park";
        update(conn,sql);
    }
}

package repositories;

import entities.Park;

import java.sql.Connection;
import java.util.List;

public interface ParkRepositoryI {
    void initPark(Connection conn, List<Park> parkList);
    int updateCarNumber(Connection conn, String carNumber);
    Park selectByCarNumber(Connection conn, String carNumber);
    void emptyCarNumberByIdAndParkingSpace(Connection conn, int id, String parkingSpace);
    Park selectByPark(Connection conn, Park park);
    void deleteAll(Connection conn);
}

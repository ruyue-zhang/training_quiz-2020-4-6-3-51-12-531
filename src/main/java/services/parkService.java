package services;

import Utils.JDBCUtils;
import entities.Park;
import repositories.ParkRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class parkService implements parkServiceI {

    private ParkRepository parkRepository= new ParkRepository();
    @Override
    public void init(String initInfo) {
        Connection conn = null;
        List<Park> parkList = new ArrayList<>();
        String[] split = initInfo.split(",");
        for (String s : split) {
            String[] parkString = s.split(":");
            String parkSpace = parkString[0];
            for (int i = 1; i <= Integer.parseInt(parkString[1]); i++) {
                parkList.add(new Park(i,parkSpace));
            }
        }
        try {
            conn = JDBCUtils.getConnection();
            parkRepository.initPark(conn,parkList);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseSource(null,conn);
        }
    }

    @Override
    public Park park(String carNumber) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            parkRepository.updateLicenseNumber(conn, carNumber);
            return parkRepository.selectByLicenseNumber(conn, carNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseSource(null, conn);
        }
        return null;
    }

    @Override
    public String fetch(String ticket) {
        Connection conn = null;
        String[] split = ticket.split(",");
        Park park = new Park(Integer.parseInt(split[1]), split[0], split[2]);
        try {
            conn = JDBCUtils.getConnection();
            return parkRepository.selectByPark(conn, park).getLicenseNumber();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

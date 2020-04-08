package services;

import Utils.JDBCUtils;
import entities.Park;
import exception.InvalidTicketException;
import exception.ParkingLotFullException;
import repositories.ParkRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ParkService implements ParkServiceI {

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
            parkRepository.deleteAll(conn);
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
            int result = parkRepository.updateLicenseNumber(conn, carNumber);
            if(result == 0) {
                throw new ParkingLotFullException(" 非常抱歉，由于车位已满，暂时无法为您停车！");
            }
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
            Park returnPark = parkRepository.selectByPark(conn, park);
            if(returnPark == null) {
                throw new InvalidTicketException("很抱歉，无法通过您提供的停车券为您找到相应的车辆，请您再次核对停车券是否有效！ ");
            }
            parkRepository.emptyLicenseNumberByIdAndParkingSpace(conn,returnPark.getId(),returnPark.getParkingSpace());
            return returnPark.getCarNumber();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

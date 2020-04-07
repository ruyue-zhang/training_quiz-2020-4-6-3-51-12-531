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
    public String park(String carNumber) {
        return null;
    }

    @Override
    public String fetch(String ticket) {
        return null;
    }
}

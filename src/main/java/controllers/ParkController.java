package Controllers;

import entities.Park;
import services.ParkService;

public class parkController {
    private ParkService parkService = new ParkService();
    public void init(String initInfo) {
        parkService.init(initInfo);
    }

    public Park park(String carNumber) {
        return parkService.park(carNumber);
    }

    public String fetch(String ticket) {
        return parkService.fetch(ticket);
    }
}

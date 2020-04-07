package services;

import entities.Park;

public interface ParkServiceI {
    void init(String initInfo);
    Park park(String carNumber);
    String fetch(String ticket);
}

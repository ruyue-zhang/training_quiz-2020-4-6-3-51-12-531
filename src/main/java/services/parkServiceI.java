package services;

import entities.Park;

public interface parkServiceI {
    void init(String initInfo);
    Park park(String carNumber);
    String fetch(String ticket);
}

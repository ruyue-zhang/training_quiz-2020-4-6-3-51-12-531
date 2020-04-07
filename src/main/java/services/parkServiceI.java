package services;

public interface parkServiceI {
    void init(String initInfo);
    String park(String carNumber);
    String fetch(String ticket);
}

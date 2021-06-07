package pl.kmiecik.M7_jdbc_HOMEWORK;

import java.util.List;

public interface VehicleRepository {

    List<Vehicle> findAll();
    void addVehicle(Vehicle vehicle);
    void deleteVehicle(long id);
    void updateVehicle(Vehicle vehicle);
}

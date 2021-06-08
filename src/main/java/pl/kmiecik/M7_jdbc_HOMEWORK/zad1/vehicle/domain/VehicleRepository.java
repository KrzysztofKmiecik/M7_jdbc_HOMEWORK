package pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.domain;

import java.util.List;

public interface VehicleRepository {

    List<Vehicle> findAll();

    void addVehicle(final Vehicle vehicle);

    void deleteVehicle(long id);

    void updateVehicle(final Vehicle vehicle);
}

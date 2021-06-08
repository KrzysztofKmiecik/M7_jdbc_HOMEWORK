package pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.application.port;

import pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.domain.Vehicle;

import java.util.List;

public interface VehicleService {
    void addVehicle(final Vehicle vehicle);

    List<Vehicle> findAll();

    void deleteVehicle(final long id);

    void updateVehicle(final Vehicle vehicle);

    List<Vehicle> findByProductionYearLimit(final int min,final  int max);
}

package pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.application.port.VehicleService;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.domain.Vehicle;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.domain.VehicleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository repository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addVehicle(final Vehicle vehicle) {
        repository.addVehicle(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteVehicle(final long id) {
        repository.deleteVehicle(id);
    }

    @Override
    public void updateVehicle(final Vehicle vehicle) {
        repository.updateVehicle(vehicle);
    }

    @Override
    public List<Vehicle> findByProductionYearLimit(final int min, final int max) {
        return repository.findAll().stream()
                .filter(vehicle -> (vehicle.getProductionDate() >= min) && (vehicle.getProductionDate() <= max))
                .collect(Collectors.toList());
    }
}

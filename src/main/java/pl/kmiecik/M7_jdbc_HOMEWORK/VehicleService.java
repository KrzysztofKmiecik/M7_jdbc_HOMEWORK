package pl.kmiecik.M7_jdbc_HOMEWORK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    private final VehicleRepository repository;

    @Autowired
    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public void addVehicle(Vehicle vehicle){
        repository.addVehicle(vehicle);
    }

    public List<Vehicle> findAll(){
        return repository.findAll();
    }


    public void deleteVehicle(long id){
        repository.deleteVehicle(id);
    }

    public void updateVehicle(Vehicle vehicle) {
        repository.updateVehicle(vehicle);
    }

    public List<Vehicle> findByProductionYearLimit(int min, int max) {
        return repository.findAll().stream()
                .filter(vehicle -> (vehicle.getProductionDate()>=min)&&(vehicle.getProductionDate()<=max))
                .collect(Collectors.toList());
    }
}

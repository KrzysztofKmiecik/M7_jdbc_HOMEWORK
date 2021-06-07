package pl.kmiecik.M7_jdbc_HOMEWORK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

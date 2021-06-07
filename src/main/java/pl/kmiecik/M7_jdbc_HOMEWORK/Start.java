package pl.kmiecik.M7_jdbc_HOMEWORK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private final VehicleService service;

    @Autowired
    public Start(VehicleService service) {
        this.service = service;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){

       /* service.addVehicle(new Vehicle(1L,"BMW"));
        service.addVehicle(new Vehicle(2L,"Polonez"));
        service.addVehicle(new Vehicle(3L,"Fiat"));*/



       // service.deleteVehicle(1);

      //  service.updateVehicle(new Vehicle(3L,"Ducato"));
        service.findAll().forEach(System.out::println);
    }

}

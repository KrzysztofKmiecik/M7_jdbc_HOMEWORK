package pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.application.port.VehicleService;

@Component
class Start {

    private final VehicleService service;

    @Autowired
    public Start(VehicleService service) {
        this.service = service;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

       /* service.addVehicle(new Vehicle(1L,"BMW","i3",1980));
        service.addVehicle(new Vehicle(2L,"Polonez","Caro",1970));
        service.addVehicle(new Vehicle(3L,"Fiat","Ducato",1990));
        service.addVehicle(new Vehicle(4L,"Audi","Quatro",2000));*/


        // service.deleteVehicle(4);

        //   service.updateVehicle(new Vehicle(3L,"Fiat","Panda",1991));
      //  service.findAll().forEach(System.out::println);
    }

}

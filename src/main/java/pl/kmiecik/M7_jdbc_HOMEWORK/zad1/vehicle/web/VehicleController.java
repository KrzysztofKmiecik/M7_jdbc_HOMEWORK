package pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.application.port.VehicleService;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.domain.Vehicle;

import java.util.List;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;

    @Autowired
    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public String getVahicle(Model model) {
        List<Vehicle> allVahicles = service.findAll();
        model.addAttribute("vehicles", allVahicles);
        model.addAttribute("newVehicle", new Vehicle());
        return "vehicleView";
    }

    @PostMapping
    public String addVehicle(@ModelAttribute Vehicle vehicle) {
        service.addVehicle(vehicle);
        return "redirect:/vehicles";
    }

}

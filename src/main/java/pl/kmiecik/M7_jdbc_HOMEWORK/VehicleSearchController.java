package pl.kmiecik.M7_jdbc_HOMEWORK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/vehiclesSearch")
public class VehicleSearchController {

    private final VehicleService service;

    @Autowired
    public VehicleSearchController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public String getVahicle(Model model, @RequestParam int minYear,@RequestParam int maxYear) {
        List<Vehicle> findByProductionRange = service.findAll().stream()
                .filter(vehicle -> (vehicle.getProductionDate() >= minYear) && (vehicle.getProductionDate() <= maxYear))
                .collect(Collectors.toList());
        model.addAttribute("vehicles",findByProductionRange);
        model.addAttribute("newVehicle",new Vehicle());
        return "vehicleSearchView";
    }

    @PostMapping
    public String addVehicle(@ModelAttribute Vehicle vehicle){
        service.addVehicle(vehicle);
        return "redirect:/vehiclesSearch";
    }



}

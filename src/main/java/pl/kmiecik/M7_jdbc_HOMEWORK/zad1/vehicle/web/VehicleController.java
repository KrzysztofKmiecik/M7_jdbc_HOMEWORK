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

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("/vehicles")
class VehicleController {

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
    public String addVehicle(@Valid @ModelAttribute VehicleCommand command) {
        service.addVehicle(command.toVehicle());
        return "redirect:/vehicles";
    }

    private static class VehicleCommand {
        @NotNull
        private long id;
        @NotBlank
        private String mark;
        @NotBlank
        private String model;
        @NotNull
        @Min(1000)
        @Max(9999)
        private int productionDate;

        public VehicleCommand(long id, String mark, String model, int productionDate) {
            this.id = id;
            this.mark = mark;
            this.model = model;
            this.productionDate = productionDate;
        }

        public Vehicle toVehicle() {
            return new Vehicle(this.getId(), this.getMark(), this.getModel(), this.getProductionDate());
        }

        public long getId() {
            return id;
        }

        public String getMark() {
            return mark;
        }

        public String getModel() {
            return model;
        }

        public int getProductionDate() {
            return productionDate;
        }
    }
}

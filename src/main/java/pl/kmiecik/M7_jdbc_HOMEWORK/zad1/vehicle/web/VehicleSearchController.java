package pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.application.VehicleServiceImpl;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.application.port.VehicleService;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.domain.Limit;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.domain.Vehicle;

import java.util.List;

@Controller
@RequestMapping("/vehiclesSearch")
public class VehicleSearchController {

    private final VehicleService service;
    private Limit limit;

    @Autowired
    public VehicleSearchController(VehicleServiceImpl service) {

        this.service = service;
        this.limit = new Limit(0, 0);
    }

    @GetMapping
    public String getVahicle(Model model) {
        List<Vehicle> findByProductionRange = service.findByProductionYearLimit(this.limit.getMin(), this.limit.getMax());
        model.addAttribute("vehicles", findByProductionRange);
        model.addAttribute("newLimit", new Limit());
        return "vehicleSearchView";
    }

    @PostMapping
    public String setLimit(@ModelAttribute Limit limit) {
        this.limit.setMax(limit.getMax());
        this.limit.setMin(limit.getMin());
        return "redirect:/vehiclesSearch";
    }


}

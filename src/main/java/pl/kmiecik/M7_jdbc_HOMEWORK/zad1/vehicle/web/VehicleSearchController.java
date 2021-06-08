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

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("/vehiclesSearch")
public class VehicleSearchController {

    private final VehicleService service;
    private Limit limit;

    @Autowired
    public VehicleSearchController(VehicleServiceImpl service) {

        this.service = service;
        this.limit = new Limit(2010, 2015);
    }

    @GetMapping
    public String getVahicle(Model model) {
        List<Vehicle> findByProductionRange = service.findByProductionYearLimit(this.limit.getMin(), this.limit.getMax());
        model.addAttribute("vehicles", findByProductionRange);
        model.addAttribute("newLimit", this.limit);
        return "vehicleSearchView";
    }

    @PostMapping
    public String setLimit(@Valid @ModelAttribute LimitCommand command) {
        this.limit = command.toLimit();
        return "redirect:/vehiclesSearch";
    }


    private static class LimitCommand {
        @NotNull
        @Min(1000)
        private int min;
        @NotNull
        @Max(9999)
        private int max;

        public LimitCommand(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public Limit toLimit() {
            return new Limit(this.getMin(), this.getMax());
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }
    }
}

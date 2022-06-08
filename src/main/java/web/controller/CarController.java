package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false) int count, ModelMap model) {
        List<Car> carlist = new ArrayList<>();
        carlist.add(new Car("Ford Fusion", 2007, "White"));
        carlist.add(new Car("Vaz 2107", 2005, "White"));
        carlist.add(new Car("Volkswagen Golf Plus", 2008, "Black"));
        carlist.add(new Car("Opel Zafira", 2008, "silver"));
        carlist.add(new Car("Hyundai Solaris", 2013, "red"));
        List<Car> finishCarList = new ArrayList<>();
        if(count<=carlist.size()) {
            for (int i = 0; i < count; i++) {
                finishCarList.add(carlist.get(i));
            }
            model.addAttribute("finishCarList", finishCarList);
        } else {
            finishCarList.addAll(carlist);
            model.addAttribute("finishCarList", finishCarList);                                                                                                                                                                                                                                                     
        }

        return "cars";
    }
}

package cars.list.car.controller;
import cars.list.car.form.CarForm;
import cars.list.car.model.Car;


import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class MainController {


    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @GetMapping(value = { "/", "/index" })
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @GetMapping(value = { "/carList" })
    public String carList(Model model) {
        RestTemplate template = new RestTemplate();
        List<Car> cars =  template.getForObject("http://localhost:8080/Cars", List.class);

        model.addAttribute("cars", cars);

        return "carList";
    }

    @GetMapping(value = { "/addCar" })
    public String showAddCarPage(Model model) {
        CarForm carForm = new CarForm();
        model.addAttribute("carForm", carForm);

        return "addCar";
    }

    @PostMapping(value = { "/addCar" })
    public String saveCar(Model model,@ModelAttribute("carForm") CarForm carForm) {

        String brand = carForm.getBrand();
        String type = carForm.getType();

        if (brand != null && brand.length() > 0 //
                && type!= null && type.length() > 0) {
            RestTemplate template = new RestTemplate();
            Map<String,String> requestMap = new HashMap<>();
            requestMap.put("brand",brand);
            requestMap.put("type",type);
            template.postForObject("http://localhost:8080/Cars", requestMap, String.class);

            return "redirect:/carList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }


@GetMapping (value = {"carList/{id}"})

   public String deleteCar(@PathVariable int id ){


  RestTemplate template = new RestTemplate();
   template.delete("http://localhost:8080/Cars/"+id, Car.class);

    return "carlist";

}

}

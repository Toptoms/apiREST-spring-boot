package cars.list.car.api.controller;

import cars.list.car.dao.CarDao;
import cars.list.car.model.Car;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(description ="Gestion de modele de voiture")
@RestController
public class CarController {

    @Autowired
    private CarDao carDao;

    //Récupérer la liste des cars
    @ApiOperation(value = "retourne la liste des voitures")
    @GetMapping(value = "/Cars")
    public List<Car> listeCars() {

        return carDao.findAll();
    }

    //Récupérer un produit par son Id
    @ApiOperation(value = "retourne un model de voiture par son id")
    @GetMapping(value = "/Cars/{id}")
    public Car afficherUnevoiture(@PathVariable int id) {
        return carDao.findById(id).orElse(null);
    }

    @ApiOperation(value = "ajoute un nouveau modele")
    @PostMapping(value = "/Cars")
    public void ajouterUneVoiture(@RequestBody Car car){
        carDao.save(car);
    }

    @ApiOperation(value = "modifie un modele")
    @PutMapping (value = "/Cars/{id}")
    public Car modifierUnevoiture (@RequestBody Car carUp, @PathVariable int id){

       Car carCurrent = this.afficherUnevoiture(id);

       if ( carUp.getBrand() != null){
           carCurrent.setBrand(carUp.getBrand());
       }

       if ( carUp.getType() != null){
            carCurrent.setType(carUp.getType());
       }
       carDao.save(carCurrent);
       return carCurrent;
    }

    @ApiOperation(value = "suprime un modele de voiture")
    @DeleteMapping(value = "Cars/{id}")
    public void SupprimerUneVoiture(@PathVariable int id){
        Car car = this.afficherUnevoiture(id);
        carDao.delete(car);

    }

}
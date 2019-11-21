package cars.list.car.dao;

import cars.list.car.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    public static List<Car> cars = new ArrayList<Car>();

    static {
        cars.add(new Car(  "renault", "306"));
        cars.add(new Car("Steve", "Jobs"));
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public Car findById(int id) {
        for (Car car : cars) {
            if(car.getId() ==id){
                return car;
            }
        }
        return null;
    }

    @Override
    public Car save(Car car) {
       cars.add(car);
        return car;
    }


    @Override
    public void delete(int id ){
       Car carDelete = this.findById(id);
        cars.remove(carDelete);

    }

}

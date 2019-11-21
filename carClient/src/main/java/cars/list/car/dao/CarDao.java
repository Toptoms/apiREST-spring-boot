package cars.list.car.dao;

import cars.list.car.model.Car;

import java.util.List;

public interface CarDao {
    public List<Car> findAll();
    public Car findById(int id);
    public Car save (Car car);
    public void delete (int id);
}

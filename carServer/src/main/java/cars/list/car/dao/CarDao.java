package cars.list.car.dao;

import cars.list.car.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarDao extends JpaRepository<Car, Integer> {

}

package cars.list.car.model;

import cars.list.car.CarIndex;

public class Car {
    private  int id = CarIndex.getIndex();//String.valueOf( (int)(Math.random() * ((100 - 1) )));

    private String brand;
    private String type;

    public Car() {

    }

    public Car(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }


}

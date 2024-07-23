package factory;

import concreteProduct.Bike;
import concreteProduct.Car;
import productInterface.Vehicle;

public class VehicleFactory {
    public Vehicle createVehicle(String type) {
        return switch (type) {
            case "car" -> new Car();
            case "bike" -> new Bike();
            default -> null;
        };
    }
}

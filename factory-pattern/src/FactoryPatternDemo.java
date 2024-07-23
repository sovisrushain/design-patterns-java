import factory.VehicleFactory;
import productInterface.Vehicle;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();

        // create a car
        Vehicle car = vehicleFactory.createVehicle("car");
        car.drive();

        // create a bike
        Vehicle bike = vehicleFactory.createVehicle("bike");
        bike.drive();
    }
}

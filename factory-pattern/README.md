# Factory Pattern

The Factory Pattern is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. This pattern is useful when the exact type of object that needs to be created isn't known until runtime.

The Factory Pattern involves creating a factory class that has a method to create objects. This method takes a parameter to determine which specific subclass of the object to create.

## Components of Factory Pattern
1. **Product Interface:** An interface or abstract class that defines the common behavior of the objects.
2. **Concrete Product:** Classes that implement the Product interface.
3. **Factory:** A class that contains a method to create objects based on given information.

### Example: Vehicle Factory

**Step 1:** Define the Product Interface
```angular2html
public interface Vehicle {
    void drive();
}
```
**Step 2:** Implement Concrete Products
```angular2html
public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a Car");
    }
}

public class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a Bike");
}
```
**Step 3:** Create the Factory Class
```angular2html
public class VehicleFactory {
    public Vehicle createVehicle(String type) {
        return switch (type) {
            case "car" -> new Car();
            case "bike" -> new Bike();
            default -> null;
        };
    }
}
```
**Step 4:** Use the Factory to Create Objects
```angular2html
public class FactoryPatternDemo {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle car = vehicleFactory.createVehicle("car");
        car.drive();

        Vehicle bike = vehicleFactory.createVehicle("bike");
        bike.drive();
    }
}
```
### Explanation
1. **Product Interface:** The Vehicle interface defines the drive method that all concrete products must implement.
2. **Concrete Products:** Car and Bike classes implement the Vehicle interface and provide their own implementation of the drive method.
3. **Factory Class:** The VehicleFactory class contains the createVehicle method, which takes a string parameter to determine which type of vehicle to create.
4. **Factory Method Usage:** In the FactoryPatternDemo class, the VehicleFactory is used to create instances of Car and Bike based on the input string. The created objects are then used to call their respective drive methods.

## Advantages of Factory Pattern
1. **Encapsulation:** The Factory Pattern encapsulates the creation of objects, making it easier to manage and maintain.
2. **Loose Coupling:** The client code is decoupled from the specific classes it needs to instantiate. The client only interacts with the factory and the product interface.
3. **Flexibility:** New types of products can be added without changing the client code. Only the factory class needs to be modified to handle new types.

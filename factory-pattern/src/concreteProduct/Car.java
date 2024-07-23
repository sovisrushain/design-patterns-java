package concreteProduct;

import productInterface.Vehicle;

// Concrete Product: Car
public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a Car");
    }
}

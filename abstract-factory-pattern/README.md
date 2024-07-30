# Abstract Factory Pattern

The Abstract Factory Pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. This pattern is often used when there are multiple families of products and the system needs to be independent of the way the products are created or composed.

The Abstract Factory Pattern involves creating a set of related factory interfaces and corresponding concrete factories that implement these interfaces to create objects of related families

## Components of Abstract Factory Pattern

1. **Abstract Product:** Declares an interface for a type of product object.
2. **Concrete Product:** Defines a product object to be created by the corresponding concrete factory.
3. **Abstract Factory:** Declares an interface for operations that create abstract product objects.
4. **Concrete Factory:** Implements the operations to create concrete product objects.
5. **Client:** Uses the Abstract Factory and Abstract Product interfaces to create families of related objects.

### Example: GUI Factory
We'll implement an abstract factory pattern for creating different types of GUI components like Buttons and Checkboxes for different operating systems like Windows and Mac.

**Step 1:** Define Abstract Products

```angular2html
public interface Button {
    void paint();
}

public interface Checkbox {
    void paint();
}
```
**Step 2:** Implement Concrete Products

```angular2html
public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a button in Mac style");
    }
}

public class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in Mac style");
    }
}

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a button in Windows style");
    }
}

public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in Windows style");
    }
}
```
**Step 3:** Define the Abstract Factory

```angular2html
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
```
**Step 4:** Implement Concrete Factories
```angular2html
public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
```

**Step 5:** Create the Client Code
```angular2html
public class Application {
    private final Button button;
    private final Checkbox  checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
    
        String os = "windows";
        
        GUIFactory factory = switch (os) {
            case "windows" -> new WindowsFactory();
            case "mac" -> new MacFactory();
            default -> null;
        };
        
        Application app = new Application(factory);
        app.paint();
    }
}
```

### Explanation
1. **Abstract Products:** Button and Checkbox interfaces declare the operations that all concrete products must implement.
2. **Concrete Products:** WindowsButton, MacButton, WindowsCheckbox, and MacCheckbox classes implement the abstract product interfaces.
3. **Abstract Factory:** GUIFactory interface declares methods for creating abstract products.
4. **Concrete Factories:** WindowsFactory and MacFactory classes implement the GUIFactory interface to create concrete products.
5. **Client Code:** The Application class uses the abstract factory to create and use products without knowing their concrete classes. The AbstractFactoryDemo class demonstrates how the client code can work with different factories based on the operating system.

## Advantages of Abstract Factory Pattern
1. **Isolates Clients from Concrete Classes:** The client code works with abstract interfaces and is independent of the concrete classes.
2. **Exchanges Product Families Easily:** It is easy to switch between different families of products without changing the client code.
3. **Ensures Consistency Among Products:** Products created by a particular factory are consistent and compatible with each other.
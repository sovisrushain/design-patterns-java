import abstractFactory.GUIFactory;
import concreteFactory.MacFactory;
import concreteFactory.WindowsFactory;

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
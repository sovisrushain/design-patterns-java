public class BasicSingleton {

    // Private static instance of the class
    private static BasicSingleton instance;

    // Private constructor to prevent instantiation
    private BasicSingleton() {}

    // Public static method to provide access to the instance
    public static BasicSingleton getInstance() {
        if (instance == null) {
            instance = new BasicSingleton();
        }
        return instance;
    }
}

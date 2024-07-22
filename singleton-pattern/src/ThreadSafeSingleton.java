public class ThreadSafeSingleton {

    // Private static instance of the class
    private static ThreadSafeSingleton instance;

    // Private constructor to prevent instantiation
    private ThreadSafeSingleton() {}

    // Public static synchronized method to provide access to the instance
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

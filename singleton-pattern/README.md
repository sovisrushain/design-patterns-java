# Singleton Pattern


The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance. This is useful when exactly one object is needed to coordinate actions across the system.

### Use Cases
- Logging
- Configuration settings
- Database connections
- Caching


## Basic Singleton Pattern

The Basic Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance. However, this implementation is not thread-safe, meaning that in a multi-threaded environment, multiple instances could be created.

```angular2html
public class BasicSingleton {

    private static BasicSingleton instance;

    private BasicSingleton() {}

    public static BasicSingleton getInstance() {
        if (instance == null) {
            instance = new BasicSingleton();
        }
        return instance;
    }
}
```

### Explanation

1. **Private Static Instance:** The instance variable is a private static member of the class. This ensures that there is only one instance of the class.
2. **Private Constructor:** The constructor is private, so it prevents the instantiation of the class from outside the class.
3. **Public Static Method:** The getInstance method is public and static, providing a global point of access to the instance. It checks if the instance is null, and if so, it creates a new instance. Otherwise, it returns the existing instance.

### Multi-threaded Environment Issue
In a multi-threaded environment, the Basic Singleton implementation may lead to multiple instances being created. Let's consider an example:

```angular2html
public class SingletonDemoMultiThreaded {
    public static void main(String[] args) {
        Runnable task = () -> {
            BasicSingleton instance = BasicSingleton.getInstance();
            System.out.println(instance);
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
```
```angular2html
BasicSingleton@a66aa70
BasicSingleton@53d2ecb9
BasicSingleton@53d2ecb9
```
### Explanation of the Issue

In the multi-threaded example, multiple threads are trying to access the getInstance method simultaneously. If the instance is null, multiple threads may enter the if (instance == null) block simultaneously, leading to the creation of multiple instances of BasicSingleton.

This occurs because the check-and-create operation (if (instance == null) { instance = new BasicSingleton(); }) is not atomic, meaning it is not executed as a single, indivisible operation. As a result, two or more threads can see instance as null and proceed to create separate instances.


## Thread-Safe Singleton Pattern
The Thread-Safe Singleton pattern uses synchronization to ensure that only one thread can access the getInstance method at a time. This prevents multiple threads from creating separate instances of the Singleton class.

```angular2html
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
```

### Explanation
1. **Private Static Instance:** The instance variable is a private static member of the class, ensuring only one instance exists.
2. **Private Constructor:** The constructor is private, preventing instantiation from outside the class.
3. **Synchronized Method:** The getInstance method is synchronized, ensuring that only one thread can execute it at a time. This prevents multiple threads from creating separate instances.

Synchronized Method: The getInstance method is synchronized, ensuring that only one thread can execute it at a time. This prevents multiple threads from entering the method simultaneously and creating multiple instances.

Thread-Safe: Even in a multi-threaded environment, the synchronization ensures that only one instance of the class is created, maintaining the Singleton pattern's core principle.

While the synchronized method ensures thread safety, it can introduce a performance overhead because every call to the getInstance method needs to acquire a lock. This can be a bottleneck if the method is called frequently in a highly concurrent environment.
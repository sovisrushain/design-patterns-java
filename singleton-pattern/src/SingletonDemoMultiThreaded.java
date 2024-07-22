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

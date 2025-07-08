// 4) What is the singleton design pattern? Explain with a coding example.

// Answer
// Singleton Design Pattern ensures only one instance of a class exists and provides a global point of access.
// Example:

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        s.showMessage();
    }
}

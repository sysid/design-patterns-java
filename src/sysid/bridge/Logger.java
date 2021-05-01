package sysid.bridge;

/**
 * Implementor and simultaneously ConcreteImplementor
 */
@FunctionalInterface
public interface Logger {
    void log(String message);

    // default impl1
    static Logger info() {
        return message -> System.out.println("info: " + message);
    }

    // default impl2
    static Logger warning() {
        return message -> System.out.println("warning: " + message);
    }
}

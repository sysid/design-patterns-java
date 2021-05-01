package sysid.bridge;

/**
 * abstract Abstraction
 */
public class AbstractAccount {
    // implementor interface
    private Logger logger = Logger.info();

    void setLogger(Logger logger) {
        this.logger = logger;
    }

    // the logging part is delegated to the Logger implementation
    protected void operate(String message, boolean result) {
        logger.log(message + " result " + result);
    }
}

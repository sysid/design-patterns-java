package sysid.chain;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.function.Consumer;

@FunctionalInterface
public interface Logger {
    public enum LogLevel {
        INFO, DEBUG, WARNING, ERROR, FUNCTIONAL_MESSAGE, FUNCTIONAL_ERROR;

        public static LogLevel[] all() {
            return values();
        }
    }

    // Handler: functionality
    void message(String msg, LogLevel severity);

    // Handler: set next handler in chain
    default Logger appendNext(Logger nextLogger) {
        return (msg, severity) -> {
            message(msg, severity);
            nextLogger.message(msg, severity);
        };
    }

    static Logger writeLogger(LogLevel[] levels, Consumer<String> stringConsumer) {
        EnumSet<LogLevel> set = EnumSet.copyOf(Arrays.asList(levels));
        return (msg, severity) -> {
            if (set.contains(severity)) {
                stringConsumer.accept(msg);
            }
        };
    }

    static Logger consoleLogger(LogLevel... levels) {
        return writeLogger(levels, msg -> System.err.println("Writing to console: " + msg));
    }

    static Logger emailLogger(LogLevel... levels) {
        return writeLogger(levels, msg -> System.err.println("Sending via mail: " + msg));
    }

    static Logger fileLogger(LogLevel... levels) {
        return writeLogger(levels, msg -> System.err.println("Writing to Logfile: " + msg));
    }
}

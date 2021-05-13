package sysid.chain;

import static sysid.chain.Logger.*;

public class Demo {
    public static void main(String[] args) {
        // Build an immutable chain of responsibility by configuring via constructors
//        Logger logger = consoleLogger(Logger.LogLevel.all())
//                .appendNext(emailLogger(LogLevel.FUNCTIONAL_MESSAGE, LogLevel.FUNCTIONAL_ERROR))
//                .appendNext(fileLogger(LogLevel.WARNING, LogLevel.ERROR));
        Logger logger = xxx();

        // Handled by consoleLogger since the console has a LogLevel of all
        logger.message("Entering function ProcessOrder().", LogLevel.DEBUG);
        logger.message("Order record retrieved.", LogLevel.INFO);

        // Handled by consoleLogger and emailLogger since emailLogger implements Functional_Error & Functional_Message
        logger.message("Unable to Process Order ORD1 Dated D1 For Customer C1.", LogLevel.FUNCTIONAL_ERROR);
        logger.message("Order Dispatched.", LogLevel.FUNCTIONAL_MESSAGE);

        // Handled by consoleLogger and fileLogger since fileLogger implements Warning & Error
        logger.message("Customer Address details missing in Branch DataBase.", LogLevel.WARNING);
        logger.message("Customer Address details missing in Organization DataBase.", LogLevel.ERROR);
    }
}

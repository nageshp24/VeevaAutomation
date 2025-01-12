package automation_framework.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    // Method to access the logger
    public static Logger getLogger() {
        return logger;
    }
}

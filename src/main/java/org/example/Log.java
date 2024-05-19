package org.example;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class Log {
    public Logger logger;
    FileHandler fileHandler;
    public Log(String file_name) throws SecurityException, IOException{
        File file = new File(file_name);
        fileHandler = new FileHandler(file_name, true);
        logger = Logger.getLogger("logger");
        logger.addHandler(fileHandler);
        logger.setLevel(Level.ALL);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
    }
}

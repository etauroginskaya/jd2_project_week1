package com.gmail.etauroginskaya.app;

import com.gmail.etauroginskaya.impl.DocumentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        String lineMatchingPattern = DocumentServiceImpl.getInstance()
                .getLineMatchingPattern("web-module\\src\\main\\resources\\Test1.txt");
        logger.debug(lineMatchingPattern);
        lineMatchingPattern = DocumentServiceImpl.getInstance()
                .getLineMatchingPattern("web-module\\src\\main\\resources\\Test.txt");
        logger.debug(lineMatchingPattern);
    }
}

package com.gmail.etauroginskaya.app;

import com.gmail.etauroginskaya.impl.DocumentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        String lineMatchingPattern = DocumentServiceImpl.getInstance().getLineMatchingPattern("Test.txt");
        logger.debug(lineMatchingPattern);
    }
}

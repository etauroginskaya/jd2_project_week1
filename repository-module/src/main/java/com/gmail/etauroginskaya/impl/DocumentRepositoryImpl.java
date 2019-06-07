package com.gmail.etauroginskaya.impl;

import com.gmail.etauroginskaya.DocumentRepository;
import com.gmail.etauroginskaya.exception.NotExistDocumentExeption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocumentRepositoryImpl implements DocumentRepository {

    private static final Logger logger = LogManager.getLogger(DocumentRepositoryImpl.class);

    private static DocumentRepositoryImpl mInstance;

    private DocumentRepositoryImpl() {
    }

    public static DocumentRepositoryImpl getInstance() {
        if (mInstance == null) {
            mInstance = new DocumentRepositoryImpl();
        }
        return mInstance;
    }

    @Override
    public List<String> getCollectionLineByDocument(String documentName) {
        try {
            validateDocumentExist(documentName);
            List<String> documentLines = new ArrayList<>();
            String line;
            try (BufferedReader br = new BufferedReader(new FileReader(documentName))) {
                while ((line = br.readLine()) != null) {
                    documentLines.add(line);
                }
                return documentLines;
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        } catch (NotExistDocumentExeption e) {
            logger.error(e.getMessage());
        }
        return Collections.emptyList();
    }

    private void validateDocumentExist(String documentName) {
        if (!new File(documentName).exists()) {
            throw new NotExistDocumentExeption("Document " + documentName + " not found!");
        }
    }
}

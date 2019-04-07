package com.gmail.etauroginskaya.impl;

import com.gmail.etauroginskaya.DocumentRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocumentRepositoryImpl implements DocumentRepository {

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
        List<String> documentLines = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(documentName))) {
            while ((line = br.readLine()) != null) {
                documentLines.add(line);
            }
            return documentLines;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}

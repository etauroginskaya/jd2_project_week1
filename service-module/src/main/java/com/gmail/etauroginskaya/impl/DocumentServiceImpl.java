package com.gmail.etauroginskaya.impl;

import com.gmail.etauroginskaya.DocumentService;

import java.util.List;

public class DocumentServiceImpl implements DocumentService {

    private final String pattern = "(\\d|-|,|,\\s|:|\\||\\n)*";

    private static DocumentServiceImpl mInstance;

    private DocumentServiceImpl() {
    }

    public static DocumentServiceImpl getInstance() {
        if (mInstance == null) {
            mInstance = new DocumentServiceImpl();
        }
        return mInstance;
    }

    @Override
    public String getLineMatchingPattern(String documentName) {
        List<String> listDocumentLine = DocumentRepositoryImpl.getInstance()
                .getCollectionLineByDocument(documentName);
        for (String s : listDocumentLine) {
            if (s.matches(pattern)) {
                return s;
            }
        }
        String str = "";
        return str;
    }
}

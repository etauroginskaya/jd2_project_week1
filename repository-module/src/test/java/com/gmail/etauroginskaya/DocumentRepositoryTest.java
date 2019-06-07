package com.gmail.etauroginskaya;

import com.gmail.etauroginskaya.impl.DocumentRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DocumentRepositoryTest {

    @Test
    public void shouldReturnCollectionStringInDocument() {
        String documentName = "web-module\\src\\main\\resources\\Test.txt";
        List<String> receivedByDocumentLine = DocumentRepositoryImpl.getInstance()
                .getCollectionLineByDocument(documentName);
        Assert.assertNotNull(receivedByDocumentLine);
    }
}

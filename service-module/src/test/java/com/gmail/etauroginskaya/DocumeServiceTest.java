package com.gmail.etauroginskaya;

import com.gmail.etauroginskaya.impl.DocumentServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class DocumeServiceTest {

    @Test
    public void shouldReturnStringMatchesRegex() {
        String documentName = "Test.txt";
        String returnString = DocumentServiceImpl.getInstance().getLineMatchingPattern(documentName);
        Assert.assertTrue(returnString.matches("(\\d|-|,|,\\s|:|\\||\\n)*"));
    }
}

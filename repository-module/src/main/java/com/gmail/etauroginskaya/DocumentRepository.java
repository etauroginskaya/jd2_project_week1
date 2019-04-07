package com.gmail.etauroginskaya;

import java.util.List;

public interface DocumentRepository {

    List<String> getCollectionLineByDocument(String documentName);
}

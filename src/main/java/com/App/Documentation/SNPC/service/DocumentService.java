package com.App.Documentation.SNPC.service;

import com.App.Documentation.SNPC.entity.Document;

import java.util.List;

public interface DocumentService {
    List<Document> getdocument();
    Document getDocumentById(Long id);
    Document addDocument(Document document);
    void deleteDocumentById(Long id);
    Document updateDocumentById(Long id,Document document);
}

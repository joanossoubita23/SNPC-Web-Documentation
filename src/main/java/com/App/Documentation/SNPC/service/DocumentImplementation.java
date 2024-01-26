package com.App.Documentation.SNPC.service;

import com.App.Documentation.SNPC.entity.Document;
import com.App.Documentation.SNPC.exception.ResourceNotFoundException;
import com.App.Documentation.SNPC.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DocumentImplementation implements DocumentService{
    private final DocumentRepository documentRepository;

    public DocumentImplementation(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public List<Document> getdocument() {
        return documentRepository.findAll();
    }

    @Override
    public Document getDocumentById(Long id) {
        Optional<Document> optionalDocument=documentRepository.findById(id);
        if (optionalDocument.isPresent()){
            return optionalDocument.get();
        }else {
            throw new ResourceNotFoundException("Document with id" + id + "Cannot be find");
        }

    }

    @Override
    public Document addDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public void deleteDocumentById(Long id) {
        documentRepository.deleteById(id);

    }

    @Override
    public Document updateDocumentById(Long id, Document document) {
        Document existingDocument=getDocumentById(id);
        existingDocument.setName(existingDocument.getName());
        existingDocument.setSize(existingDocument.getSize());
        existingDocument.setType(existingDocument.getType());
        documentRepository.save(existingDocument);
        return existingDocument;
    }
}

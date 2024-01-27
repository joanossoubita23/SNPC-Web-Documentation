package com.App.Documentation.SNPC.Web;

import com.App.Documentation.SNPC.entity.Document;
import com.App.Documentation.SNPC.service.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/document")

public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }
    @GetMapping("/document")
    public ResponseEntity<List<Document>> getDocument(){
        return new ResponseEntity<>(documentService.getdocument(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Document> getDocumentById(@PathVariable Long id){
        return  new ResponseEntity<>(documentService.getDocumentById(id),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Document> addDocument(@RequestBody Document document){
        return  new ResponseEntity<>(documentService.addDocument(document),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Document> deleteDocumentById(@PathVariable Long id){
        documentService.deleteDocumentById(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Document> UpdateDocumentById(@PathVariable Long id,@RequestBody Document document){
        return  new ResponseEntity<>(documentService.updateDocumentById(id, document),HttpStatus.CREATED);

    }
}

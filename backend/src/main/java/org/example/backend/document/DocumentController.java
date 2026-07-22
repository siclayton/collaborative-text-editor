package org.example.backend.document;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentRepository documentRepository;

    public DocumentController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
    @PostMapping
    public Document createDocument(@RequestBody Document document) {
        return documentRepository.save(document);
    }
    @GetMapping
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }
    @GetMapping("/{id}")
    public Document getDocumentById(@PathVariable Long id) {
        return documentRepository.findById(id).orElseThrow();
    }
    @DeleteMapping("/{id}")
    public void deleteDocumentById(@PathVariable Long id) {
        documentRepository.deleteById(id);
    }
}
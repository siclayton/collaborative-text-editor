package org.example.backend.document;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }
    public Document getDocumentById(Long id) {
        return documentRepository.findById(id).orElseThrow();
    }
    public void deleteDocumentById(Long id) {
        documentRepository.deleteById(id);
    }
}
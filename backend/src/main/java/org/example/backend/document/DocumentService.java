package org.example.backend.document;

import org.example.backend.exception.DocumentNotFoundException;
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
        return documentRepository.findById(id).orElseThrow(()  -> new DocumentNotFoundException(id));
    }
    public void deleteDocumentById(Long id) {
        if (!documentRepository.existsById(id)) {
            throw new DocumentNotFoundException(id);
        }

        documentRepository.deleteById(id);
    }
    public Document updateDocumentById(Long id, Document document) {
        Document existingDocument = documentRepository.findById(id).orElseThrow(() ->  new DocumentNotFoundException(id));
        existingDocument.setTitle(document.getTitle());
        existingDocument.setContent(document.getContent());

        return documentRepository.save(existingDocument);
    }
}
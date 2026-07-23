package org.example.backend.exception;

public class DocumentNotFoundException extends RuntimeException{
    public DocumentNotFoundException(Long id) {
        super("Document with id " + id + " not found");
    }
}
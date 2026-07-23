package org.example.backend.exception;

public record ErrorResponse(
   String error,
   String message
) {}

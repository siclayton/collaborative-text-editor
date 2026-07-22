package org.example.backend.document;

import jakarta.persistence.*;

@Entity
@Table(name="documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    // Make this column use the text data type, as the content of a document can be large
    @Column(columnDefinition = "TEXT")
    private String content;

    public Document() {}
    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
}

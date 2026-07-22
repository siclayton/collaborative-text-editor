package org.example.backend.document;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@Table(name="documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String title;

    // Make this column use the text data type, as the content of a document can be large
    @Setter
    @Column(columnDefinition = "TEXT")
    private String content;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

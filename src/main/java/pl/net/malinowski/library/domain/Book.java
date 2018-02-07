package pl.net.malinowski.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "books")
@Getter @Setter @NoArgsConstructor
public class Book {

    @Id
    private String id;

    private String title;

    private LocalDate publicationDate;

    @DBRef
    private Author author;

    @DBRef
    private Publisher publisher;

    public Book(String title, LocalDate publicationDate, Author author, Publisher publisher) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.author = author;
        this.publisher = publisher;
    }
}

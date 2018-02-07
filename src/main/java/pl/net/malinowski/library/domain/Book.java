package pl.net.malinowski.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.Year;

@Document(collection = "books")
@Getter @Setter @NoArgsConstructor
public class Book {

    @Id
    private String id;

    private String title;

    private Integer publicationYear;

    @DBRef
    private Author author;

    @DBRef
    private Publisher publisher;

    public Book(String title, Integer publicationYear, Author author, Publisher publisher) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
        this.publisher = publisher;
    }
}

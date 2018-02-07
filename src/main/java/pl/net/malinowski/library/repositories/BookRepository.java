package pl.net.malinowski.library.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.net.malinowski.library.domain.Author;
import pl.net.malinowski.library.domain.Book;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findByTitle(String title);

}

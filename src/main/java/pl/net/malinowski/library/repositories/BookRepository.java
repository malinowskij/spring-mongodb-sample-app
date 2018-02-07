package pl.net.malinowski.library.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.net.malinowski.library.domain.Book;

public interface BookRepository extends MongoRepository<Book, String> {
}

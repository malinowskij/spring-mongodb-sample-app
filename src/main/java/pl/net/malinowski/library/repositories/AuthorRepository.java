package pl.net.malinowski.library.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.net.malinowski.library.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
}

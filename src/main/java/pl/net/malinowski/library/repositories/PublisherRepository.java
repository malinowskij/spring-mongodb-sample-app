package pl.net.malinowski.library.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.net.malinowski.library.domain.Publisher;

public interface PublisherRepository extends MongoRepository<Publisher, String> {
}

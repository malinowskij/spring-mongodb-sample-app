package pl.net.malinowski.library.services;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import pl.net.malinowski.library.domain.Author;
import pl.net.malinowski.library.domain.Book;
import pl.net.malinowski.library.domain.Publisher;
import pl.net.malinowski.library.repositories.AuthorRepository;
import pl.net.malinowski.library.repositories.BookRepository;
import pl.net.malinowski.library.repositories.PublisherRepository;

import java.time.LocalDate;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public ApplicationStartup(AuthorRepository authorRepository, BookRepository bookRepository,
                              PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();

        Author author = new Author("Henryk", "Sienkiewicz");
        authorRepository.save(author);

        Publisher publisher = new Publisher("Amber");
        publisherRepository.save(publisher);

        Book book = new Book("Krzyżacy", LocalDate.ofYearDay(1900, 1), author, publisher);
        bookRepository.save(book);
    }
}

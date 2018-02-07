package pl.net.malinowski.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.net.malinowski.library.repositories.AuthorRepository;
import pl.net.malinowski.library.repositories.BookRepository;
import pl.net.malinowski.library.repositories.PublisherRepository;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }
}

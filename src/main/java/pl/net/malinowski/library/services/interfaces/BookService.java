package pl.net.malinowski.library.services.interfaces;

import pl.net.malinowski.library.domain.Book;

import java.util.List;

public interface BookService {

    Book save (Book book);

    List<Book> findAll();

    Book findById(String id);
}

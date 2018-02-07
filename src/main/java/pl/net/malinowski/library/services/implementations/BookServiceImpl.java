package pl.net.malinowski.library.services.implementations;

import org.springframework.stereotype.Service;
import pl.net.malinowski.library.domain.Book;
import pl.net.malinowski.library.repositories.BookRepository;
import pl.net.malinowski.library.services.interfaces.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findOne(id);
    }
}

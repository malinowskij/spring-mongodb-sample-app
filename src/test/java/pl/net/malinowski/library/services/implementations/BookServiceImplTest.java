package pl.net.malinowski.library.services.implementations;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.net.malinowski.library.domain.Author;
import pl.net.malinowski.library.domain.Book;
import pl.net.malinowski.library.domain.Publisher;
import pl.net.malinowski.library.repositories.BookRepository;
import pl.net.malinowski.library.services.interfaces.BookService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class BookServiceImplTest {

    @Mock
    BookRepository bookRepository;

    BookService bookService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        bookService = new BookServiceImpl(bookRepository);
    }

    @Test
    public void save() {
        Author author = new Author("Henryk", "Sienkiewicz");
        Publisher publisher = new Publisher("Amber");
        Book book = new Book("Krzyżacy", 1900, author, publisher);
        Book persistedBook = new Book("Krzyżacy", 1900, author, publisher);
        persistedBook.setId("abcdefghijklm");

        when(bookRepository.save(any(Book.class))).thenReturn(persistedBook);

        Book returned = bookService.save(book);

        ArgumentCaptor<Book> bookArgument = ArgumentCaptor.forClass(Book.class);
        verify(bookRepository, times(1)).save(bookArgument.capture());
        verifyNoMoreInteractions(bookRepository);

        assertEquals("abcdefghijklm", returned.getId());
    }

    @Test
    public void findAll() {
        Book book = new Book();
        List<Book> books = new ArrayList<>();
        books.add(book);

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> returned = bookService.findAll();

        assertEquals(1, returned.size());
        verify(bookRepository, times(1)).findAll();
        verify(bookRepository, never()).findOne(anyString());
    }

    @Test
    public void findById() {
        Book book = new Book();
        book.setId("abcd");

        when(bookRepository.findOne(anyString())).thenReturn(book);

        Book returned = bookService.findById("abcd");

        assertNotNull(book);
        assertEquals(book, returned);
        verify(bookRepository, times(1)).findOne(anyString());
    }

    @Test
    public void findByTitle() {
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setTitle("Krzyżacy");
        books.add(book);

        when(bookRepository.findByTitle(anyString())).thenReturn(books);

        List<Book> returned = bookService.findByTitle("Krzyżacy");

        assertEquals(1, books.size());
        verify(bookRepository, times(1)).findByTitle(anyString());
    }
}
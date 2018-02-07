package pl.net.malinowski.library.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.net.malinowski.library.domain.Book;
import pl.net.malinowski.library.services.interfaces.BookService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookControllerTest {

    @Mock
    BookService bookService;

    BookController bookController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        bookController = new BookController(bookService);

        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void findAll() throws Exception {
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setId("abc");
        books.add(book);
        book = new Book();
        book.setId("cba");
        books.add(book);

        when(bookService.findAll()).thenReturn(books);

        mockMvc.perform(get("/book"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is("abc")))
                .andExpect(jsonPath("$[1].id", is("cba")));

        verify(bookService, times(1)).findAll();
        verifyNoMoreInteractions(bookService);
    }

    @Test
    public void findById() throws Exception {
        Book book = new Book();
        book.setId("abc");

        when(bookService.findById(anyString())).thenReturn(book);

        mockMvc.perform(get("/book/{id}", "abc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is("abc")));

        verify(bookService, times(1)).findById(anyString());
        verifyNoMoreInteractions(bookService);
    }

    @Test
    public void findByTitle() throws Exception {
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setId("abc");
        book.setTitle("Krzyżacy");
        books.add(book);
        book = new Book();
        book.setId("cba");
        book.setTitle("Dziady");
        books.add(book);

        when(bookService.findByTitle(anyString())).thenReturn(books);

        mockMvc.perform(get("/book/title/{title}", "Krzyżacy"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is("abc")))
                .andExpect(jsonPath("$[0].title", is("Krzyżacy")))
                .andExpect(jsonPath("$[1].id", is("cba")))
                .andExpect(jsonPath("$[1].title", is("Dziady")));
        verify(bookService, times(1)).findByTitle(anyString());
        verifyNoMoreInteractions(bookService);
    }
}
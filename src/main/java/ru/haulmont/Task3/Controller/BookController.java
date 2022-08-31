package ru.haulmont.Task3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.haulmont.Task3.Dto.BookDto;
import ru.haulmont.Task3.Entity.Book;
import ru.haulmont.Task3.Repository.BookRepository;
import ru.haulmont.Task3.Service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/all")
    public List<BookDto> getAllBook() {
        return bookService.getBooks();
    }

    @GetMapping("/create")
    public BookDto createBook(@RequestParam String name,
                              @RequestParam int year,
                              @RequestParam String manufacturer) {

        BookDto bookDto = new BookDto();

        bookDto.setBookName(name);
        bookDto.setYearPublished(year);
        bookDto.setManufacturer(manufacturer);

        bookService.createBook(bookDto);
        return bookDto;

    }
}

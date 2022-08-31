package ru.haulmont.Task3.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.haulmont.Task3.Dto.BookDto;
import ru.haulmont.Task3.Entity.Book;
import ru.haulmont.Task3.Repository.BookRepository;
import ru.haulmont.Task3.Service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("bookService")
@Profile("dev")
public class BookServiceStab implements BookService {

    @Value("${book.name}")
    private String defaultName;

    @Value("${book.year}")
    private int defaultYearPublished;

    @Value("${book.manufacturer}")
    private String defaultManufacturer;

    @Override
    public List<BookDto> getBooks() {
        List<BookDto> booksDtoList = new ArrayList<>();
        BookDto bookDto = new BookDto();

        bookDto.setId(UUID.randomUUID());
        bookDto.setBookName(defaultName);
        bookDto.setYearPublished(defaultYearPublished);
        bookDto.setManufacturer(defaultManufacturer);

        booksDtoList.add(bookDto);
        return booksDtoList;
    }

    @Override
    public void createBook(BookDto bookDto) {

    }
}

package ru.haulmont.Task3.Service;

import ru.haulmont.Task3.Dto.BookDto;
import ru.haulmont.Task3.Entity.Book;

import java.util.List;

public interface BookService {

    List<BookDto> getBooks();

    void createBook(BookDto bookDto);
}

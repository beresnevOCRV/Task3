package ru.haulmont.Task3.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.haulmont.Task3.Dto.BookDto;
import ru.haulmont.Task3.Entity.Book;
import ru.haulmont.Task3.Repository.BookRepository;
import ru.haulmont.Task3.Service.BookService;

import java.util.ArrayList;
import java.util.List;

@Service("bookService")
@Profile("prod")
public class BookServiceDB implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceDB(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> getBooks() {
        List<Book> Books = bookRepository.findAll();
        List<BookDto> booksDtoList = new ArrayList<>();

        Books.forEach( book -> {
            BookDto bookDto = new BookDto();
            bookDto.setId(book.getId());
            bookDto.setBookName(book.getName());
            bookDto.setYearPublished(book.getYear());
            bookDto.setManufacturer(book.getManufacturer());

            booksDtoList.add(bookDto);
        });
        return booksDtoList;
    }

    @Override
    public void createBook(BookDto bookDto) {
        Book book = new Book();

        book.setName(bookDto.getBookName());
        book.setYear(bookDto.getYearPublished());
        book.setManufacturer(bookDto.getManufacturer());

        bookRepository.save(book);
    }
}

package ru.haulmont.Task3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.haulmont.Task3.Entity.Book;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}

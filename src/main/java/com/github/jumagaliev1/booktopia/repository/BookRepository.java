package com.github.jumagaliev1.booktopia.repository;

import com.github.jumagaliev1.booktopia.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Optional<Book> findByBookName(String name);

    Book findByBookID(Long bookID);

    List<Book> findAllByBookCategory(String category);

}

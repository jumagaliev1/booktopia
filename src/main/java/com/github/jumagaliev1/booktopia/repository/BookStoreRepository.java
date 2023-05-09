package com.github.jumagaliev1.booktopia.repository;

import com.github.jumagaliev1.booktopia.model.BookStore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookStoreRepository extends CrudRepository<BookStore, Long> {
    Optional<BookStore> findByBookStoreName(String name);

    BookStore findByBookStoreId(Long id);
}

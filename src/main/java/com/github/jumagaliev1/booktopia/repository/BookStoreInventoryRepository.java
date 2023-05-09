package com.github.jumagaliev1.booktopia.repository;

import com.github.jumagaliev1.booktopia.model.BookStoreInventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookStoreInventoryRepository extends CrudRepository<BookStoreInventory, Long> {
    List<BookStoreInventory> findByBookStoreName(String bookStoreName);

    BookStoreInventory findByBookIdAndBookStoreId(Long bookID, Long bookStoreID);
}

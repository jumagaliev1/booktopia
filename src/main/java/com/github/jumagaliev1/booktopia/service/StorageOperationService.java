package com.github.jumagaliev1.booktopia.service;

import com.github.jumagaliev1.booktopia.model.Book;
import com.github.jumagaliev1.booktopia.model.BookStore;
import com.github.jumagaliev1.booktopia.model.BookStoreInventory;
import com.github.jumagaliev1.booktopia.model.BookStoreInventoryRequest;

import java.math.BigDecimal;

public interface StorageOperationService {
    BookStoreInventory addBookToTheBookStoreInventory(BookStoreInventoryRequest request);

    boolean removeBookFromTheBookStoreInventory(BookStoreInventoryRequest request);

    boolean bookAlreadyExist(Long bookId, Long bookStoreId);

    BookStore findBookStoreById(Long bookStoreId);

    Book findBookById(Long bookId);

    BigDecimal getCityPriceMultiplier(BookStore bookStore);
}

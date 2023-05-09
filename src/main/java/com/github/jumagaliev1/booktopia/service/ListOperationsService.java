package com.github.jumagaliev1.booktopia.service;

import com.github.jumagaliev1.booktopia.model.Book;
import com.github.jumagaliev1.booktopia.model.BookStore;
import com.github.jumagaliev1.booktopia.model.BookStoreInventory;
import com.github.jumagaliev1.booktopia.model.Category;

import java.util.List;

public interface ListOperationsService {
    List<Category> listAllCategories();

    List<Book> listAllBooks();

    List<BookStore> listAllBookStores();

    List<Book> listAllBooksByCategoryName(String categoryName);

    List<BookStoreInventory> listAllBooksByBookStoreName(String bookStoreName);
}

package com.github.jumagaliev1.booktopia.service;

import com.github.jumagaliev1.booktopia.model.Book;
import com.github.jumagaliev1.booktopia.model.BookStore;
import com.github.jumagaliev1.booktopia.model.Category;

public interface CreateOperationsService {

    Category createCategory(Category category);

    Book createBook(Book book);

    BookStore createBookStore(BookStore bookStore);
}

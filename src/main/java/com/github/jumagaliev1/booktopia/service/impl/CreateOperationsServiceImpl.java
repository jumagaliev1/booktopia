package com.github.jumagaliev1.booktopia.service.impl;

import com.github.jumagaliev1.booktopia.model.Book;
import com.github.jumagaliev1.booktopia.model.BookStore;
import com.github.jumagaliev1.booktopia.model.Category;
import com.github.jumagaliev1.booktopia.repository.BookRepository;
import com.github.jumagaliev1.booktopia.repository.BookStoreRepository;
import com.github.jumagaliev1.booktopia.repository.CategoryRepository;
import com.github.jumagaliev1.booktopia.service.CreateOperationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateOperationsServiceImpl implements CreateOperationsService {
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    private final BookStoreRepository bookStoreRepository;
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public BookStore createBookStore(BookStore bookStore) {
        return bookStoreRepository.save(bookStore);
    }
}

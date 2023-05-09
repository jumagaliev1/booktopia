package com.github.jumagaliev1.booktopia.service.impl;

import com.github.jumagaliev1.booktopia.model.Book;
import com.github.jumagaliev1.booktopia.model.BookStore;
import com.github.jumagaliev1.booktopia.model.BookStoreInventory;
import com.github.jumagaliev1.booktopia.model.Category;
import com.github.jumagaliev1.booktopia.repository.BookRepository;
import com.github.jumagaliev1.booktopia.repository.BookStoreInventoryRepository;
import com.github.jumagaliev1.booktopia.repository.BookStoreRepository;
import com.github.jumagaliev1.booktopia.repository.CategoryRepository;
import com.github.jumagaliev1.booktopia.service.ListOperationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListOperationsServiceImpl implements ListOperationsService {
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    private final BookStoreRepository bookStoreRepository;
    private final BookStoreInventoryRepository bookStoreInventoryRepository;

    @Override
    public List<Category> listAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public List<Book> listAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public List<BookStore> listAllBookStores() {
        return (List<BookStore>) bookStoreRepository.findAll();
    }

    @Override
    public List<Book> listAllBooksByCategoryName(String categoryName) {
        return bookRepository.findAllByBookCategory(categoryName);
    }

    @Override
    public List<BookStoreInventory> listAllBooksByBookStoreName(String bookStoreName) {
        return bookStoreInventoryRepository.findByBookStoreName(bookStoreName);
    }
}

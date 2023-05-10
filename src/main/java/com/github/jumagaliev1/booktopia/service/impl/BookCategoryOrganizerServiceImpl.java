package com.github.jumagaliev1.booktopia.service.impl;

import com.github.jumagaliev1.booktopia.model.Book;
import com.github.jumagaliev1.booktopia.model.Category;
import com.github.jumagaliev1.booktopia.repository.BookRepository;
import com.github.jumagaliev1.booktopia.repository.CategoryRepository;
import com.github.jumagaliev1.booktopia.service.BookCategoryOrganizerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class BookCategoryOrganizerServiceImpl implements BookCategoryOrganizerService {
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    @Override
    public Book changeBookCategory(Long bookID, Long categoryID) {
        Book book = bookRepository.findByBookId(bookID);
        Category category = categoryRepository.findByCategoryId(categoryID);

        book.setBookCategory(category.getCategoryName());

        return bookRepository.save(book);
    }
}

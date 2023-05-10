package com.github.jumagaliev1.booktopia.service;


import com.github.jumagaliev1.booktopia.model.Book;
import com.github.jumagaliev1.booktopia.model.Category;
import com.github.jumagaliev1.booktopia.repository.BookRepository;
import com.github.jumagaliev1.booktopia.repository.CategoryRepository;
import com.github.jumagaliev1.booktopia.service.impl.BookCategoryOrganizerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
@RunWith(MockitoJUnitRunner.class)
@RequiredArgsConstructor
public class BookCategoryOrganizerServiceTest {

    @InjectMocks
    private BookCategoryOrganizerServiceImpl bookCategoryOrganizerServiceImpl;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void changeBookCategory() {
        Book book = new Book();
        book.setBookId(1L);
        book.setBookName("Lord of the Rings");
        book.setBookCategory("Fantasy");
        book.setBookPrice(BigDecimal.valueOf(50));

        Category category = new Category();
        category.setCategoryId(1L);
        category.setCategoryName("History");

        Mockito.when(bookRepository.findByBookId(book.getBookId())).thenReturn(book);
        Mockito.when(categoryRepository.findByCategoryId(category.getCategoryId())).thenReturn(category);
        Mockito.when(bookCategoryOrganizerServiceImpl.changeBookCategory(book.getBookId(), category.getCategoryId())).thenReturn(book);

        Book actualBook = bookCategoryOrganizerServiceImpl.changeBookCategory(book.getBookId(), category.getCategoryId());

        Assert.assertEquals(actualBook.getBookCategory(), book.getBookCategory());
    }
}

package com.github.jumagaliev1.booktopia.service;

import com.github.jumagaliev1.booktopia.model.Book;
import com.github.jumagaliev1.booktopia.model.BookStore;
import com.github.jumagaliev1.booktopia.model.Category;
import com.github.jumagaliev1.booktopia.repository.BookRepository;
import com.github.jumagaliev1.booktopia.repository.BookStoreRepository;
import com.github.jumagaliev1.booktopia.repository.CategoryRepository;
import com.github.jumagaliev1.booktopia.service.impl.CreateOperationsServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class CreateOperationServiceTest {
    @InjectMocks
    private CreateOperationsServiceImpl createOperationsService;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookStoreRepository bookStoreRepository;

    @Test
    public void createCategory() {
        Category category = new Category();
        category.setCategoryId(1L);
        category.setCategoryName("History");

        Mockito.when(createOperationsService.createCategory(category)).thenReturn(category);

        Category actualCategory = createOperationsService.createCategory(category);

        Assert.assertEquals(actualCategory.getCategoryName(), category.getCategoryName());
    }

    @Test
    public void createBook() {
        Book book = new Book();
        book.setBookId(1L);
        book.setBookName("Witcher");
        book.setBookCategory("Fantasy");
        book.setBookPrice(BigDecimal.valueOf(50));

        Mockito.when(createOperationsService.createBook(book)).thenReturn(book);

        Book actualBook = createOperationsService.createBook(book);

        Assert.assertEquals(actualBook.getBookName(), book.getBookName());
    }

    @Test
    public void createBookStore() {
        BookStore bookStore = new BookStore();
        bookStore.setBookStoreId(1L);
        bookStore.setBookStoreCity("Almaty");
        bookStore.setBookStoreName("Kitap AL Store");

        Mockito.when(createOperationsService.createBookStore(bookStore)).thenReturn(bookStore);

        BookStore actualBookStore = createOperationsService.createBookStore(bookStore);

        Assert.assertEquals(actualBookStore.getBookStoreName(), bookStore.getBookStoreName());
    }
}

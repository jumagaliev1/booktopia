package com.github.jumagaliev1.booktopia.controller;


import com.github.jumagaliev1.booktopia.model.Book;
import com.github.jumagaliev1.booktopia.model.BookStore;
import com.github.jumagaliev1.booktopia.model.BookStoreInventory;
import com.github.jumagaliev1.booktopia.model.BookStoreInventoryRequest;
import com.github.jumagaliev1.booktopia.service.impl.StorageOperationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class StorageOperationControllerTest {
    @InjectMocks
    private StorageOperationController storageOperationController;

    @Mock
    private StorageOperationServiceImpl storageOperationService;

    @Test
    public void addBookToBookStoreInventory() {
        BookStore bookStore = new BookStore();
        bookStore.setBookStoreId(1L);
        bookStore.setBookStoreCity("Almaty");
        bookStore.setBookStoreName("Kitap AL Store");

        Book book = new Book();
        book.setBookId(1L);
        book.setBookName("Witcher");
        book.setBookCategory("Fantasy");
        book.setBookPrice(BigDecimal.valueOf(50));

        BookStoreInventory existingbookStoreInventory = new BookStoreInventory();
        existingbookStoreInventory.setBookStoreInventoryId(1L);
        existingbookStoreInventory.setBookStoreId(bookStore.getBookStoreId());
        existingbookStoreInventory.setBookStoreName(bookStore.getBookStoreName());
        existingbookStoreInventory.setBookStoreCity(bookStore.getBookStoreCity());
        existingbookStoreInventory.setBookName(book.getBookName());
        existingbookStoreInventory.setBookPrice(book.getBookPrice());
        existingbookStoreInventory.setBookQuantity(10L);

        BookStoreInventoryRequest bookStoreInventoryRequest = new BookStoreInventoryRequest();
        bookStoreInventoryRequest.setBookStoreId(1L);
        bookStoreInventoryRequest.setBookId(1L);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(storageOperationService.addBookToTheBookStoreInventory(bookStoreInventoryRequest)).thenReturn(existingbookStoreInventory);

        storageOperationController.addBookToBookStoreInventory(bookStoreInventoryRequest);

        Mockito.verify(storageOperationService, Mockito.times(1)).addBookToTheBookStoreInventory(bookStoreInventoryRequest);
    }

    @Test
    public void removeBookFromTheBookStoreInventory() {
        BookStore bookStore = new BookStore();
        bookStore.setBookStoreId(1L);
        bookStore.setBookStoreCity("Almaty");
        bookStore.setBookStoreName("Kitap AL Store");

        Book book = new Book();
        book.setBookId(1L);
        book.setBookName("Witcher");
        book.setBookCategory("Fantasy");
        book.setBookPrice(BigDecimal.valueOf(50));

        BookStoreInventory existingbookStoreInventory = new BookStoreInventory();
        existingbookStoreInventory.setBookStoreInventoryId(1L);
        existingbookStoreInventory.setBookStoreId(bookStore.getBookStoreId());
        existingbookStoreInventory.setBookStoreName(bookStore.getBookStoreName());
        existingbookStoreInventory.setBookStoreCity(bookStore.getBookStoreCity());
        existingbookStoreInventory.setBookName(book.getBookName());
        existingbookStoreInventory.setBookPrice(book.getBookPrice());
        existingbookStoreInventory.setBookQuantity(10L);

        BookStoreInventoryRequest bookStoreInventoryRequest = new BookStoreInventoryRequest();
        bookStoreInventoryRequest.setBookStoreId(1L);
        bookStoreInventoryRequest.setBookId(1L);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));


        Mockito.when(storageOperationService.removeBookFromTheBookStoreInventory(bookStoreInventoryRequest)).thenReturn(true);

        storageOperationController.removeBookFromTheBookStoreInventory(bookStoreInventoryRequest);

        Mockito.verify(storageOperationService, Mockito.times(1)).removeBookFromTheBookStoreInventory(bookStoreInventoryRequest);
    }
}

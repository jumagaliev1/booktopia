package com.github.jumagaliev1.booktopia.service;


import com.github.jumagaliev1.booktopia.model.Book;
import com.github.jumagaliev1.booktopia.model.BookStore;
import com.github.jumagaliev1.booktopia.model.BookStoreInventory;
import com.github.jumagaliev1.booktopia.model.BookStoreInventoryRequest;
import com.github.jumagaliev1.booktopia.repository.BookRepository;
import com.github.jumagaliev1.booktopia.repository.BookStoreInventoryRepository;
import com.github.jumagaliev1.booktopia.repository.BookStoreRepository;
import com.github.jumagaliev1.booktopia.service.impl.StorageOperationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class StorageOperationServiceTest {
    @InjectMocks
    private StorageOperationServiceImpl storageOperationService;

    @Mock
    private BookStoreInventoryRepository bookStoreInventoryRepository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookStoreRepository bookStoreRepository;

    private Book book;
    private BookStore bookStore;
    private BookStoreInventory existingbookStoreInventory;
    private BookStoreInventory newBookStoreInventory;
    private BookStoreInventoryRequest request;

    @Before
    public void init() {
        bookStore = new BookStore();
        bookStore.setBookStoreId(1L);
        bookStore.setBookStoreCity("ALMATY");
        bookStore.setBookStoreName("Kitap AL Store");

        book = new Book();
        book.setBookId(1L);
        book.setBookName("Witcher");
        book.setBookCategory("Fantasy");
        book.setBookPrice(BigDecimal.valueOf(50));

        existingbookStoreInventory = new BookStoreInventory();
        existingbookStoreInventory.setBookStoreInventoryId(1L);
        existingbookStoreInventory.setBookStoreId(bookStore.getBookStoreId());
        existingbookStoreInventory.setBookStoreName(bookStore.getBookStoreName());
        existingbookStoreInventory.setBookStoreCity(bookStore.getBookStoreCity());
        existingbookStoreInventory.setBookName(book.getBookName());
        existingbookStoreInventory.setBookPrice(book.getBookPrice());
        existingbookStoreInventory.setBookQuantity(10L);

        newBookStoreInventory = new BookStoreInventory();
        newBookStoreInventory.setBookStoreInventoryId(1L);
        newBookStoreInventory.setBookStoreId(bookStore.getBookStoreId());
        newBookStoreInventory.setBookStoreName(bookStore.getBookStoreName());
        newBookStoreInventory.setBookStoreCity(bookStore.getBookStoreCity());
        newBookStoreInventory.setBookName(book.getBookName());
        newBookStoreInventory.setBookPrice(book.getBookPrice());
        newBookStoreInventory.setBookQuantity(10L);

        request = new BookStoreInventoryRequest();
        request.setBookId(book.getBookId());
        request.setBookStoreId(bookStore.getBookStoreId());
    }

    @Test
    public void addBookToTheBookStoreInventoryIfTheBookAlreadyExists() {
        Mockito.when(bookStoreRepository.findByBookStoreId(bookStore.getBookStoreId())).thenReturn(bookStore);
        Mockito.when(bookRepository.findByBookId(book.getBookId())).thenReturn(book);
        Mockito.when(bookStoreInventoryRepository.findByBookIdAndBookStoreId(book.getBookId(), bookStore.getBookStoreId())).thenReturn(existingbookStoreInventory);
        Mockito.when(bookStoreInventoryRepository.save(existingbookStoreInventory)).thenReturn(existingbookStoreInventory);


        BookStoreInventory actualBookStoreInventory = storageOperationService.addBookToTheBookStoreInventory(request);

        Assert.assertEquals(actualBookStoreInventory.getBookQuantity(), existingbookStoreInventory.getBookQuantity());
    }

    @Test
    public void addBookToTheBookStoreInventoryIfTheBookDoesNotExists() {
        Mockito.when(bookStoreRepository.findByBookStoreId(bookStore.getBookStoreId())).thenReturn(bookStore);
        Mockito.when(bookRepository.findByBookId(book.getBookId())).thenReturn(book);
        Mockito.when(bookStoreInventoryRepository.findByBookIdAndBookStoreId(book.getBookId(), bookStore.getBookStoreId())).thenReturn(null);
        Mockito.when(bookStoreInventoryRepository.save(newBookStoreInventory)).thenReturn(newBookStoreInventory);
        Mockito.when(storageOperationService.addBookToTheBookStoreInventory(request)).thenReturn(newBookStoreInventory);

        Assert.assertEquals(newBookStoreInventory.getBookName(), newBookStoreInventory.getBookName());
    }

    @Test
    public void removeBookFromTheBookStoreInventoryIfBookNotExist() {
        Mockito.when(bookStoreInventoryRepository.findByBookIdAndBookStoreId(book.getBookId(), bookStore.getBookStoreId())).thenReturn(null);
        Mockito.doNothing().when(bookStoreInventoryRepository).delete(existingbookStoreInventory);

        boolean actualResult = storageOperationService.removeBookFromTheBookStoreInventory(request);

        Assert.assertFalse(actualResult);
    }

    @Test
    public void removeBookFromTheBookStoreInventoryIfBookExist() {
        Mockito.when(bookStoreInventoryRepository.findByBookIdAndBookStoreId(book.getBookId(), bookStore.getBookStoreId())).thenReturn(existingbookStoreInventory);
        Mockito.doNothing().when(bookStoreInventoryRepository).delete(existingbookStoreInventory);

        boolean actualResult = storageOperationService.removeBookFromTheBookStoreInventory(request);

        Assert.assertTrue(actualResult);
    }
}

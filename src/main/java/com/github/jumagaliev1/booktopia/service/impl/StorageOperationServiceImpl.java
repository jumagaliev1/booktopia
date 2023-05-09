package com.github.jumagaliev1.booktopia.service.impl;

import com.github.jumagaliev1.booktopia.model.Book;
import com.github.jumagaliev1.booktopia.model.BookStore;
import com.github.jumagaliev1.booktopia.model.BookStoreInventory;
import com.github.jumagaliev1.booktopia.model.BookStoreInventoryRequest;
import com.github.jumagaliev1.booktopia.repository.BookStoreInventoryRepository;
import com.github.jumagaliev1.booktopia.repository.BookRepository;
import com.github.jumagaliev1.booktopia.repository.BookStoreRepository;
import com.github.jumagaliev1.booktopia.service.StorageOperationService;
import com.github.jumagaliev1.booktopia.util.enums.PriceEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class StorageOperationServiceImpl implements StorageOperationService {

    private static final Long ADD_NEW_ONE_BOOK = 1L;

    private final BookStoreInventoryRepository bookStoreInventoryRepository;
    private final BookRepository bookRepository;
    private final BookStoreRepository bookStoreRepository;
    @Override
    public BookStoreInventory addBookToTheBookStoreInventory(BookStoreInventoryRequest request) {
        BookStore bookStore = findBookStoreById(request.getBookStoreID());
        Book book = findBookById(request.getBookID());

        BigDecimal priceMultiplier = getCityPriceMultiplier(bookStore);

        if (bookAlreadyExist(request.getBookID(), request.getBookStoreID())) {
            BookStoreInventory existingbookStoreInventory = bookStoreInventoryRepository.findByBookIdAndBookStoreId(request.getBookID(), request.getBookStoreID());
            Long existingQuantity = existingbookStoreInventory.getBookQuantity();
            existingbookStoreInventory.setBookQuantity(existingQuantity + ADD_NEW_ONE_BOOK);
            return bookStoreInventoryRepository.save(existingbookStoreInventory);
        } else {
            BookStoreInventory newBookStoreInventory = new BookStoreInventory();
            newBookStoreInventory.setBookID(book.getBookId());
            newBookStoreInventory.setBookName(book.getBookName());
            newBookStoreInventory.setBookPrice(book.getBookPrice().multiply(priceMultiplier));
            newBookStoreInventory.setBookStoreCity(bookStore.getBookStoreCity());
            newBookStoreInventory.setBookStoreID(bookStore.getBookStoreId());
            newBookStoreInventory.setBookStoreName(bookStore.getBookStoreName());
            newBookStoreInventory.setBookQuantity(1L);
            return bookStoreInventoryRepository.save(newBookStoreInventory);
        }
    }

    @Override
    public boolean removeBookFromTheBookStoreInventory(BookStoreInventoryRequest request) {
        if (bookAlreadyExist(request.getBookID(), request.getBookStoreID())) {
            BookStoreInventory existingbookStoreInventory = bookStoreInventoryRepository.findByBookIdAndBookStoreId(request.getBookID(), request.getBookStoreID());

            bookStoreInventoryRepository.delete(existingbookStoreInventory);
            return true;
        }
        return false;
    }

    @Override
    public boolean bookAlreadyExist(Long bookId, Long bookStoreId) {
        return bookStoreInventoryRepository.findByBookIdAndBookStoreId(bookId, bookStoreId) != null;
    }

    @Override
    public BookStore findBookStoreById(Long bookStoreId) {
        return bookStoreRepository.findByBookStoreId(bookStoreId);
    }

    @Override
    public Book findBookById(Long bookID) {
        return bookRepository.findByBookID(bookID);
    }

    @Override
    public BigDecimal getCityPriceMultiplier(BookStore bookStore) {
        PriceEnum priceMultiplier = PriceEnum.valueOf(bookStore.getBookStoreCity());
        return new BigDecimal(priceMultiplier.getValue());
    }
}

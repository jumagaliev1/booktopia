package com.github.jumagaliev1.booktopia.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String bookCategory;

    private String bookName;

    private BigDecimal bookPrice;

    public Book() {
    }

    public Book(String bookName, String bookCategory, BigDecimal bookPrice) {
        this.bookName = bookName;
        this.bookCategory = bookCategory;
        this.bookPrice = bookPrice;
    }
}

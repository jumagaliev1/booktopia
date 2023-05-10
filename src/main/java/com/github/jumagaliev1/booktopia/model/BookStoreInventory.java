package com.github.jumagaliev1.booktopia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class BookStoreInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookStoreInventoryId;

    private Long bookStoreId;

    private String bookStoreName;

    private Long bookId;

    private String bookName;

    private Long bookQuantity;

    private BigDecimal bookPrice;

    private String bookStoreCity;
}

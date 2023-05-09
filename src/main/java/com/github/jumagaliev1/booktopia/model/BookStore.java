package com.github.jumagaliev1.booktopia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookStoreId;

    private String bookStoreCity;

    private String bookStoreName;

    public BookStore() {
    }

    public BookStore(String bookStoreName) {
        this.bookStoreName = bookStoreName;
    }
}

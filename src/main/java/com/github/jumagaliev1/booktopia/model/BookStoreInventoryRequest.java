package com.github.jumagaliev1.booktopia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookStoreInventoryRequest {
    private Long bookStoreID;
    private Long bookID;

}

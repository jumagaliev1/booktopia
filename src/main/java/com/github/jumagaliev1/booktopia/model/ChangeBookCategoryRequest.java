package com.github.jumagaliev1.booktopia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeBookCategoryRequest {
    Long bookId;
    String bookCategory;
}

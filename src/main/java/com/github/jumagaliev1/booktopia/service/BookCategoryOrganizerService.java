package com.github.jumagaliev1.booktopia.service;

import com.github.jumagaliev1.booktopia.model.Book;

public interface BookCategoryOrganizerService {
    Book changeBookCategory(Long bookID, Long categoryID);
}

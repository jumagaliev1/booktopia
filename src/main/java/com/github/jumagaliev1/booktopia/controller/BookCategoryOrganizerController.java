package com.github.jumagaliev1.booktopia.controller;

import com.github.jumagaliev1.booktopia.service.BookCategoryOrganizerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/api/books")
public class BookCategoryOrganizerController {
    private final BookCategoryOrganizerService bookCategoryOrganizerService;
    private final Logger logger = LoggerFactory.getLogger(BookCategoryOrganizerController.class);
    public BookCategoryOrganizerController(BookCategoryOrganizerService bookCategoryOrganizerService) {
        this.bookCategoryOrganizerService = bookCategoryOrganizerService;
    }

    @GetMapping(value = "/changeBookCategory")
    public @ResponseBody
    Book changeBookCategory(@RequestParam Long bookId, @RequestParam Long categoryId) {
        logger.info("BookCategoryOrganizerController - changeBookCategory api called for bookId:{}, categoryId:{}", bookId, categoryId);
        return bookCategoryOrganizerService.changeBookCategory(bookId, categoryId);
    }
}

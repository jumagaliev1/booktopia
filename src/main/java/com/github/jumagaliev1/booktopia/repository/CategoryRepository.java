package com.github.jumagaliev1.booktopia.repository;

import com.github.jumagaliev1.booktopia.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByCategoryName(String name);

    Category findByCategoryId(Long categoryId);
}

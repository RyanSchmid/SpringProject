package com.codeup.project.services;

import com.codeup.project.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepo extends CrudRepository<Category, Long> {
}

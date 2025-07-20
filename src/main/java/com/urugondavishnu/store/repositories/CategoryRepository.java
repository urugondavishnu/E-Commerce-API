package com.urugondavishnu.store.repositories;

import com.urugondavishnu.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}
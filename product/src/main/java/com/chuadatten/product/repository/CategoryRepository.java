package com.chuadatten.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chuadatten.product.entity.Category;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    Optional<Category> findBySlug(String slug);
    List<Category> findByParentId(String parentId);
    
}

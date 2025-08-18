package com.chuadatten.product.repository;

import com.chuadatten.product.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findBySlug(String slug);

    List<Product> findByCategoryIdsContainsAndActiveIsTrue(String categoryId);

    Page<Product> findAllByCategoryIdsContaining(String categoryId, Pageable pageable);

    @Query("{ $text: { $search: ?0 } }")
    List<Product> searchByText(String keyword);
}

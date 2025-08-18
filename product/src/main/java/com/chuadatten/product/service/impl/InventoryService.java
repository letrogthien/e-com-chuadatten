package com.chuadatten.product.service.impl;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.chuadatten.product.entity.ProductVariant;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final MongoTemplate mongoTemplate;

    private static final String A_STRING = "availableQty";
    private static final String R_STRING = "reservedQty";

    /** Reserve n units if availableQty >= n. */
    public ProductVariant reserve(String variantId, int n) {
        Query q = new Query(Criteria.where("_id").is(variantId)
                .and(A_STRING).gte(n));
        Update u = new Update()
                .inc(A_STRING, -n)
                .inc(R_STRING, n);
        return mongoTemplate.findAndModify(q, u,
                FindAndModifyOptions.options().returnNew(true),
                ProductVariant.class);
    }

    /** Confirm a reservation -> move from reserved to sold. */
    public ProductVariant commit(String variantId, int n) {
        Query q = new Query(Criteria.where("_id").is(variantId)
                .and(R_STRING).gte(n));
        Update u = new Update()
                .inc(R_STRING, -n)
                .inc("soldQty", n);
        return mongoTemplate.findAndModify(q, u,
                FindAndModifyOptions.options().returnNew(true),
                ProductVariant.class);
    }

    /** Cancel a reservation -> return to available. */
    public ProductVariant release(String variantId, int n) {
        Query q = new Query(Criteria.where("_id").is(variantId)
                .and(R_STRING).gte(n));
        Update u = new Update()
                .inc(R_STRING, -n)
                .inc(A_STRING, n);
        return mongoTemplate.findAndModify(q, u,
                FindAndModifyOptions.options().returnNew(true),
                ProductVariant.class);
    }
}
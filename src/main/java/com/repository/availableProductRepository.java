package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.entity.availableProduct;

public interface availableProductRepository extends MongoRepository<availableProduct, String> {

}

package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.entity.sellProduct;

public interface sellProductRepository extends MongoRepository<sellProduct, String> {

}

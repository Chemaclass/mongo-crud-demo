package com.chemaclass.mongocruddemo.repository;

import com.chemaclass.mongocruddemo.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}

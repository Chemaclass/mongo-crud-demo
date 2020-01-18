package com.chemaclass.mongocruddemo.service;

import com.chemaclass.mongocruddemo.entity.Item;
import com.chemaclass.mongocruddemo.repository.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public void save(Item item) {
        repository.save(item);
    }

    public List<Item> getAll() {
        return repository.findAll();
    }

    public Optional<Item> getById(String id) {
        return repository.findById(id);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public ResponseEntity<Item> update(String id, Item newItem) {
        Optional<Item> optionalItem = repository.findById(id);

        if(optionalItem.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Item item = optionalItem.get();
        item.setName(newItem.getName());
        item.setPrice(newItem.getPrice());
        repository.save(item);

        return ResponseEntity.of(optionalItem);
    }
}

package com.chemaclass.mongocruddemo.service;

import com.chemaclass.mongocruddemo.entity.Item;
import com.chemaclass.mongocruddemo.repository.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(final ItemRepository repository) {
        this.repository = repository;
    }

    public void save(final Item item) {
        repository.save(item);
    }

    public List<Item> getAll() {
        return repository.findAll();
    }

    public Optional<Item> getById(final String id) {
        return repository.findById(id);
    }

    public void deleteById(final String id) {
        repository.deleteById(id);
    }

    public ResponseEntity<Item> update(final String id, final Item newItem) {
        final Optional<Item> optionalItem = repository.findById(id);

        if (optionalItem.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        final Item item = optionalItem.get();
        item.setName(newItem.getName());
        item.setPrice(newItem.getPrice());
        repository.save(item);

        return ResponseEntity.of(optionalItem);
    }
}

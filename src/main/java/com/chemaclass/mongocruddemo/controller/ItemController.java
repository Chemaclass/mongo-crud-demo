package com.chemaclass.mongocruddemo.controller;

import com.chemaclass.mongocruddemo.entity.Item;
import com.chemaclass.mongocruddemo.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {

    private final ItemService service;

    public ItemController(final ItemService service) {
        this.service = service;
    }

    @PostMapping
    public void create(final @RequestBody Item item) {
        service.save(item);
    }

    @GetMapping
    public List<Item> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Item> getOne(final @PathVariable String id) {
        return ResponseEntity.of(service.getById(id));
    }

    @DeleteMapping("{id}")
    public void delete(final @PathVariable String id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Item> update(
            final @PathVariable String id,
            final @RequestBody Item newItem
    ) {
        return service.update(id, newItem);
    }
}

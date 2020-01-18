package com.chemaclass.mongocruddemo.controller;

import com.chemaclass.mongocruddemo.entity.Item;
import com.chemaclass.mongocruddemo.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("items")
public class ItemController {

    private ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody Item item) {
        service.save(item);
    }

    @GetMapping
    public List<Item> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Item> getOne(@PathVariable String id) {
        return ResponseEntity.of(service.getById(id));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Item> update(
            @PathVariable String id,
            @RequestBody Item newItem
    ) {
        return service.update(id, newItem);
    }
}

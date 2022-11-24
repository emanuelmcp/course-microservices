package io.github.emanuelmcp.items.controllers;

import io.github.emanuelmcp.items.api.services.ItemService;
import io.github.emanuelmcp.items.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/list")
    public List<Item> viewAll(){
        return itemService.findAll();
    }

    @GetMapping("/view/{id}/quantity/{quantity}")
    public Item viewDetail(@PathVariable Long id, @PathVariable Integer quantity){
        return itemService.findById(id, quantity);
    }
}

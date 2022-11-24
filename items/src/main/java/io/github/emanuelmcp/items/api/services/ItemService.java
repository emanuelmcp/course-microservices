package io.github.emanuelmcp.items.api.services;

import io.github.emanuelmcp.items.models.Item;

import java.util.List;

public interface ItemService {
    public List<Item> findAll();
    public Item findById(Long id, Integer quantity);
}

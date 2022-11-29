package io.github.emanuelmcp.items.services;

import io.github.emanuelmcp.items.api.services.ItemService;
import io.github.emanuelmcp.items.models.Item;
import io.github.emanuelmcp.items.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    RestTemplate restClient;

    @Autowired
    public ItemServiceImpl(RestTemplate restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<Item> findAll() {
        List<Product> products = Arrays.asList(
                Objects.requireNonNull(restClient.getForObject("http://localhost:8001/list", Product[].class))
        );
        return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }
    @Override
    public Item findById(Long id, Integer quantity) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        Product product = restClient.getForObject("http://localhost:8001/list/{id}", Product.class, pathVariables);
        return new Item(product, quantity);
    }
}

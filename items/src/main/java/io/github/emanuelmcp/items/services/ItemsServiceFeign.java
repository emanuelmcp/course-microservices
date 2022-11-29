package io.github.emanuelmcp.items.services;

import io.github.emanuelmcp.items.api.services.ItemService;
import io.github.emanuelmcp.items.clients.ClientProductRest;
import io.github.emanuelmcp.items.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
@Primary
public class ItemsServiceFeign implements ItemService {
    ClientProductRest feignClient;
    @Autowired
    public ItemsServiceFeign(ClientProductRest feignClient) {
        this.feignClient = feignClient;
    }
    @Override
    public List<Item> findAll() {
        return feignClient.listProducts().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }
    @Override
    public Item findById(Long id, Integer quantity) {
        return new Item(feignClient.viewDetail(id), quantity);
    }
}

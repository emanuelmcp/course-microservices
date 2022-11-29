package io.github.emanuelmcp.items.clients;

import io.github.emanuelmcp.items.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "servicio-productos", url = "localhost:8001")
public interface ClientProductRest {

    @GetMapping("/list")
    List<Product> listProducts();

    @GetMapping("/list/{id}")
    Product viewDetail(@PathVariable Long id);

}

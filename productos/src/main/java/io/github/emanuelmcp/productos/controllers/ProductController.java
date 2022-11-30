package io.github.emanuelmcp.productos.controllers;

import io.github.emanuelmcp.productos.api.services.IProductService;
import io.github.emanuelmcp.productos.database.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    private final IProductService productService;
    private final Environment environment;

    @Autowired
    public ProductController(IProductService productService, Environment environment) {
        this.productService = productService;
        this.environment = environment;
    }


    @GetMapping("/list")
    public List<Product> listProducts(){
        return productService.findAll().stream().map(p -> {
            p.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            return p;
        }).collect(Collectors.toList());
    }

    @GetMapping("/list/{id}")
    public Product viewDetail(@PathVariable Long id){
        return productService.findById(id);
    }
}

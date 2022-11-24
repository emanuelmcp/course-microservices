package io.github.emanuelmcp.productos.controllers;

import io.github.emanuelmcp.productos.api.services.IProductService;
import io.github.emanuelmcp.productos.database.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/list")
    public List<Product> listProducts(){
        return productService.findAll();
    }

    @GetMapping("/list/{id}")
    public Product viewDetail(@PathVariable Long id){
        return productService.findById(id);
    }
}

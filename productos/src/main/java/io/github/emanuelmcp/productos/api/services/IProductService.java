package io.github.emanuelmcp.productos.api.services;

import io.github.emanuelmcp.productos.database.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    public Product findById(Long id);
}

package io.github.emanuelmcp.productos.services;

import io.github.emanuelmcp.productos.api.database.repository.ProductRepository;
import io.github.emanuelmcp.productos.api.services.IProductService;
import io.github.emanuelmcp.productos.database.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProductImpl implements IProductService {
    ProductRepository repository;

    @Autowired
    public ServiceProductImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}

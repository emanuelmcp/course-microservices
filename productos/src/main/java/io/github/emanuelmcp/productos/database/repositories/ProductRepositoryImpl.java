package io.github.emanuelmcp.productos.database.repositories;

import io.github.emanuelmcp.productos.api.database.repository.ProductRepository;
import io.github.emanuelmcp.productos.database.managers.PostgresManager;
import io.github.emanuelmcp.productos.database.mappers.ProductMapper;
import io.github.emanuelmcp.productos.database.models.Product;
import io.github.emanuelmcp.productos.database.queries.ProductQueries;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    Connection connection;
    PreparedStatement statement;
    ResultSet results;
    PostgresManager pool;
    ProductMapper mapper;

    @Autowired
    public ProductRepositoryImpl(PostgresManager pool, ProductMapper mapper) {
        this.pool = pool;
        this.mapper = mapper;
    }

    @Override
    public void save(Product entity) {

    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public @Nullable List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            this.connection = pool.getConnection();
            this.statement = connection.prepareStatement(ProductQueries.FIND_ALL);
            this.results = statement.executeQuery();
            Product product;
            while (results.next()) {
                product = mapper.mapRowReader(results);
                products.add(product);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            pool.close(connection,statement, results);
        }
        return products;
    }

    @Override
    public Product findById(Long id) {
        Product product = null;
        try {
            this.connection = pool.getConnection();
            this.statement = connection.prepareStatement(ProductQueries.FIND_BY_ID);
            statement.setLong(1, id);
            this.results = statement.executeQuery();
            if (results.next()) product = mapper.mapRowReader(results);
        } catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            pool.close(connection,statement, results);
        }
        return product;
    }
}

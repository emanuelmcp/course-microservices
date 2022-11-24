package io.github.emanuelmcp.productos.database.mappers;

import io.github.emanuelmcp.productos.api.database.mapper.RowMapper;
import io.github.emanuelmcp.productos.database.models.Product;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRowReader(ResultSet rs) throws SQLException {
        return new Product(
                rs.getLong("product_id"),
                rs.getString("product_name"),
                rs.getDouble("product_price"),
                rs.getDate("created_at")
        );
    }
}

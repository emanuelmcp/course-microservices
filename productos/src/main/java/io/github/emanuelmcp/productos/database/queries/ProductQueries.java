package io.github.emanuelmcp.productos.database.queries;

public class ProductQueries {
    public final static String FIND_ALL = "SELECT * FROM products";
    public final static String FIND_BY_ID = "SELECT * FROM products WHERE product_id = ?";
}

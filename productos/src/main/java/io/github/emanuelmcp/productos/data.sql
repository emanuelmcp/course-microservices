CREATE TABLE products(
                         product_id SERIAL PRIMARY KEY,
                         product_name VARCHAR(50),
                         product_price DECIMAL,
                         created_at DATE DEFAULT now()
);

INSERT INTO products (product_name, product_price)
VALUES
    ('tostadora', 12.99),
    ('auriculares', 10),
    ('nevera', 450.50),
    ('ordenador gaming', 899.99),
    ('teclado', 20),
    ('raton', 12.99),
    ('iphone', 1200),
    ('impresora', 99.99),
    ('ventilador', 9.99);
package io.github.emanuelmcp.productos.database.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Product implements Serializable {

    public Product(long id, String name, Double price, Date createAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createAt = createAt;
    }

    private long id;
    private String name;
    private Double price;
    private Date createAt;
    @Value("${server.port}")
    private Integer port;
}

package io.github.emanuelmcp.productos.database.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Product implements Serializable {
    private long id;
    private String name;
    private Double price;
    private Date createAt;
}

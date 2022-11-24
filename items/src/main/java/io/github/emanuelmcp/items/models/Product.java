package io.github.emanuelmcp.items.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Product {
    private long id;
    private String name;
    private Double price;
    private Date createAt;
}

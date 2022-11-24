package io.github.emanuelmcp.items.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    Product product;
    private Integer quantity;

    public Double getPVP(){
        return product.getPrice() * quantity.doubleValue();
    }
}

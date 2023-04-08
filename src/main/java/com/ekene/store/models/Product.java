package com.ekene.store.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class Product {
    private int productId;
    private String productName;
    private BigDecimal price;
    private int quantity;
}

package com.urugondavishnu.store.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    @JsonProperty("category_id")
    private Byte categoryId;

}

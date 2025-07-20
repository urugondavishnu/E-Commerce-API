package com.urugondavishnu.store.dtos;

import lombok.Data;
import lombok.NonNull;

@Data
public class AddItemToCartRequest {
    @NonNull
    private Long productId;
}

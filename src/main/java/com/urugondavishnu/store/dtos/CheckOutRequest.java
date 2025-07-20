package com.urugondavishnu.store.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CheckOutRequest {
    @NotNull(message = "cartId id required")
    private UUID cartId;
}

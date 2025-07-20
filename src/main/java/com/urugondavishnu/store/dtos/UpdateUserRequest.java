package com.urugondavishnu.store.dtos;

import lombok.Data;

@Data
public class UpdateUserRequest {
//    id is already requested in the endpoint.
    public String name;
    public String email;
}

package com.bfsi.userservice.dto;

import com.bfsi.userservice.entity.UserRole;
import com.bfsi.userservice.util.Transformer;
import lombok.Data;

@Data
public class UserRequest implements Transformer {

    private String name;

    private Long contactNo;

    private String email;

    private UserRole userRole;

}

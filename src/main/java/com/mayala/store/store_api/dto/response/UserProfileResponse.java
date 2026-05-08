package com.mayala.store.store_api.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileResponse {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String address;
    private String birthdate;

}

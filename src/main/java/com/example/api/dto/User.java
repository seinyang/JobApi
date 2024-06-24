package com.example.api.dto;

import lombok.Data;

@Data
public class User {

    public String id;
    public String password;
    public String name;
    public String email;
    public boolean sns;

}

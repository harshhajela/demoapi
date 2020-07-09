package com.example.demoapi.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SavePlayerDTO implements Serializable {

    private String username;

    private String password;
}

package com.example.demoapi.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class PlayerDTO {

    private Long playerId;

    private String username;

    private Double realMoney;
    private Double bonusMoney;

    private OffsetDateTime registrationTimestamp;
}

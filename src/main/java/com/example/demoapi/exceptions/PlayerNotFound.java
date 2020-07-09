package com.example.demoapi.exceptions;

import java.util.function.Supplier;

public class PlayerNotFound extends RuntimeException implements Supplier<PlayerNotFound>  {

    public PlayerNotFound(Long playerId) {
        super(playerId.toString());
    }

    @Override
    public PlayerNotFound get() {
        return null;
    }
}

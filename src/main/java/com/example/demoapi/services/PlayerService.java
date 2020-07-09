package com.example.demoapi.services;

import com.example.demoapi.dto.PlayerDTO;
import com.example.demoapi.models.Player;

import java.util.Optional;

public interface PlayerService {

    Optional<Player> findPlayerById(Long id);

    void save(Player player);
}

package com.example.demoapi.services;

import com.example.demoapi.models.Player;
import com.example.demoapi.repositories.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PlayerServiceImpl implements PlayerService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PlayerServiceImpl.class);
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Optional<Player> findPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public void save(Player player) {
        Player savePlayer = playerRepository.save(player);
        log.info(savePlayer.toString());
    }
}

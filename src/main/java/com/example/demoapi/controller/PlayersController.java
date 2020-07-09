package com.example.demoapi.controller;

import com.example.demoapi.dto.PlayerDTO;
import com.example.demoapi.dto.SavePlayerDTO;
import com.example.demoapi.exceptions.PlayerNotFound;
import com.example.demoapi.mapper.PlayerMapper;
import com.example.demoapi.services.PlayerService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/player",
consumes = {MediaType.APPLICATION_JSON_VALUE},
produces = {MediaType.APPLICATION_JSON_VALUE})
public class PlayersController {

    private final PlayerService playerService;
    private final PlayerMapper playerMapper;

    public PlayersController(PlayerService playerService, PlayerMapper playerMapper) {
        this.playerService = playerService;
        this.playerMapper = playerMapper;
    }

    @GetMapping("/{playerId}")
    public PlayerDTO getPlayer(@PathVariable Long playerId) {
        return playerService.findPlayerById(playerId)
                .map(player -> playerMapper.playerToPlayerDTO(player))
                .orElseThrow(new PlayerNotFound(playerId));
    }

    @PostMapping
    public ResponseEntity savePlayer(@RequestBody SavePlayerDTO savePlayerDTO) {
        playerService.save(playerMapper.savePlayerDtoToPlayer(savePlayerDTO));
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

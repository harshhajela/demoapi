package com.example.demoapi.mapper;

import com.example.demoapi.dto.PlayerDTO;
import com.example.demoapi.dto.SavePlayerDTO;
import com.example.demoapi.models.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = DateMapper.class)
public interface PlayerMapper {

    PlayerDTO playerToPlayerDTO(Player player);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    Player savePlayerDtoToPlayer(SavePlayerDTO savePlayerDTO);
}

package com.pokemon.tradecardgame.utils;

import com.pokemon.tradecardgame.entities.UserEntity;
import com.pokemon.tradecardgame.pojo.User;
import org.modelmapper.ModelMapper;

public class Converter {
    private static ModelMapper modelMapper = new ModelMapper();

    public static User convertUserEntityToUser(UserEntity entity) {
        return entity == null ? null : modelMapper.map(entity, User.class);
    }

    public static UserEntity convertUserToUserEntity(User dto) {
        return dto == null ? null : modelMapper.map(dto, UserEntity.class);
    }


}

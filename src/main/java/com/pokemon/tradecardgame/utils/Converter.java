package com.pokemon.tradecardgame.utils;

import com.pokemon.tradecardgame.entities.UserEntity;
import com.pokemon.tradecardgame.pojo.User;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    private static ModelMapper modelMapper = new ModelMapper();

    public static List<User> convertUserEntityToUser(List<UserEntity> entityList) {
        return entityList.stream().map(entity -> convertUserEntityToUser(entity)).collect(Collectors.toList());
    }

    public static User convertUserEntityToUser(UserEntity entity) {
        return entity == null ? null : modelMapper.map(entity, User.class);
    }

    public static List<UserEntity> convertUserToUserEntity(List<User> dtoList) {
        return dtoList.stream().map(dto -> convertUserToUserEntity(dto)).collect(Collectors.toList());
    }

    public static UserEntity convertUserToUserEntity(User dto) {
        return dto == null ? null : modelMapper.map(dto, UserEntity.class);
    }


}

package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.entities.UserEntity;
import com.pokemon.tradecardgame.exceptions.PokemonTradeCardGameException;
import com.pokemon.tradecardgame.pojo.User;
import com.pokemon.tradecardgame.repositories.UserRepository;
import com.pokemon.tradecardgame.utils.Crypto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.pokemon.tradecardgame.enums.MessageErrorEnum.NOT_FOUND;
import static com.pokemon.tradecardgame.utils.Converter.convertUserEntityToUser;
import static com.pokemon.tradecardgame.utils.Converter.convertUserToUserEntity;

@Service
@Log4j2
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }
    public UserEntity edit(User user) {
        UserEntity userEntityEdit = convertUserToUserEntity(user);
        try {

            if (!hasExist(user)){
                throw new PokemonTradeCardGameException(NOT_FOUND, user.getId());
            }

            LocalDateTime dateCreated = findById(user.getId()).getDateCreated();
            userEntityEdit.setDateCreated(dateCreated);
            userEntityEdit = userRepository.save(userEntityEdit);
        } catch (PokemonTradeCardGameException e) {
            throw new RuntimeException(e);
        }
        return userEntityEdit;
    }

    public List<UserEntity> listUser() {
        return (List<UserEntity>) userRepository.findAll();
    }

    public UserEntity findById(UUID uuid){
        Optional<UserEntity> userEntityOptional = userRepository.findById(uuid);
        return userEntityOptional.orElse(null);
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findUserEntityByEmail(email);
    }

    public UserEntity findByLogin(String login) {
        return userRepository.findUserEntityByLogin(login);
    }

    public void delete(UUID id) {
        try {
            if (!hasExist(id)) {
                throw new PokemonTradeCardGameException(NOT_FOUND, id);
            }
            userRepository.deleteById(id);
        } catch (PokemonTradeCardGameException e) {
            throw new RuntimeException(e);
        }
    }

    public String doLogin(User user) {
        UserEntity userDB = this.findByEmail(user.getEmail());
        String passwordSend = Crypto.encode(user.getPassword());

        if (passwordSend.equals(userDB.getPassword())) {

        }

        return "asjdlka";
    }

    private boolean hasExist(UUID id) {
        return userRepository.existsById(id);
    }

    private boolean hasExist(User user) {
        return hasExist(user.getId());
    }
    private void recordHistoric(User user){

    }



}

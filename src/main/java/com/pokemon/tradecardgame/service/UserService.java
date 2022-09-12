package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.entities.UserEntity;
import com.pokemon.tradecardgame.pojo.User;
import com.pokemon.tradecardgame.repositories.UserRepository;

import com.pokemon.tradecardgame.utils.Crypto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    public List<UserEntity> listUser() {
        return (List<UserEntity>) userRepository.findAll();
    }

    public UserEntity findById(UUID uuid){
        Optional<UserEntity> userEntityOptional = userRepository.findById(uuid);
        return userEntityOptional.orElse(null);
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public String doLogin(User user) {
        UserEntity userDB = this.findByEmail(user.getEmail());
        String passwordSend = Crypto.encode(user.getPassword());

        if (passwordSend.equals(userDB.getPassword())) {

        }

        return "asjdlka";
    }

    private void recordHistoric(User user){

    }
}

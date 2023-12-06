package com.pokemon.tradecardgame.controller;

import com.pokemon.tradecardgame.entities.UserEntity;
import com.pokemon.tradecardgame.pojo.User;
import com.pokemon.tradecardgame.service.UserService;
import com.pokemon.tradecardgame.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.UUID;



@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity<User> save(@RequestBody User data,  HttpServletRequest request) {
        UserEntity user = Converter.convertTo(data, UserEntity.class);
        user = userService.save(user);

        URI location = URI.create(String.format("%s/%s", request.getRequestURL(), user.getId()));
        return user != null ?
                ResponseEntity.created(location).build() :
                ResponseEntity.internalServerError().body(null);
    }

    @GetMapping(value = "/{uuid}", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ResponseEntity<User> findById(@PathVariable(name = "uuid") UUID uuid) {
        UserEntity userEntity = userService.findById(uuid);
        return ResponseEntity.ok(Converter.convertTo(userEntity, User.class));
    }

//
//    @GetMapping(path = "/{email}", produces = {"application/json;charset=utf-8"})
//    @ResponseBody
//    public ResponseEntity<User> findUserByEmail(@PathVariable(name = "email") String email) {
//        UserEntity userEntity = userService.findByEmail(email);
//        return ResponseEntity.ok(convertToDto(userEntity));
//    }




}

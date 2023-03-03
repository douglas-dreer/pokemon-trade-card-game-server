package com.pokemon.tradecardgame.controller;

import com.pokemon.tradecardgame.entities.UserEntity;
import com.pokemon.tradecardgame.pojo.User;
import com.pokemon.tradecardgame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import java.util.UUID;

import static com.pokemon.tradecardgame.utils.Converter.convertUserEntityToUser;
import static com.pokemon.tradecardgame.utils.Converter.convertUserToUserEntity;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<User>> list() {
        List<User> userList = convertUserEntityToUser(userService.listUser());
        return ResponseEntity.ok(userList);
    }

    @PostMapping(produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity<User> save(@RequestBody User data,  HttpServletRequest request) {
        UserEntity user = convertUserToUserEntity(data);
        user = userService.save(user);

        URI location = URI.create(String.format("%s/%s", request.getRequestURL(), user.getId()));
        return user != null ?
                ResponseEntity.created(location).build() :
                ResponseEntity.internalServerError().body(null);
    }

    @GetMapping(path = "/{id}", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ResponseEntity<User> findById(@PathVariable("id") UUID id) {
        ResponseEntity responseEntity = null;
        UserEntity userEntity = userService.findById(id);
        return ResponseEntity.ok(convertUserEntityToUser(userEntity));
    }

    @GetMapping(path = "/{email}/email", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ResponseEntity<User> findUserByEmail(@PathVariable("email") String email) {
        UserEntity userEntity = userService.findByEmail(email);
        return ResponseEntity.ok(convertUserEntityToUser(userEntity));
    }

    @GetMapping(path = "/{login}/login", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ResponseEntity<User> findByLogin(@PathVariable("login") String login) {
        UserEntity userEntity = userService.findByLogin(login);
        return ResponseEntity.ok(convertUserEntityToUser(userEntity));
    }

    @PutMapping(produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ResponseEntity<User> edit(@RequestBody User user) {
        User userEdited = convertUserEntityToUser(userService.edit(user));
        return ResponseEntity.ok(userEdited);
    }

    @DeleteMapping(path = "/{id}", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public void delete(@PathVariable("id") UUID id) {
        userService.delete(id);
    }
}

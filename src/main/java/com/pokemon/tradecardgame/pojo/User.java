package com.pokemon.tradecardgame.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private UUID id;
    private String name;
    private String login;
    private String password;
    private String email;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
    private Boolean status;
}

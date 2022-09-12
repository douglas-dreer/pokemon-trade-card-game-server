package com.pokemon.tradecardgame.entities;

import com.pokemon.tradecardgame.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "login_historic")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginHistoricEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;


    @Transient
    private User user;
    private String ipHost;
    private Date loginEntryDate;
    private Date expireDate;
    private boolean status;
}

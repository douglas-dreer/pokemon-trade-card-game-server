package com.pokemon.tradecardgame.entities;

import com.pokemon.tradecardgame.utils.Crypto;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String name;
    @Column(unique = true, nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
    private Boolean status;


    @PrePersist
    public void prePersist() {
        this.dateCreated = LocalDateTime.now();
        this.password = Crypto.encode(this.password);
        this.status = true;
    }

    @PostUpdate
    public void postUpdate() {
        this.dateModified = LocalDateTime.now();
    }
}

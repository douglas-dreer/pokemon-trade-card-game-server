package com.pokemon.tradecardgame.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "image")
public class ImagesEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "image_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "symbol", nullable = false)
    private String symbol;

    @Column(name = "logo", nullable = false)
    private String logo;
}

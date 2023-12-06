package com.pokemon.tradecardgame.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "sets")
@Entity
public class SetsEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "set_id", updatable = false, nullable = false)
    private UUID id;

    private String code;
    private String name;
    private String series;
    private int printedTotal;
    private int total;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "legality_fk", referencedColumnName = "legality_id")
    private LegalitiesEntity legalities;

    private String ptcgoCode;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_fk", referencedColumnName = "image_id")
    private ImagesEntity images;

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = LocalDateTime.parse(updatedAt, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }

    @JsonProperty("releaseDate")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}

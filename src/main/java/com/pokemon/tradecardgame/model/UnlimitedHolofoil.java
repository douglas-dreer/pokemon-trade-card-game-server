package com.pokemon.tradecardgame.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnlimitedHolofoil {
    public double low;
    public double mid;
    public double high;
    public double market;
    public double directLow;
}

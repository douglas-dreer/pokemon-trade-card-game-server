package com.pokemon.tradecardgame.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Prices {
    public Holofoil holofoil;
    public ReverseHolofoil reverseHolofoil;
    public Normal normal;
    @JsonProperty("1stEditionHolofoil")
    public _1stEditionHolofoil _1stEditionHolofoil;
    public UnlimitedHolofoil unlimitedHolofoil;
    public double averageSellPrice;
    public double lowPrice;
    public double trendPrice;
    public double reverseHoloLow;
    public double reverseHoloTrend;
    public double lowPriceExPlus;
    public double avg1;
    public double avg7;
    public double avg30;
    public double reverseHoloAvg1;
    public double reverseHoloAvg7;
    public double reverseHoloAvg30;
    public double reverseHoloSell;
}

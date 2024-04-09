package com.example.cryptonotificationapp.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double btcPrice;
    private double intraDayHigh;
    private double tradeVolume;
    private double marketCap;

    public Notification(Long id, double btcPrice, double intraDayHigh, double tradeVolume, double marketCap) {
        this.id = id;
        this.btcPrice = btcPrice;
        this.intraDayHigh = intraDayHigh;
        this.tradeVolume = tradeVolume;
        this.marketCap = marketCap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBtcPrice() {
        return btcPrice;
    }

    public void setBtcPrice(double btcPrice) {
        this.btcPrice = btcPrice;
    }

    public double getIntraDayHigh() {
        return intraDayHigh;
    }

    public void setIntraDayHigh(double intraDayHigh) {
        this.intraDayHigh = intraDayHigh;
    }

    public double getTradeVolume() {
        return tradeVolume;
    }

    public void setTradeVolume(double tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }
}

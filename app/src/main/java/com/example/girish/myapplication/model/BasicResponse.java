package com.example.girish.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasicResponse {

    @Expose
    @SerializedName("all_rounder")
    String allRounder;

    @Expose
    @SerializedName("best_batsman")
    String bestBatsman;

    @Expose
    @SerializedName("best_bowler")
    String bestBowler;

    @Expose
    @SerializedName("winner")
    String winner;


    public String getAllRounder() {
        return allRounder;
    }

    public void setAllRounder(String allRounder) {
        this.allRounder = allRounder;
    }

    public String getBestBatsman() {
        return bestBatsman;
    }

    public void setBestBatsman(String bestBatsman) {
        this.bestBatsman = bestBatsman;
    }

    public String getBestBowler() {
        return bestBowler;
    }

    public void setBestBowler(String bestBowler) {
        this.bestBowler = bestBowler;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}

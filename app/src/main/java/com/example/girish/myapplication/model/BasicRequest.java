package com.example.girish.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasicRequest {

    @Expose
    @SerializedName("A")
    private String teamA;

    @Expose
    @SerializedName("B")
    private String teamB;

    @Expose
    @SerializedName("C")
    private String teamToss;

    @Expose
    @SerializedName("D")
    private String teamBatFirst;

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public String getTeamToss() {
        return teamToss;
    }

    public void setTeamToss(String teamToss) {
        this.teamToss = teamToss;
    }

    public String getTeamBatFirst() {
        return teamBatFirst;
    }

    public void setTeamBatFirst(String teamBatFirst) {
        this.teamBatFirst = teamBatFirst;
    }
}

package com.xworkz.servlet.dto;

public class CricketTournamentDto {
    private String teamName;
    private String captainName;
    private String contactNumber;
    private String email;
    private int numPlayers;
    private String coachName;
    private String homeGround;
    private String sponsorsName;

    public CricketTournamentDto(String teamName, String captainName, String contactNumber, String email, int numPlayers, String coachName, String homeGround, String sponsorsName) {
        this.teamName = teamName;
        this.captainName = captainName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.numPlayers = numPlayers;
        this.coachName = coachName;
        this.homeGround = homeGround;
        this.sponsorsName = sponsorsName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getHomeGround() {
        return homeGround;
    }

    public void setHomeGround(String homeGround) {
        this.homeGround = homeGround;
    }

    public String getSponsorsName() {
        return sponsorsName;
    }

    public void setSponsorsName(String sponsorsName) {
        this.sponsorsName = sponsorsName;
    }

    @Override
    public String toString() {
        return "CricketTournamentDto{" +
                "teamName='" + teamName + '\'' +
                ", captainName='" + captainName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", numPlayers=" + numPlayers +
                ", coachName='" + coachName + '\'' +
                ", homeGround='" + homeGround + '\'' +
                ", sponsorsName='" + sponsorsName + '\'' +
                '}';
    }
}

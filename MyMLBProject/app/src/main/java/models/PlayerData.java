package models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Avinash Dodda on 8/18/15.
 */

public class PlayerData implements Serializable{

    @SerializedName("pid")
    private int playerId;
    @SerializedName("fn")
    private String firstName;
    @SerializedName("ln")
    private String lastName;
    @SerializedName("pn")
    private String position;
    @SerializedName("tid")
    private int teamId;
    @SerializedName("htid")
    private int homeTeamId;
    @SerializedName("atid")
    private int awayTeamId;
    @SerializedName("htabbr")
    private String homeTeamAbbrevation;
    @SerializedName("atabbr")
    private String awayTeamAbbrevation;
    @SerializedName("s")
    private int salary;
    @SerializedName("i")
    private String injuryStatus;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getHomeTeamAbbrevation() {
        return homeTeamAbbrevation;
    }

    public void setHomeTeamAbbrevation(String homeTeamAbbrevation) {
        this.homeTeamAbbrevation = homeTeamAbbrevation;
    }

    public String getAwayTeamAbbrevation() {
        return awayTeamAbbrevation;
    }

    public void setAwayTeamAbbrevation(String awayTeamAbbrevation) {
        this.awayTeamAbbrevation = awayTeamAbbrevation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getInjuryStatus() {
        return injuryStatus;
    }

    public void setInjuryStatus(String injuryStatus) {
        this.injuryStatus = injuryStatus;
    }

    /*Comparator for sorting the list by roll no*/
    public static Comparator<PlayerData> playerSalary = new Comparator<PlayerData>() {

        public int compare(PlayerData p1, PlayerData p2) {

            int salary1 = p1.getSalary();
            int salary2 = p2.getSalary();

	        /*For descending order*/
            return salary2-salary1;

        }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<PlayerData> playerName = new Comparator<PlayerData>() {

        public int compare(PlayerData p1, PlayerData p2) {

            String name1 = p1.getFirstName();
            String name2 = p2.getFirstName();

	        /*For descending order*/
            return name2.compareTo(name1);

        }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<PlayerData> playerPosition = new Comparator<PlayerData>() {

        public int compare(PlayerData p1, PlayerData p2) {

            String position1 = p1.getPosition();
            String position2 = p2.getPosition();

	        /*For descending order*/
            return position2.compareTo(position1);

        }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<PlayerData> playerInjury = new Comparator<PlayerData>() {

        public int compare(PlayerData p1, PlayerData p2) {

            String injury1 = p1.getInjuryStatus();
            String injury2 = p2.getInjuryStatus();

	        /*For descending order*/
            return injury2.compareTo(injury1);

        }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<PlayerData> reversePlayerSalary = new Comparator<PlayerData>() {

        public int compare(PlayerData p1, PlayerData p2) {

            int salary1 = p1.getSalary();
            int salary2 = p2.getSalary();

	        /*For descending order*/
            return salary1-salary2;

        }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<PlayerData> reversePlayerName = new Comparator<PlayerData>() {

        public int compare(PlayerData p1, PlayerData p2) {

            String name1 = p1.getFirstName();
            String name2 = p2.getFirstName();

	        /*For descending order*/
            return name1.compareTo(name2);

        }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<PlayerData> reversePlayerPosition = new Comparator<PlayerData>() {

        public int compare(PlayerData p1, PlayerData p2) {

            String position1 = p1.getPosition();
            String position2 = p2.getPosition();

	        /*For descending order*/
            return position1.compareTo(position2);

        }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<PlayerData> reversePlayerInjury = new Comparator<PlayerData>() {

        public int compare(PlayerData p1, PlayerData p2) {

            String injury1 = p1.getInjuryStatus();
            String injury2 = p2.getInjuryStatus();

	        /*For descending order*/
            return injury1.compareTo(injury2);

        }};
}

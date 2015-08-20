package models;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Avinash Dodda on 8/18/15.
 */

public class TeamData {

    private int teamId;
    private String teamAbbrevation;

    public TeamData(int teamId, List<PlayerData> playerList) {
        this.teamId = teamId;
        this.playerList = playerList;
    }

    private List<PlayerData> playerList;
    private int numPlayers;
    private int totalSalary;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamAbbrevation() {
        return teamAbbrevation;
    }

    public void setTeamAbbrevation(String teamAbbrevation) {
        this.teamAbbrevation = teamAbbrevation;
    }

    public List<PlayerData> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<PlayerData> playerList) {
        this.playerList = playerList;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(int totalSalary) {
        this.totalSalary = totalSalary;
    }

    /*Comparator for sorting the list by roll no*/
    public static Comparator<TeamData> teamSalary = new Comparator<TeamData>() {

        public int compare(TeamData t1, TeamData t2) {

            int salary1 = t1.getTotalSalary();
            int salary2 = t2.getTotalSalary();

	        /*For descending order*/
            return salary2-salary1;

        }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<TeamData> reverseTeamSalary = new Comparator<TeamData>() {

        public int compare(TeamData t1, TeamData t2) {

            int salary1 = t1.getTotalSalary();
            int salary2 = t2.getTotalSalary();

	        /*For descending order*/
            return salary1-salary2;

        }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<TeamData> teamName = new Comparator<TeamData>() {

        public int compare(TeamData t1, TeamData t2) {

            String abbr1 = t1.getTeamAbbrevation();
            String abbr2 = t2.getTeamAbbrevation();

	        /*For descending order*/
            return abbr2.compareTo(abbr1);

        }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<TeamData> reverseTeamName = new Comparator<TeamData>() {

        public int compare(TeamData t1, TeamData t2) {

            String abbr1 = t1.getTeamAbbrevation();
            String abbr2 = t2.getTeamAbbrevation();

	        /*For descending order*/
            return abbr1.compareTo(abbr2);

        }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<TeamData> teamPlayers = new Comparator<TeamData>() {

        public int compare(TeamData t1, TeamData t2) {

            int players1 = t1.getNumPlayers();
            int players2 = t2.getNumPlayers();

	        /*For descending order*/
            return players2-players1;

        }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<TeamData> reverseTeamPlayers = new Comparator<TeamData>() {

        public int compare(TeamData t1, TeamData t2) {

            int players1 = t1.getNumPlayers();
            int players2 = t2.getNumPlayers();

	        /*For descending order*/
            return players1-players2;

        }};
}

package models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Avinash Dodda on 8/18/15.
 */

public class PlayerList implements Serializable {

    private List<PlayerData> playerList;

    public List<PlayerData> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<PlayerData> playerList) {
        this.playerList = playerList;
    }
}

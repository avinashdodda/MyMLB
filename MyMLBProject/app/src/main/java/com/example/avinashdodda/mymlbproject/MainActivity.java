package com.example.avinashdodda.mymlbproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import adapters.TeamListAdapter;
import models.PlayerData;
import models.PlayerList;
import models.TeamData;

/**
 * Created by Avinash Dodda on 8/18/15.
 */

public class MainActivity extends Activity implements View.OnClickListener{

    private enum SortStateName { DESCENDING, ASCENDING};
    private enum SortStatePlayers { DESCENDING, ASCENDING};
    private enum SortStateSalary { DESCENDING, ASCENDING};

    private RecyclerView mRecyclerView;
    private TeamListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<TeamData> teams;
    SortStateName sortStateName = SortStateName.ASCENDING;
    SortStatePlayers sortStatePlayers = SortStatePlayers.ASCENDING;
    SortStateSalary sortStateSalary = SortStateSalary.ASCENDING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setTitle("Teams");
        mRecyclerView = (RecyclerView) findViewById(R.id.team_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        teams = getTeamDataFromPlayers();
        Collections.sort(teams,TeamData.teamSalary);
        mAdapter = new TeamListAdapter(teams);
        mAdapter.setOnClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sort_name) {
            if(sortStateName == SortStateName.ASCENDING){
                Toast.makeText(this, "Sorting by Name Ascending", Toast.LENGTH_SHORT).show();
                Collections.sort(teams,TeamData.reverseTeamName);
                mAdapter.notifyDataSetChanged();
                sortStateName = SortStateName.DESCENDING;
            }else{
                Toast.makeText(this, "Sorting by Name Descending", Toast.LENGTH_SHORT).show();
                Collections.sort(teams,TeamData.teamName);
                mAdapter.notifyDataSetChanged();
                sortStateName = SortStateName.ASCENDING;
            }
            return true;
        }
        if (id == R.id.action_sort_by_players) {
            Toast.makeText(this, "Sorting by Players Ascending", Toast.LENGTH_SHORT).show();
            if(sortStatePlayers == SortStatePlayers.ASCENDING){
                Collections.sort(teams,TeamData.teamPlayers);
                mAdapter.notifyDataSetChanged();
                sortStatePlayers = SortStatePlayers.DESCENDING;
            }else{
                Toast.makeText(this, "Sorting by Players Descending", Toast.LENGTH_SHORT).show();
                Collections.sort(teams,TeamData.reverseTeamPlayers);
                mAdapter.notifyDataSetChanged();
                sortStatePlayers = SortStatePlayers.ASCENDING;
            }
            return true;
        }
        if (id == R.id.action_sort_salary) {
            if(sortStateSalary == SortStateSalary.ASCENDING){
                Toast.makeText(this, "Sorting by Salary Ascending", Toast.LENGTH_SHORT).show();
                Collections.sort(teams,TeamData.reverseTeamSalary);
                mAdapter.notifyDataSetChanged();
                sortStateSalary = SortStateSalary.DESCENDING;
            }else{
                Toast.makeText(this, "Sorting by Salary Descending", Toast.LENGTH_SHORT).show();
                Collections.sort(teams,TeamData.teamSalary);
                mAdapter.notifyDataSetChanged();
                sortStateSalary = sortStateSalary.ASCENDING;
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // helper method to load json from asset
    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("playerData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private PlayerList getPlayerDateFromJSON() {
        Gson gson = new Gson();
        return gson.fromJson(loadJSONFromAsset(), PlayerList.class);
    }

    private List<TeamData> getTeamDataFromPlayers() {
        PlayerList playerList = getPlayerDateFromJSON();
        HashMap<Integer, List<PlayerData>> teamList = new HashMap<Integer, List<PlayerData>>();
        for(PlayerData player : playerList.getPlayerList()) {
            int teamId = player.getTeamId();
            if(teamList.containsKey(teamId)){
                teamList.get(teamId).add(player);
            } else {
                List<PlayerData> players = new ArrayList<PlayerData>();
                players.add(player);
                teamList.put(teamId, players);
            }
        }

        List<TeamData> teams = new ArrayList<TeamData>();
        for(Integer teamId : teamList.keySet()) {
            TeamData teamData = new TeamData(teamId, teamList.get(teamId));
            List<PlayerData> players = teamList.get(teamId);
            teamData.setTeamAbbrevation(players.get(0).getHomeTeamAbbrevation());
            teamData.setNumPlayers(players.size());
            int salary = 0;
            for(PlayerData player : players) {
                salary += player.getSalary();
            }
            teamData.setTotalSalary(salary);
            teams.add(teamData);
        }
        return teams;
    }

    @Override
    public void onClick(View view) {
        Object tag = view.getTag();
        Intent intent = new Intent(this, PlayerActivity.class);
        List<PlayerData> players = ((List<PlayerData>) tag);

        // Create a Bundle and Put Bundle in to it
        Bundle bundleObject = new Bundle();
        bundleObject.putSerializable("playerData", (Serializable) players);

        // Put Bundle in to Intent and call start Activity
        intent.putExtras(bundleObject);

        startActivity(intent);
    }
}

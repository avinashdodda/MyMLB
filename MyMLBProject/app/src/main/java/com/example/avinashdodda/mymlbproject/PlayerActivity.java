package com.example.avinashdodda.mymlbproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import adapters.PlayerListAdapter;
import models.PlayerData;
import models.TeamData;

/**
 * Created by Avinash Dodda on 8/18/15.
 */

public class PlayerActivity extends Activity {

    private enum SortStateName { DESCENDING, ASCENDING};
    private enum SortStatePosition { DESCENDING, ASCENDING};
    private enum SortStateSalary { DESCENDING, ASCENDING};
    private enum SortStateInjury { DESCENDING, ASCENDING};

    private RecyclerView mRecyclerView;
    private PlayerListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<PlayerData> players;
    SortStateName sortStateName = SortStateName.ASCENDING;
    SortStatePosition sortStatePosition = SortStatePosition.ASCENDING;
    SortStateSalary sortStateSalary = SortStateSalary.ASCENDING;
    SortStateInjury sortStateInjury = SortStateInjury.ASCENDING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        getActionBar().setTitle("Players");

        try{
            // Get the Bundle Object
            Bundle bundleObject = getIntent().getExtras();

            // Get ArrayList Bundle
            players = (List<PlayerData>) bundleObject.getSerializable("playerData");
        }
        catch(Exception e){
            e.printStackTrace();
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.player_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Collections.sort(players, PlayerData.playerSalary);
        // specify an adapter (see also next example)
        mAdapter = new PlayerListAdapter(players);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player, menu);
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
                Collections.sort(players, PlayerData.reversePlayerName);
                mAdapter.notifyDataSetChanged();
                sortStateName = SortStateName.DESCENDING;
            }else{
                Toast.makeText(this, "Sorting by Name Descending", Toast.LENGTH_SHORT).show();
                Collections.sort(players, PlayerData.playerName);
                mAdapter.notifyDataSetChanged();
                sortStateName = SortStateName.ASCENDING;
            }
            return true;
        }
        if (id == R.id.action_sort_by_position) {

            if(sortStatePosition == SortStatePosition.ASCENDING){
                Toast.makeText(this, "Sorting by Position Ascending", Toast.LENGTH_SHORT).show();
                Collections.sort(players,PlayerData.reversePlayerPosition);
                mAdapter.notifyDataSetChanged();
                sortStateSalary = SortStateSalary.DESCENDING;
            }else{
                Toast.makeText(this, "Sorting by Position Descending", Toast.LENGTH_SHORT).show();
                Collections.sort(players,PlayerData.playerPosition);
                mAdapter.notifyDataSetChanged();
                sortStateSalary = sortStateSalary.ASCENDING;
            }
            return true;
        }
        if (id == R.id.action_sort_salary) {
            if(sortStateSalary == SortStateSalary.ASCENDING){
                Toast.makeText(this, "Sorting by Salary Ascending", Toast.LENGTH_SHORT).show();
                Collections.sort(players,PlayerData.reversePlayerSalary);
                mAdapter.notifyDataSetChanged();
                sortStateSalary = SortStateSalary.DESCENDING;
            }else{
                Toast.makeText(this, "Sorting by Salary Descending", Toast.LENGTH_SHORT).show();
                Collections.sort(players,PlayerData.playerSalary);
                mAdapter.notifyDataSetChanged();
                sortStateSalary = sortStateSalary.ASCENDING;
            }
            return true;
        }
        if (id == R.id.action_sort_injury) {
            if(sortStateSalary == SortStateSalary.ASCENDING){
                Toast.makeText(this, "Sorting by Injury Ascending", Toast.LENGTH_SHORT).show();
                Collections.sort(players,PlayerData.reversePlayerInjury);
                mAdapter.notifyDataSetChanged();
                sortStateSalary = SortStateSalary.DESCENDING;
            }else{
                Toast.makeText(this, "Sorting by Injury Descending", Toast.LENGTH_SHORT).show();
                Collections.sort(players,PlayerData.playerInjury);
                mAdapter.notifyDataSetChanged();
                sortStateSalary = sortStateSalary.ASCENDING;
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package adapters;/**
 * Created by avinashdodda on 8/18/15.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.avinashdodda.mymlbproject.R;

import java.util.List;

import models.TeamData;

/**
 * Created by Avinash Dodda on 8/18/15.
 */

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.ViewHolder> {
    private List<TeamData> mDataset;
    private View.OnClickListener listener;

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public static class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView teamAbbreviation;
    public TextView numPlayers;
    public TextView totalSalary;

    public ViewHolder(View v) {
        super(v);
        teamAbbreviation = (TextView)v.findViewById(R.id.team_abbreviation_tv);
        numPlayers = (TextView)v.findViewById(R.id.num_players_tv);
        totalSalary = (TextView)v.findViewById(R.id.total_salary_tv);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TeamListAdapter(List<TeamData> myDataset) {
        mDataset = myDataset;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TeamListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_list_row, parent, false);

        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        vh.itemView.setOnClickListener(listener);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.teamAbbreviation.setText(mDataset.get(position).getTeamAbbrevation());
        holder.numPlayers.setText(String.valueOf(mDataset.get(position).getNumPlayers()));
        holder.totalSalary.setText(String.valueOf(mDataset.get(position).getTotalSalary()));
        holder.itemView.setTag(mDataset.get(position).getPlayerList());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
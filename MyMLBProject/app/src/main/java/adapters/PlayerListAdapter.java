package adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.avinashdodda.mymlbproject.R;

import java.util.List;

import models.PlayerData;

/**
 * Created by Avinash Dodda on 8/19/15.
 */

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.ViewHolder> {
    private List<PlayerData> mDataset;

    // Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView playerName;
        public TextView playerPosition;
        public TextView playerSalary;
        public TextView playerInjury;
        public LinearLayout injuryLayout;

        public ViewHolder(View v) {
            super(v);
            playerName = (TextView)v.findViewById(R.id.player_name_tv);
            playerPosition = (TextView)v.findViewById(R.id.player_position_tv);
            playerSalary = (TextView)v.findViewById(R.id.player_salary_tv);
            playerInjury = (TextView)v.findViewById(R.id.player_injury_tv);
            injuryLayout = (LinearLayout)v.findViewById(R.id.injury_layout);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PlayerListAdapter(List<PlayerData> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PlayerListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_list_row, parent, false);

        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.playerName.setText(mDataset.get(position).getFirstName() + " " + mDataset.get(position).getLastName());
        holder.playerPosition.setText(mDataset.get(position).getPosition());
        holder.playerSalary.setText(String.valueOf(mDataset.get(position).getSalary()));

        if(!mDataset.get(position).getInjuryStatus().isEmpty()){
            holder.injuryLayout.setVisibility(View.VISIBLE);
            holder.playerInjury.setText(mDataset.get(position).getInjuryStatus());
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
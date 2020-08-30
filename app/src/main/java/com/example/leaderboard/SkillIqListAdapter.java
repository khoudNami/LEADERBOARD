package com.example.leaderboard;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SkillIqListAdapter extends RecyclerView.Adapter<SkillIqListAdapter.SkillIqViewHolder>
{

    @NonNull
    @Override
    public SkillIqListAdapter.SkillIqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIqListAdapter.SkillIqViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SkillIqViewHolder extends RecyclerView.ViewHolder {
        public SkillIqViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

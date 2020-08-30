package com.example.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class SkillIqListAdapter extends RecyclerView.Adapter<SkillIqListAdapter.SkillIqViewHolder> {
    private LinkedList<Student> mStudentLinkedList;
    private LayoutInflater mLayoutInflater;

    public SkillIqListAdapter(Context context, LinkedList<Student> studentLinkedList) {
        mStudentLinkedList = studentLinkedList;
        mLayoutInflater =  LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SkillIqListAdapter.SkillIqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.learner_item,parent,false);
        return new SkillIqViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIqListAdapter.SkillIqViewHolder holder, int position) {
        Student currentStudent = mStudentLinkedList.get(position);
        holder.mTextName.setText(currentStudent.getName());
        holder.mTextDetails.setText(currentStudent.getScore()+" skill IQ Score, "+currentStudent.getCountry());
        //holder.mBadgeImageView.setImageResource();

    }

    @Override
    public int getItemCount() {
        return mStudentLinkedList.size();
    }

    public class SkillIqViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTextName;
        public final TextView mTextDetails;
        public final ImageView mBadgeImageView;

        public SkillIqViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextName = itemView.findViewById(R.id.text_name);
            mTextDetails = itemView.findViewById(R.id.text_details);
            mBadgeImageView = itemView.findViewById(R.id.badge_imageView);
        }
    }
}

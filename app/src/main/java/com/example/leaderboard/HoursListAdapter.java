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

public class HoursListAdapter extends RecyclerView.Adapter<HoursListAdapter.ViewHolder> {
    private LinkedList<Student> mStudentLinkedList;
    private LayoutInflater mLayoutInflater;

    public HoursListAdapter(Context context, LinkedList<Student> studentLinkedList) {
        mStudentLinkedList = studentLinkedList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.learner_item, parent, false);
        return new HoursListAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student currentStudent = mStudentLinkedList.get(position);
        holder.mTextName.setText(currentStudent.getName());
        holder.mTextDetails.setText(currentStudent.getHours() + " learning hours, " + currentStudent.getCountry());
        //holder.mBadgeImageView.setImageResource();
    }

    @Override
    public int getItemCount() {
        return mStudentLinkedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mTextName;
        public final TextView mTextDetails;
        public final ImageView mBadgeImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextName = itemView.findViewById(R.id.text_name);
            mTextDetails = itemView.findViewById(R.id.text_details);
            mBadgeImageView = itemView.findViewById(R.id.badge_imageView);
        }
    }
}

package com.example.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

public class ScoresListAdapter extends RecyclerView.Adapter<ScoresListAdapter.ViewHolder> {

    private List<Student> mStudentList;
    private LayoutInflater mLayoutInflater;
    Context mContext;

    public ScoresListAdapter(Context context, List<Student> studentList) {
        mStudentList = studentList;
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.learner_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student currentStudent = mStudentList.get(position);

        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.downloader(new OkHttp3Downloader(mContext));
        builder.build().load(currentStudent.getBadgeUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.mBadgeImageView);

        holder.mTextName.setText(currentStudent.getName());
        holder.mTextDetails.setText(currentStudent.getScore() + " skill IQ Score, " + currentStudent.getCountry());
        //holder.mBadgeImageView.setImageResource();

    }

    @Override
    public int getItemCount() {
        return mStudentList.size();
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

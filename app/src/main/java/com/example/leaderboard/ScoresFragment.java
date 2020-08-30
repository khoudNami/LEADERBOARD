package com.example.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ScoresFragment extends Fragment {

    private final LinkedList<Student> mStudentList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private ScoresListAdapter mScoresListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scores_tab, container, false);

        for (int i = 0; i < 19; i++) {
            mStudentList.addLast(new Student("John Doe", "MyCountry", i, "The Url"));
        }

        mRecyclerView = view.findViewById(R.id.recyclerView2);
        mScoresListAdapter = new ScoresListAdapter(view.getContext(), mStudentList);
        mRecyclerView.setAdapter(mScoresListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }
}
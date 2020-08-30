package com.example.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScoresFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ScoresListAdapter mScoresListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_scores_tab, container, false);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Student>> call = service.getAllStudentScores();
        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                mRecyclerView = view.findViewById(R.id.recyclerView2);
                mScoresListAdapter = new ScoresListAdapter(view.getContext(), response.body());
                mRecyclerView.setAdapter(mScoresListAdapter);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Toast.makeText(view.getContext(), "Something went wrong with getting the scores ", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
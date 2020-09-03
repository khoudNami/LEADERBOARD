package com.example.leaderboard;

import android.app.ProgressDialog;
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


public class HoursFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private HoursListAdapter mHoursListAdapter;
    private ProgressDialog mProgressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setMessage("Loading....");
        mProgressDialog.show();

        final View view = inflater.inflate(R.layout.fragment_hours_tab, container, false);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Student>> call = service.getAllStudentHours();

        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                mProgressDialog.dismiss();
                mRecyclerView = view.findViewById(R.id.recyclerView1);
                mHoursListAdapter = new HoursListAdapter(view.getContext(), response.body());
                mRecyclerView.setAdapter(mHoursListAdapter);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(view.getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
package com.example.leaderboard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/api/hours")
    Call <List<Student>> getAllStudentHours();

    @GET("/api/skilliq")
    Call <List<Student>> getAllStudentScores();
}



package com.example.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectSubmission extends AppCompatActivity {

    TextView txtName;
    TextView txtLastName;
    TextView txtEmailAddress;
    TextView txtProjectLink;
    TextView txtResults;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submisson);

        txtName = findViewById(R.id.editTextName);
        txtLastName = findViewById(R.id.editTextLastName);
        txtEmailAddress = findViewById(R.id.editTextEmailAddress);
        txtProjectLink = findViewById(R.id.editTextProjectLink);
        txtResults = findViewById(R.id.textViewResults);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final SendDataService service = RetrofitPostingClientInstance.getRetrofitInstance().create(SendDataService.class);


        Button submitProjectBtn = findViewById(R.id.submit_project_button);
        submitProjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mProgressDialog = new ProgressDialog(ProjectSubmission.this);
                mProgressDialog.setMessage("Loading....");
                mProgressDialog.show();

                String name = txtName.getText().toString();
                String lastName = txtLastName.getText().toString();
                String emailAddress = txtEmailAddress.getText().toString();
                String projectLink = txtProjectLink.getText().toString();


                service.submitProject(name, lastName, emailAddress, projectLink).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        mProgressDialog.dismiss();
                        String results = "Project submitted to API." + " Was it successful? " + response.isSuccessful()
                                + ". Status Code " + response.code()
                                + ". Message " + response.message();
                        txtResults.setText(results);

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        mProgressDialog.dismiss();
                        Toast.makeText(ProjectSubmission.this, "Unable to submit post to API.", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
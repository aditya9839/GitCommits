package com.example.gitcommits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.gitcommits.Adapter.RecyclerViewAdapter;
import com.example.gitcommits.pojo.Commit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public Endpoint endpoint;
    RecyclerView recyclerView;

    private List<Commit> list = new ArrayList<>();
    private RecyclerViewAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        mAdapter = new RecyclerViewAdapter(list);
        recyclerView.setAdapter(mAdapter);

        endpoint = RetrofitClientInstance.getRetrofitInstance().create(Endpoint.class);
        endpoint.getCommits("aditya9839", "GitCommits").enqueue(new Callback<List<Commit>>() {
            @Override
            public void onResponse(@NonNull Call<List<Commit>> call, @NonNull Response<List<Commit>> response) {
//                populateRecyclerView(response.body());
                assert response.body() != null;
                Log.d("Response", "onResponse: " +response.body().toString());
//                List<Commit> data = response.body();
//                String userName = data.get(0).getCommit().getMessage();
                populateRecyclerView(response.body()); //send data to recycler view
            }

            @Override
            public void onFailure(@NonNull Call<List<Commit>> call, @NonNull Throwable t) {

            }
        });
    }
    private void populateRecyclerView(List<Commit> response) {
        mAdapter.setData(response); //send to recycler view adapter
    }
}
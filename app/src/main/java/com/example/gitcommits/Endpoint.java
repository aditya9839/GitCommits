package com.example.gitcommits;


import com.example.gitcommits.pojo.Commit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Endpoint {

    //endpoint of commit messages
    @GET("repos/{owner}/{repo}/commits")
    Call<List<Commit>> getCommits(@Path("owner") String owner, @Path("repo") String repo);
}
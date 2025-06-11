package com.example.elections_results.api;

import com.example.elections_results.models.Candidate;
import com.example.elections_results.models.District;
import com.example.elections_results.models.ElectionResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ElectionApi {
    @GET("results/latest")
    Call<List<ElectionResult>> getLatestResults(
            @Header("Authorization") String authToken,
            @Query("districtId") String districtId,
            @Query("electionType") String electionType,
            @Query("round") int round);

    @GET("districts/{id}")
    Call<District> getDistrictDetails(
            @Header("Authorization") String authToken,
            @Path("id") String districtId);

    @GET("candidates/{id}")
    Call<Candidate> getCandidateDetails(
            @Header("Authorization") String authToken,
            @Path("id") String candidateId);

    @GET("results/history")
    Call<List<ElectionResult>> getHistoricalResults(
            @Header("Authorization") String authToken,
            @Query("districtId") String districtId,
            @Query("electionType") String electionType);
}
package com.example.elections_results.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.elections_results.api.ApiClient;
import com.example.elections_results.api.ElectionApi;
import com.example.elections_results.db.AppDatabase;
import com.example.elections_results.db.ElectionDao;
import com.example.elections_results.models.ElectionResult;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ElectionRepository {
    private final ElectionDao electionDao;
    private final ElectionApi electionApi;

    public ElectionRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        assert db != null;
        electionDao = db.electionDao();
        electionApi = ApiClient.getApiService();
    }

    public LiveData<List<ElectionResult>> getDistrictResults(String districtId, String electionType, int round) {
        refreshResults(districtId, electionType, round);
        return electionDao.getResultsByDistrict(districtId, electionType, round);
    }

    private void refreshResults(String districtId, String electionType, int round) {
        Executors.newSingleThreadExecutor().execute(() -> {
            electionApi.getLatestResults("API_KEY", districtId, electionType, round)
                    .enqueue(new Callback<List<ElectionResult>>() {
                        @Override
                        public void onResponse(Call<List<ElectionResult>> call, Response<List<ElectionResult>> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                new InsertAsyncTask(electionDao).execute(response.body().toArray(new ElectionResult[0]));
                            }
                        }

                        @Override
                        public void onFailure(Call<List<ElectionResult>> call, Throwable t) {
                            // Handle error
                        }
                    });
        });
    }

    private static class InsertAsyncTask extends AsyncTask<ElectionResult, Void, Void> {
        private ElectionDao asyncTaskDao;

        InsertAsyncTask(ElectionDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ElectionResult... params) {
            asyncTaskDao.insertResults(Arrays.asList(params));
            return null;
        }
    }
}

package com.example.elections_results.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elections_results.R;
import com.example.elections_results.adapters.ResultsAdapter;
import com.example.elections_results.viewmodels.ElectionViewModel;

public class DashboardFragment extends Fragment {
    private ElectionViewModel viewModel;
    private ResultsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.results_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ResultsAdapter();
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(ElectionViewModel.class);
        viewModel.getDistrictResults("NATIONAL", "legislative", 1).observe(getViewLifecycleOwner(), results -> {
            adapter.setResults(results);
        });
    }
}
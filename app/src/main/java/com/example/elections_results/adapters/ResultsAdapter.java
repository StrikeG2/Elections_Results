package com.example.elections_results.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elections_results.R;
import com.example.elections_results.models.ElectionResult;

import java.util.List;
import java.util.Locale;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ResultViewHolder> {
    private List<ElectionResult> results;

    public void setResults(List<ElectionResult> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_result, parent, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        ElectionResult result = results.get(position);
        holder.candidateName.setText(result.getCandidateName());
        holder.partyName.setText(result.getParty());
        holder.votePercentage.setText(String.format(Locale.getDefault(), "%.1f%%", result.getPercentage()));
    }

    @Override
    public int getItemCount() {
        return results != null ? results.size() : 0;
    }

    static class ResultViewHolder extends RecyclerView.ViewHolder {
        TextView candidateName;
        TextView partyName;
        TextView votePercentage;

        ResultViewHolder(View itemView) {
            super(itemView);
            candidateName = itemView.findViewById(R.id.candidate_name);
            partyName = itemView.findViewById(R.id.party_name);
            votePercentage = itemView.findViewById(R.id.vote_percentage);
        }
    }
}
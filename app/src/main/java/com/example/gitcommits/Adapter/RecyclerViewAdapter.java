package com.example.gitcommits.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gitcommits.pojo.Commit;
import com.example.gitcommits.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Commit> data;

    public RecyclerViewAdapter(List<Commit> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.userName.setText("User Name : " +data.get(position).getCommit().getAuthor().getName());
        holder.txtCommitId.setText("Commit ID : "+data.get(position).getSha());
        holder.txtCommitMessage.setText("Commit Message : "+ data.get(position).getCommit().getMessage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView userName;
        private TextView txtCommitId;
        private TextView txtCommitMessage;
        ViewHolder(View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.username);
            txtCommitId = itemView.findViewById(R.id.ssh);
            txtCommitMessage = itemView.findViewById(R.id.commit_message);
        }
    }

    public void setData(List<Commit> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
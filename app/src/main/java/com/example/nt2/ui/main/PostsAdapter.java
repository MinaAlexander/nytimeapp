package com.example.nt2.ui.main;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nt2.R;
import com.example.nt2.pojo.Results;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private List<Results> postList = new ArrayList<>();
    private OnItemListener mOnClick;
    private static String TAG = "PostsAdapter";

    public PostsAdapter(List<Results> postList, OnItemListener mOnClick) {
        this.postList = postList;
        this.mOnClick = mOnClick;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostViewHolder(view, mOnClick);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.userTV.setText(postList.get(position).getSource());
        holder.titleTV.setText(postList.get(position).getTitle());
        holder.bodyTV.setText(String.valueOf(postList.get(position).getArticalbody()));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void setList(List<Results> postList) {
        this.postList = postList;
        Log.e(TAG, "postList : " + postList);
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTV, userTV, bodyTV;
        OnItemListener onItemListener;

        public PostViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.title_artical);
            userTV = itemView.findViewById(R.id.source_artical);
            bodyTV = itemView.findViewById(R.id.body_artical);
            this.onItemListener = onItemListener;
            itemView.setOnClickListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemListener.onItemClick(getAdapterPosition());
                }
            });
        }


        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemListener {
        void onItemClick(int postion);
    }
}
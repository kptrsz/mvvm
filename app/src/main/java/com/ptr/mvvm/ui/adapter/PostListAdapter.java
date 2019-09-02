package com.ptr.mvvm.ui.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ptr.mvvm.R;
import com.ptr.mvvm.network.model.Post;

import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private List<Post> posts;

    public PostListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PostListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostListAdapter.ViewHolder holder, int position) {
        holder.setData(posts.get(position));
    }


    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    public void setPost(Post post) {
        this.posts.add(post);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (posts == null ? 0 : posts.size());
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView title;
        private final TextView body;
        private final TextView userId;
        private final TextView id;

        private Post post;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            body = itemView.findViewById(R.id.tv_body);
            userId = itemView.findViewById(R.id.tv_user_id);
            id = itemView.findViewById(R.id.tv_id);
            itemView.setOnClickListener(this);
        }

        void setData(Post post) {
            if (post != null) {
                this.post = post;
                title.setText(post.getTitle());
                body.setText(post.getBody());
                userId.setText(post.getUserId().toString());
                id.setText(post.getId().toString());
            }
        }

        @Override
        public void onClick(View v) {
            new AlertDialog.Builder(itemView.getContext())
                    .setCancelable(true)
                    .setPositiveButton(itemView.getContext().getString(R.string.ok), (dialog, which) -> dialog.dismiss())
                    .setTitle(post.getTitle())
                    .setMessage(post.getBody())
                    .create()
                    .show();
        }
    }
}

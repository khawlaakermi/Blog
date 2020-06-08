package com.example.blog.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.blog.Activities.PostDetailsActivity;
import com.example.blog.Models.Post;
import com.example.blog.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    Context context;
    List<Post> data ;

    public PostAdapter(Context context, List<Post> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.row_post_item,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTitle.setText(data.get(position).getTitle());
        Glide.with(context).load(data.get(position).getPicture()).into(holder.imgPost);
        Glide.with(context).load(data.get(position).getUserPhoto()).into(holder.imgPostProfile);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvTitle;
        ImageView imgPost;
        ImageView imgPostProfile;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            tvTitle=itemView.findViewById(R.id.row_post_title);
            imgPost=itemView.findViewById(R.id.row_post_img);
            imgPostProfile=itemView.findViewById(R.id.row_post_profile_img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(context, PostDetailsActivity.class);
                    int position=getAdapterPosition();
                    intent.putExtra("title",data.get(position).getTitle());
                    intent.putExtra("postImage",data.get(position).getPicture());
                    intent.putExtra("desciption",data.get(position).getDescription());
                    intent.putExtra("postKey",data.get(position).getPostKey());
                    intent.putExtra("userPhoto",data.get(position).getUserPhoto());
                    intent.putExtra("userId",data.get(position).getUserId());
                    long timeestamp =(long) data.get(position).getTimeStamp();
                    intent.putExtra("timestamp",timeestamp);
                    context.startActivity(intent);


                }
            });

        }

    }
}

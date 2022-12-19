package com.mustafa.listadapter_test;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PostAdapter extends BaseAdapter {

    Context c;
    int resource;
    ArrayList<Post> posts;


    public PostAdapter(Context c, int resource, ArrayList<Post> posts) {
        this.c = c;
        this.resource = resource;
        this.posts = posts;
    }


    public void addItem(Post post){
        this.posts.add(post);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Post getItem(int position) {

        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null){
            v = LayoutInflater.from(c).inflate(resource,null,false);

        }

        TextView tv_date = v.findViewById(R.id.custom_tv_date);
        TextView tv_name = v.findViewById(R.id.custom_tv_name);
        TextView tv_following = v.findViewById(R.id.custom_tv_following_num);//int_num
        TextView tv_followers = v.findViewById(R.id.custom_tv_followers_num);//int_num
        TextView tv_posts = v.findViewById(R.id.custom_tv_post_num);//int_num
        TextView tv_body = v.findViewById(R.id.custom_post_tv_body);

        Post p = getItem(position);

        try {
            tv_date.setText(p.getDate());
            tv_name.setText(p.getName());
            tv_following.setText(p.getFollowing()+"");
            tv_followers.setText(p.getFollowers()+"");
            tv_posts.setText(p.getPosts()+"");
            tv_body.setText(p.getBody());
        }catch (NullPointerException e){
            Log.d("TAG",e.getMessage());
        }


        return v;
    }
}

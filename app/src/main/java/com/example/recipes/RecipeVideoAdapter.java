package com.example.recipes;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

public class RecipeVideoAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context context;
    ArrayList<Recipe> recipes;

    public RecipeVideoAdapter(Context context, ArrayList<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public Object getItem(int position) {
        return recipes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null){
            view = inflater.inflate(R.layout.item_video_recipe, parent, false);
        }
        ((TextView) view.findViewById(R.id.tv_recipe_name)).setText(recipes.get(position).getName());
        ((TextView) view.findViewById(R.id.tv_recipe_description)).setText(recipes.get(position).getDescription());
        VideoView videoView = view.findViewById(R.id.vv_recipe);
        videoView.setVideoURI(Uri.parse(recipes.get(position).videoURL));
        MediaController mediaController = new MediaController(context);
        videoView.setMediaController(mediaController);
        videoView.requestFocus(0);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.seekTo(1);
            }
        });
        return view;
    }
}

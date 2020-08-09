package com.vedant.fragdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> Examplelist;
    Fragment mFragment;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImage;
        public TextView mText;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mText = itemView.findViewById(R.id.text);
        }
    }
    public ExampleAdapter(ArrayList<ExampleItem> exampleList) {
        Examplelist = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        final ExampleItem currentItem = Examplelist.get(position);
        holder.mImage.setImageResource(currentItem.getmImageResource());
        holder.mText.setText(currentItem.getmText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                if(currentItem==Examplelist.get(1))
                {
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new fruitfrag()).addToBackStack(null).commit();
                }
                else if(currentItem==Examplelist.get(2))
                {
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new vegefrag()).addToBackStack(null).commit();
                }
                else if(currentItem==Examplelist.get(3))
                {
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new dairyfrag()).addToBackStack(null).commit();
                }

            }
        });

    }
    @Override
    public int getItemCount() {
        return Examplelist.size();
    }
}

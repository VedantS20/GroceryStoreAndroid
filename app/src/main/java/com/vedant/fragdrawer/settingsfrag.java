package com.vedant.fragdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class settingsfrag extends Fragment {
    ArrayList<ExampleItem>exampleItemArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdap;
    private RecyclerView.LayoutManager layoutManager;
    Timer timer;
    public int position =0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_settings,container,false);
        exampleItemArrayList.add(new ExampleItem(R.drawable.supermarket, "Welcome to Supermarket"));
        exampleItemArrayList.add(new ExampleItem(R.drawable.fr, "Fruits"));
        exampleItemArrayList.add(new ExampleItem(R.drawable.ve,"Vegetables"));
        exampleItemArrayList.add(new ExampleItem(R.drawable.dp, "Dairy Products"));
        recyclerView = v.findViewById(R.id.RecycView);
        recyclerView.setHasFixedSize(true);
        getActivity().setTitle("Home");
//        layoutManager = new LinearLayoutManager(getContext());
        mAdap = new ExampleAdapter(exampleItemArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,true));
        recyclerView.setAdapter(mAdap);
        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(), 0, 2500);
        return v;
    }
    private class RemindTask extends TimerTask{

        @Override
                public void run() {
                    if(position==(exampleItemArrayList.size())) {
                        position = -1;
                    }
                    else {
                        position++;
                        recyclerView.smoothScrollToPosition(position);
                    }
                    }
                }

            }

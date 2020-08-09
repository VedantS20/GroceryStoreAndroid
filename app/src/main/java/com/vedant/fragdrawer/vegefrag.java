package com.vedant.fragdrawer;

import android.app.Activity;
import android.content.Context;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import es.dmoral.toasty.Toasty;

public class vegefrag extends Fragment {
    ElegantNumberButton Tomato , Potato,LadyFinger,Cabbage;
    TextView Tomc,Potc,Ladyc,Cabc;
    Button Ok1;
    public  vegfragListener listener;
    public  interface vegfragListener{
        void OnInputSentveg(String tomato ,String potato ,String lady ,String cabbage );
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_vege,container,false);
        Tomato = v.findViewById(R.id.tomcount);
        Potato = v.findViewById(R.id.potcount);
        LadyFinger = v.findViewById(R.id.ladycount);
        Cabbage = v.findViewById(R.id.cabcount);
        Tomc=v.findViewById(R.id.guvatext);
        Potc=v.findViewById(R.id.melontext);
        Ladyc=v.findViewById(R.id.orangetext);
        Cabc=v.findViewById(R.id.pinetext);
        Ok1 = v.findViewById(R.id.ok1);
        getActivity().setTitle("Vegies");
        Tomato.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Tomc.setText(Tomato.getNumber() + "KG");
            }
        });
        Potato.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Potc.setText(Potato.getNumber()+"KG");
            }
        });
        LadyFinger.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ladyc.setText(LadyFinger.getNumber()+"KG");
            }
        });
        Cabbage.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cabc.setText(Cabbage.getNumber()+"KG");
            }
        });
        Ok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Tom, pot, lady, Cab;
                if (Tomato.getNumber().equals("0")) {
                    Tom = null;
                } else {
                    Tom = Tomato.getNumber();
                }
                if (Potato.getNumber().equals("0")) {
                    pot = null;
                } else {
                    pot = Potato.getNumber();
                }
                if (LadyFinger.getNumber().equals("0")) {
                    lady = null;
                } else {

                    lady = LadyFinger.getNumber();
                }
                if (Cabbage.getNumber().equals("0")) {
                    Cab = null;
                } else {
                    Cab = Cabbage.getNumber();
                }
                listener.OnInputSentveg(Tom, pot, lady, Cab);
                Toasty.success(getContext(),"Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity   = (Activity) context;
        if(context instanceof vegefrag.vegfragListener)
        {
            listener = (vegefrag.vegfragListener) activity;
        }
        else {
            throw new RuntimeException(context.toString()
                    + "Must Implement FragmentFruitListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}

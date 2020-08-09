package com.vedant.fragdrawer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import es.dmoral.toasty.Toasty;

public class dairyfrag extends Fragment {
    ElegantNumberButton Cheese , Butter,Ice,Milk;
    TextView Chc,Butc,Icc,Milc;
    Button Ok3;
    dairyfragListener listener;
    public interface dairyfragListener{
        void OnInputdairy(String cheese,String butter,String ice,String milk);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_dairy,container,false);
        Cheese = v.findViewById(R.id.chcount);
        Butter = v.findViewById(R.id.butcount);
        Ice = v.findViewById(R.id.icecount);
        Milk = v.findViewById(R.id.milkcount);
        Chc=v.findViewById(R.id.guvatext);
        Butc = v.findViewById(R.id.melontext);
        Icc = v.findViewById(R.id.orangetext);
        Milc=v.findViewById(R.id.pinetext);
        Ok3 = v.findViewById(R.id.ok2);
        getActivity().setTitle("Dairy");
        Cheese.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chc.setText(Cheese.getNumber()+"gm");
            }
        });
        Butter.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Butc.setText(Butter.getNumber()+"gm");
            }
        });
        Ice.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Icc.setText(Ice.getNumber()+"gm");
            }
        });
        Milk.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Milc.setText(Milk.getNumber()+"liter");
            }
        });
        Ok3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cheese, butter, ice, milk;
                if (Cheese.getNumber().equals("0")) {
                    cheese = null;
                } else {
                    cheese = Cheese.getNumber();
                }
                if (Butter.getNumber().equals("0")) {
                    butter = null;
                } else {
                    butter = Butter.getNumber();
                }
                if (Ice.getNumber().equals("0")) {
                    ice = null;
                } else {

                    ice = Ice.getNumber();
                }
                if (Milk.getNumber().equals("0")) {
                    milk = null;
                } else {
                    milk = Milk.getNumber();
                }
                listener.OnInputdairy(cheese,butter,ice,milk);
                Toasty.success(getContext(),"Added to Cart",Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity   = (Activity) context;
        if(context instanceof dairyfrag.dairyfragListener)
        {
            listener = (dairyfrag.dairyfragListener) activity;
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

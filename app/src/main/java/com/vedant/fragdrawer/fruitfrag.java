package com.vedant.fragdrawer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import es.dmoral.toasty.Toasty;

public class fruitfrag extends Fragment {
    public ElegantNumberButton GuvaCount , MelonCount , PineCount,OrangeCount;
    TextView Guvac,Melonc,Pinec,Orangec;
    public Button Ok;
    public FragmentFruitListener fragmentFruitListener;
    ScrollView scrollView;
    public interface FragmentFruitListener{
        void OnInputSent(String guva,String melon,String orange,String pine);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fruit,container,false);
    GuvaCount =view.findViewById(R.id.guvacount);
    MelonCount=view.findViewById(R.id.meloncount);
    PineCount = view.findViewById(R.id.pinecount);
    OrangeCount = view.findViewById(R.id.orangecount);
    Guvac=view.findViewById(R.id.guvatext);
    Melonc=view.findViewById(R.id.melontext);
    Pinec=view.findViewById(R.id.pinetext);
    Orangec=view.findViewById(R.id.orangetext);
    Ok = view.findViewById(R.id.ok);
        getActivity().setTitle("Fruits");
        GuvaCount.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guvac.setText(GuvaCount.getNumber()+"KG");
            }
        });
        MelonCount.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Melonc.setText(MelonCount.getNumber()+"KG");
            }
        });
        OrangeCount.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Orangec.setText(OrangeCount.getNumber()+"KG");
            }
        });
        PineCount.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pinec.setText(PineCount.getNumber()+"KG");
            }
        });
    Ok.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String g,m,p,o;
            if (GuvaCount.getNumber().equals("0")) {
                g = null;
            } else {
                g = GuvaCount.getNumber();
            }
            if (MelonCount.getNumber().equals("0")) {
                m = null;
            } else {
                m = MelonCount.getNumber();
            }
            if (PineCount.getNumber().equals("0")) {
                p = null;
            } else {

                p = PineCount.getNumber();
            }
            if (OrangeCount.getNumber().equals("0")) {
                o = null;
            } else {
                o = OrangeCount.getNumber();
            }
            fragmentFruitListener.OnInputSent(g,m,p,o);
            Toasty.success(getContext(),"Added to Cart", Toast.LENGTH_SHORT).show();
        }
    });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity   = (Activity) context;
        if(context instanceof FragmentFruitListener)
        {
            fragmentFruitListener = (FragmentFruitListener) activity;
        }
        else {
            throw new RuntimeException(context.toString()
                    + "Must Implement FragmentFruitListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentFruitListener=null;
    }
}

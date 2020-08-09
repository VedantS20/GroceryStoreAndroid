package com.vedant.fragdrawer;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class cartfrag extends Fragment {
     private TextView Guva , Melon , Pine,Orange,Tom , Pot,Lady,Cab,Ch , But,Ice,Milk ,Sum;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cart, container, false);
        Guva = v.findViewById(R.id.editTextTextPersonName);
        Melon = v.findViewById(R.id.editTextTextPersonName2);
        Pine = v.findViewById(R.id.editTextTextPersonName3);
        Orange = v.findViewById(R.id.editTextTextPersonName4);
        Tom = v.findViewById(R.id.editTextTextPersonName5);
        Pot = v.findViewById(R.id.editTextTextPersonName6);
        Lady = v.findViewById(R.id.editTextTextPersonName7);
        Cab = v.findViewById(R.id.editTextTextPersonName8);
        Ch = v.findViewById(R.id.editTextTextPersonName9);
        But = v.findViewById(R.id.editTextTextPersonName10);
        Ice = v.findViewById(R.id.editTextTextPersonName11);
        Milk = v.findViewById(R.id.editTextTextPersonName12);
        Sum = v.findViewById(R.id.sum);
        getActivity().setTitle("Cart");
        String Guvac = null;
        String Melonc = null;
        String Orangec = null;
        String Pinec = null;
        String tomc = null;
        String potc = null;
        String ladyc = null;
        String cabc = null;
        String ch = null;
        String but = null;
        String ice = null;
        String milk = null;

        try {
            Guvac = getArguments().getString("guvacount");
            Melonc = getArguments().getString("meloncount");
            Orangec = getArguments().getString("orangecount");
            Pinec = getArguments().getString("pinecount");
            tomc = getArguments().getString("tomcount");
            potc = getArguments().getString("potcount");
            ladyc = getArguments().getString("ladycount");
            cabc = getArguments().getString("cabcount");
            ch = getArguments().getString("chcount");
            but = getArguments().getString("butcount");
            ice = getArguments().getString("icecount");
            milk = getArguments().getString("milkcount");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if(Guvac!=null)
        {
            Guva.setText("Guava--> " + Guvac + "KG");
        }
        else {
            Guvac="0";
        }
         if(Melonc!=null)
        {
            Melon.setText("WaterMelon--> " + Melonc + "KG");
        }
         else {
             Melonc="0";
         }
         if(Orangec!=null)
        {
            Orange.setText("Orange--> " + Orangec + "KG");
        }
         else {
             Orangec="0";
         }
         if(Pinec!=null)
        {
            Pine.setText("PineApple--> " + Pinec + "KG");
        }else {
             Pinec="0";
         }
         if(tomc!=null)
        {
            Tom.setText("Tomato--> " + tomc + "KG");
        }
         else {
             tomc="0";
         }
         if(potc!=null)
        {
            Pot.setText("Potato--> " + potc + "KG");
        }
         else {
             potc="0";
         }
         if(ladyc!=null)
        {
            Lady.setText("LadyFinger--> " + ladyc + "KG");
        }
         else {
             ladyc="0";
         }
         if(cabc!=null)
        {
            Cab.setText("Cabbage--> " + cabc + "KG");
        }
         else {
             cabc="0";
         }
         if(ch!=null)
        {
            Ch.setText("Cheese--> "+ch+"gm");
        }
         else {
             ch="0";
         }
         if(but!=null)
        {
            But.setText("Butter--> "+but+"gm");
        }
         else {
             but="0";
         }
         if(ice!=null)
        {
            Ice.setText("Ice Cream--> "+ice+"gm");
        }
         else {
             ice="0";
         }
         if(milk!=null)
        {
            Milk.setText("Milk--> "+milk+"Liter");
        }
         else {
             milk="0";
         }
         int SUM = (Integer.valueOf(Guvac) *30) + (Integer.valueOf(Pinec) *110)+ (Integer.valueOf(Orangec)*70)+ (Integer.valueOf(Melonc) *90)+ (Integer.valueOf(ladyc) *40)+ (Integer.valueOf(cabc) *30)+ (Integer.valueOf(tomc)*60)+ (Integer.valueOf(potc)*60)+ (Integer.valueOf(but)*35)+ (Integer.valueOf(ch)*30)+ (Integer.valueOf(milk)*60)+ (Integer.valueOf(ice)*125);
         Sum.setText("SubTotal : ₹"+Integer.toString(SUM));
        return v;
    }
}

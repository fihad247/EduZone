package com.fssoft.eduzone;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Fragment_Home extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView short_question_islam = myView.findViewById(R.id.short_question_islam);
        ImageView short_question_Mumin = myView.findViewById(R.id.short_question_Mumin);
        ImageView short_question_Sunnah = myView.findViewById(R.id.short_question_Sunnah);
        ImageView short_question_Koran = myView.findViewById(R.id.short_question_Koran);
        ImageView short_question_Kafer = myView.findViewById(R.id.short_question_Kafer);
        ImageView short_question_Halal = myView.findViewById(R.id.short_question_Halal);
        ImageView short_question_Haram = myView.findViewById(R.id.short_question_Haram);

        short_question_islam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Short_question_Islam.Question_Title= "ইসলাম";
                Intent myIntent = new Intent(getActivity(), Short_question_Islam.class);
                startActivity(myIntent);
            }
        });

        short_question_Mumin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Short_question_Mumin.Question_Title= "মুমিন";
                Intent myIntent = new Intent(getActivity(), Short_question_Mumin.class);
                startActivity(myIntent);
            }
        });

        short_question_Sunnah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Short_question_Sunnah.Question_Title= "সুন্নত";
                Intent myIntent = new Intent(getActivity(), Short_question_Sunnah.class);
                startActivity(myIntent);
            }
        });

        short_question_Koran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Short_question_Koran.Question_Title= "কোরআন";
                Intent myIntent = new Intent(getActivity(), Short_question_Koran.class);
                startActivity(myIntent);
            }
        });

        short_question_Kafer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Short_question_Kafer.Question_Title= "কাফের";
                Intent myIntent = new Intent(getActivity(), Short_question_Kafer.class);
                startActivity(myIntent);
            }
        });

        short_question_Halal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Short_question_Halal.Question_Title= "হালাল";
                Intent myIntent = new Intent(getActivity(), Short_question_Halal.class);
                startActivity(myIntent);
            }
        });

        short_question_Haram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Short_question_Haram.Question_Title= "হারাম";
                Intent myIntent = new Intent(getActivity(), Short_question_Haram.class);
                startActivity(myIntent);
            }
        });


        return myView;
    }
}
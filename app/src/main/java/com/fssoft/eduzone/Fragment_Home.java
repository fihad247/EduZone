package com.fssoft.eduzone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Fragment_Home extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_home, container, false);

        GridView gridView = myView.findViewById(R.id.gridView);

      //  MyAdepter myAdepter =new MyAdepter();
      //  gridView.setAdapter(myAdepter);

        /*
        short_question_islam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Short_question_Islam.Question_Title= "ইসলাম";
                Intent myIntent = new Intent(getActivity(), Short_question_Islam.class);
                startActivity(myIntent);
            }
        });
        */


        return myView;

    }//------------

    private class MyAdepter extends BaseAdapter {

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
           LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           View myView2 = layoutInflater.inflate(R.id.gridView_item, viewGroup, false);

            return myView2;
        }
    }



}//-----------
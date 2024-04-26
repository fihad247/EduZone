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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class Fragment_Home extends Fragment {

    HashMap<String, String> hashMap = new HashMap<>();
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_home, container, false);

        GridView gridView = myView.findViewById(R.id.gridView);

        creatTable();

        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);


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

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.item_home, parent, false);

            ImageView img_home = myView.findViewById(R.id.img_home);
            TextView text_home = myView.findViewById(R.id.text_home);

            HashMap<String, String> hashMap = arrayList.get(position);
            String image = hashMap.get("img");
            String text = hashMap.get("title");

            img_home.setImageResource(Integer.parseInt(image));
            text_home.setText(text);

            return myView;
        }
    }

    private void creatTable() {

        hashMap = new HashMap<>();
        hashMap.put("img", String.valueOf(R.drawable.icon_result));
        hashMap.put("title", "রুটিন");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", String.valueOf(R.drawable.icon_result));
        hashMap.put("title", "সাজেশন");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", String.valueOf(R.drawable.icon_result));
        hashMap.put("title", "বইয়ের তালিকা");
        arrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("img", String.valueOf(R.drawable.icon_result));
        hashMap.put("title", "শিক্ষার ধাপ");
        arrayList.add(hashMap);


    }


}//-----------
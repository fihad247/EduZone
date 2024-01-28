package com.fssoft.eduzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Short_question_Mumin extends AppCompatActivity {


    ListView lisrView_sq_Question;
    ArrayList<HashMap<String, String>> arrayList= new ArrayList<>();
    HashMap <String, String> hashMap;
    public static String Question_Title = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_question_islam);


        lisrView_sq_Question = findViewById(R.id.sq_Question);

        //-------Get Title From Home Fragment
        TextView short_question_Title = findViewById(R.id.short_question_Title);
        short_question_Title.setText(Question_Title+ " সম্পর্কে সাধারণ জ্ঞান");

        //------ Change the status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }

        HashMap<String, String> hashMap = new HashMap<>();

// Question 1
        hashMap.put("Question", "মুমিন কাকে বলে?");
        hashMap.put("Answer", "যে ব্যক্তি আল্লাহর ও তাঁর রাসূলের প্রতি ঈমান আনেন, তাকেই মুমিন বলা হয়।");
        arrayList.add(hashMap);

// Question 2
        hashMap = new HashMap<>();
        hashMap.put("Question", "মুমিনের বৈশিষ্ট্য কী কী?");
        hashMap.put("Answer", "মুমিনের বৈশিষ্ট্য হল, সে আল্লাহর ও তাঁর রাসূলের প্রতি ঈমান আনে, নামাজ পড়ে, যাকাত দেয়, রোজা রাখে এবং হজ্জ পালন করে। এছাড়াও, সে সত্যবাদী, নামাযের আদায়কারী, নামাজে মনোযোগী, দয়ালু, করুণাময়, পরোপকারী হয়ে থাকে।");
        arrayList.add(hashMap);

// Question 3
        hashMap = new HashMap<>();
        hashMap.put("Question", "মুমিনের দায়িত্ব কী কী?");
        hashMap.put("Answer", "মুমিনের দায়িত্ব হল, আল্লাহর নির্দেশাবলী মেনে চলা, তাঁর নিষেধাবলী থেকে বেঁচে থাকা, তাঁর সন্তুষ্টি অর্জনের জন্য চেষ্টা করা এবং সৃষ্টির প্রতি নম্র হয়ে থাকা।");
        arrayList.add(hashMap);

// Question 4
        hashMap = new HashMap<>();
        hashMap.put("Question", "মুমিনের পুরস্কার কী?");
        hashMap.put("Answer", "মুমিনের পুরস্কার হল, জান্নাতের চিরন্তন সুখ।");
        arrayList.add(hashMap);

// Question 5
        hashMap = new HashMap<>();
        hashMap.put("Question", "মুমিনের কীভাবে জীবনযাপন করা উচিত?");
        hashMap.put("Answer", "মুমিনের জীবনযাপন করা উচিত আল্লাহর সন্তুষ্টি অর্জনের জন্য, তাঁর নির্দেশাবলী মেনে চলে এবং তাঁর নিষেধাবলী থেকে বেঁচে থাকার মাধ্যমে। মুমিনের জীবনযাপন করা উচিত সৎভাবে, নামায পড়ে, যাকাত দেয়, রোজা রাখে এবং হজ্জ পালন করে। মুমিনের জীবনযাপন করা উচিত দয়ালু, করুণাময়, পরোপকারী এবং সৃষ্টির প্রতি নম্র হয়ে থাকার মাধ্যমে।");
        arrayList.add(hashMap);

// Question 6
        hashMap = new HashMap<>();
        hashMap.put("Question", "মুমিনের কীভাবে আল্লাহর সঙ্গে সম্পর্ক রাখতে হবে?");
        hashMap.put("Answer", "মুমিনের আল্লাহর সঙ্গে সম্পর্ক রাখতে হবে নামায পড়ে, দুআ করে, কোরআন তিলাওয়াত করে এবং তাঁর নির্দেশাবলী মেনে চলার মাধ্যমে।");
        arrayList.add(hashMap);

// Question 7
        hashMap = new HashMap<>();
        hashMap.put("Question", "মুমিনের কীভাবে রাসূল (স.) এর সঙ্গে সম্পর্ক রাখতে হবে?");
        hashMap.put("Answer", "মুমিনের রাসূল (স.) এর সঙ্গে সম্পর্ক রাখতে হবে তাঁর সুন্নাহ অনুসরণ করে, তাঁর প্রতি ভালোবাসা রাখার মাধ্যমে এবং তাঁকে অভ্যর্থনা করে নেওয়ার মাধ্যমে।");
        arrayList.add(hashMap);




        MyAdapter myAdapter = new MyAdapter();
        lisrView_sq_Question.setAdapter(myAdapter);


    }
    //--========================================================


    private class MyAdapter extends BaseAdapter {

        LayoutInflater layoutInflater;

        @Override
        public int getCount() {
            return arrayList.size() ;
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
        public View getView(int position, View view, ViewGroup viewGroup) {

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView =  layoutInflater.inflate(R.layout.listview_short_question, viewGroup, false);

            TextView tvName =myView.findViewById(R.id.tvName);
            TextView tvNumber =myView.findViewById(R.id.tvMobile);

            HashMap<String,String> hashmap = arrayList.get(position);

            String name = hashmap.get("Question");
            String mobile = hashmap.get("Answer");
            tvName.setText("প্রশ্নঃ "+ name);
            tvNumber.setText("উত্তরঃ " + mobile);

            return myView;
        }
    }








    // --========================================================
}
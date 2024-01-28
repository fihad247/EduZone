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

public class Short_question_Halal extends AppCompatActivity {


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




        hashMap = new HashMap<>();
        hashMap.put("Question", "হালাল কী?");
        hashMap.put("Answer", "ইসলামী শরীয়তে যেসব পানাহার ও অন্যান্য বিষয় বৈধ তা হালাল বলে অভিহিত করা হয়।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Question", "হালাল খাবারের গুরুত্ব কী?");
        hashMap.put("Answer", "হালাল খাবার খাওয়া ইসলামী বিধান। এ ছাড়াও হালাল খাবার খেলে শারীরিক ও মানসিকভাবে সুস্থ থাকা যায়।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Question", "কীভাবে মাংস জবাই করতে হয় যাতে তা হালাল হয়?");
        hashMap.put("Answer", "ইসলামী নিয়ম অনুযায়ী মাংস জবাই করতে হলে নিম্নলিখিত শর্তাবলী পূরণ করতে হবে: " +
                "\n জবাইকারী মুসলমান হতে হবে। \n জবাই করা হবে ধারালো ছুরি দিয়ে। \n জবাই করার আগে বসমিল্লাহ বলা হবে। \n জবাইয়ের সময় পশুটির ঘাড় একটানে কেটে দেওয়া হবে।" +
                " \n জবাইয়ের সময় পশুটিকে যন্ত্রণা দেওয়া যাবে না।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Question", "বাংলাদেশে হালাল খাবার কীভাবে পাব?");
        hashMap.put("Answer", "বাংলাদেশে বেশিরভাগ রেস্টুরেন্ট এবং খাবারের দোকানে হালাল খাবার পাওয়া যায়। এ ছাড়াও বাজারে হালাল খাবারের জন্য আলাদা বিভাগ রয়েছে।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Question", "হালাল কী কী খাবার?");
        hashMap.put("Answer", "সব ধরনের সবজি, ফল, শস্য, দুগ্ধজাত পণ্য এবং জবাই করা পশু-পাখির মাংস হালাল। তবে শুকর, গর্দভ, খচ্চর, ইঁদুর, সাপ, কুকুর, বিড়াল ইত্যাদি জবাই করা হলেও তা হালাল নয়।");
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
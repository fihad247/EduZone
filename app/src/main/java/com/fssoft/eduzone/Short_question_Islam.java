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

public class Short_question_Islam extends AppCompatActivity {


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


// Question 2
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামের পাঁচটি মূলনীতি কী?");
        hashMap.put("Answer", "ইসলামের পাঁচটি মূলনীতি হলো কালেমা শাহাদাহ, নামাজ, রোজা, জাকাত ও হজ্ব।");
        arrayList.add(hashMap);

// Question 3
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামের মূল কিতাব কী?");
        hashMap.put("Answer", "ইসলামের মূল কিতাব হলো কুরআন শরীফ।");
        arrayList.add(hashMap);

// Question 4
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামের সর্বশেষ নবী কে?");
        hashMap.put("Answer", "ইসলামের সর্বশেষ নবী হলেন নবী মুহাম্মদ (সাঃ)।");
        arrayList.add(hashMap);

// Question 5
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামের প্রধান শিক্ষা কী?");
        hashMap.put("Answer", "ইসলামের প্রধান শিক্ষা হলো মানবতার প্রতি ভালোবাসা, শান্তি, সহিষ্ণুতা ও সহযোগিতা।");
        arrayList.add(hashMap);

// Question 6
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামে নামাজের গুরুত্ব কী?");
        hashMap.put("Answer", "ইসলামে নামাজ হলো আল্লাহর সাথে সরাসরি যোগাযোগের মাধ্যম। নামাজ পড়ার মাধ্যমে আমরা আল্লাহর কাছে ক্ষমা চাইতে পারি, তাঁর কাছে দোয়া করতে পারি এবং তাঁর প্রশংসা করতে পারি।");
        arrayList.add(hashMap);

// Question 7
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামে রোজার গুরুত্ব কী?");
        hashMap.put("Answer", "ইসলামে রোজার মাধ্যমে আমরা আমাদের আত্মসংযম ও আত্মনিয়ন্ত্রণের ক্ষমতা বাড়িয়ে তুলতে পারি। রোজার মাধ্যমে আমরা গরিব ও অসহায়দের কষ্টের অনুভূতি উপলব্ধি করতে পারি এবং তাদের প্রতি আমাদের সহানুভূতি বৃদ্ধি পায়।");
        arrayList.add(hashMap);

// Question 8
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামে জাকাতের গুরুত্ব কী?");
        hashMap.put("Answer", "ইসলামে জাকাত হলো সমাজের অসহায় ও গরিব মানুষদের সাহায্য করার একটি পদ্ধতি। জাকাত দেওয়ার মাধ্যমে আমরা আমাদের সম্পদের একটা অংশ আল্লাহর রাস্তায় দান করি এবং আমাদের সম্পদ বরকতময় হয়।");
        arrayList.add(hashMap);

        // Question 2
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামের পাঁচটি মূলনীতি কী?");
        hashMap.put("Answer", "ইসলামের পাঁচটি মূলনীতি হলো কালেমা শাহাদাহ, নামাজ, রোজা, জাকাত ও হজ্ব।");
        arrayList.add(hashMap);

// Question 3
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামের মূল কিতাব কী?");
        hashMap.put("Answer", "ইসলামের মূল কিতাব হলো কুরআন শরীফ।");
        arrayList.add(hashMap);

// Question 4
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামের সর্বশেষ নবী কে?");
        hashMap.put("Answer", "ইসলামের সর্বশেষ নবী হলেন নবী মুহাম্মদ (সাঃ)।");
        arrayList.add(hashMap);

// Question 5
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামের প্রধান শিক্ষা কী?");
        hashMap.put("Answer", "ইসলামের প্রধান শিক্ষা হলো মানবতার প্রতি ভালোবাসা, শান্তি, সহিষ্ণুতা ও সহযোগিতা।");
        arrayList.add(hashMap);

// Question 6
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামে নামাজের গুরুত্ব কী?");
        hashMap.put("Answer", "ইসলামে নামাজ হলো আল্লাহর সাথে সরাসরি যোগাযোগের মাধ্যম। নামাজ পড়ার মাধ্যমে আমরা আল্লাহর কাছে ক্ষমা চাইতে পারি, তাঁর কাছে দোয়া করতে পারি এবং তাঁর প্রশংসা করতে পারি।");
        arrayList.add(hashMap);

// Question 7
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামে রোজার গুরুত্ব কী?");
        hashMap.put("Answer", "ইসলামে রোজার মাধ্যমে আমরা আমাদের আত্মসংযম ও আত্মনিয়ন্ত্রণের ক্ষমতা বাড়িয়ে তুলতে পারি। রোজার মাধ্যমে আমরা গরিব ও অসহায়দের কষ্টের অনুভূতি উপলব্ধি করতে পারি এবং তাদের প্রতি আমাদের সহানুভূতি বৃদ্ধি পায়।");
        arrayList.add(hashMap);

// Question 8
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামে জাকাতের গুরুত্ব কী?");
        hashMap.put("Answer", "ইসলামে জাকাত হলো সমাজের অসহায় ও গরিব মানুষদের সাহায্য করার একটি পদ্ধতি। জাকাত দেওয়ার মাধ্যমে আমরা আমাদের সম্পদের একটা অংশ আল্লাহর রাস্তায় দান করি এবং আমাদের সম্পদ বরকতময় হয়।");
        arrayList.add(hashMap);

        // Question 2
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামের পাঁচটি মূলনীতি কী?");
        hashMap.put("Answer", "ইসলামের পাঁচটি মূলনীতি হলো কালেমা শাহাদাহ, নামাজ, রোজা, জাকাত ও হজ্ব।");
        arrayList.add(hashMap);

// Question 3
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামের মূল কিতাব কী?");
        hashMap.put("Answer", "ইসলামের মূল কিতাব হলো কুরআন শরীফ।");
        arrayList.add(hashMap);

// Question 4
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামের সর্বশেষ নবী কে?");
        hashMap.put("Answer", "ইসলামের সর্বশেষ নবী হলেন নবী মুহাম্মদ (সাঃ)।");
        arrayList.add(hashMap);

// Question 5
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামের প্রধান শিক্ষা কী?");
        hashMap.put("Answer", "ইসলামের প্রধান শিক্ষা হলো মানবতার প্রতি ভালোবাসা, শান্তি, সহিষ্ণুতা ও সহযোগিতা।");
        arrayList.add(hashMap);

// Question 6
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামে নামাজের গুরুত্ব কী?");
        hashMap.put("Answer", "ইসলামে নামাজ হলো আল্লাহর সাথে সরাসরি যোগাযোগের মাধ্যম। নামাজ পড়ার মাধ্যমে আমরা আল্লাহর কাছে ক্ষমা চাইতে পারি, তাঁর কাছে দোয়া করতে পারি এবং তাঁর প্রশংসা করতে পারি।");
        arrayList.add(hashMap);

// Question 7
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামে রোজার গুরুত্ব কী?");
        hashMap.put("Answer", "ইসলামে রোজার মাধ্যমে আমরা আমাদের আত্মসংযম ও আত্মনিয়ন্ত্রণের ক্ষমতা বাড়িয়ে তুলতে পারি। রোজার মাধ্যমে আমরা গরিব ও অসহায়দের কষ্টের অনুভূতি উপলব্ধি করতে পারি এবং তাদের প্রতি আমাদের সহানুভূতি বৃদ্ধি পায়।");
        arrayList.add(hashMap);

// Question 8
        hashMap = new HashMap<>();
        hashMap.put("Question", "ইসলামে জাকাতের গুরুত্ব কী?");
        hashMap.put("Answer", "ইসলামে জাকাত হলো সমাজের অসহায় ও গরিব মানুষদের সাহায্য করার একটি পদ্ধতি। জাকাত দেওয়ার মাধ্যমে আমরা আমাদের সম্পদের একটা অংশ আল্লাহর রাস্তায় দান করি এবং আমাদের সম্পদ বরকতময় হয়।");
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
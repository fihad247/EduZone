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

public class Short_question_Koran extends AppCompatActivity {


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





// Question 1
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআন কাকে বলে?");
        hashMap.put("Answer", "কুরআন মুসলমানদের পবিত্র ধর্মগ্রন্থ। এটি আল্লাহর কাছ থেকে  হজরত মুহাম্মদ (সাঃ) এর উপর অবতীর্ণ হয়েছে।");
        arrayList.add(hashMap);

// Question 2
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআনের কি কি নাম আছে?");
        hashMap.put("Answer", "কুরআনের অনেক নাম রয়েছে, যেমন আল কুরআন, আল ফুরকান, আল হিকমাহ, আল কিতাব, আল নূর, আল হুদা, আল ذِكر ইত্যাদি।");
        arrayList.add(hashMap);

// Question 3
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআন কোন ভাষায় রচিত হয়েছে?");
        hashMap.put("Answer", "কুরআন আরবি ভাষায় রচিত হয়েছে।");
        arrayList.add(hashMap);

// Question 4
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআনের কোন কোন বিভাগ আছে?");
        hashMap.put("Answer", "কুরআনের মূলত দুইটি বিভাগ আছে: সূরা ও আয়াত। সূরা হলো কুরআনের অধ্যায় এবং আয়াত হলো সূরার ক্ষুদ্রতম একক।");
        arrayList.add(hashMap);

// Question 5
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআনে কতটি সূরা আছে?");
        hashMap.put("Answer", "কুরআনে ১১৪টি সূরা আছে।");
        arrayList.add(hashMap);

// Question 6
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআনে কতটি আয়াত আছে?");
        hashMap.put("Answer", "কুরআনে ৬২৩৬টি আয়াত আছে।");
        arrayList.add(hashMap);

// Question 7
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআনের প্রথম সূরার নাম কি?");
        hashMap.put("Answer", "কুরআনের প্রথম সূরার নাম আল-ফাতিহা।");
        arrayList.add(hashMap);

// Question 8
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআনের দীর্ঘতম সূরার নাম কি?");
        hashMap.put("Answer", "কুরআনের দীর্ঘতম সূরার নাম আল-বাকারা।");
        arrayList.add(hashMap);

// Question 9
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআনের সর্বশেষ সূরার নাম কি?");
        hashMap.put("Answer", "কুরআনের সর্বশেষ সূরার নাম আন-নাস।");
        arrayList.add(hashMap);

// Question 10
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআন কার উপর অবতীর্ণ হয়েছে?");
        hashMap.put("Answer", "কুরআন হজরত মুহাম্মদ (সাঃ) এর উপর অবতীর্ণ হয়েছে।");
        arrayList.add(hashMap);

// Question 11
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআন কত বছরের ব্যবধানে অবতীর্ণ হয়েছে?");
        hashMap.put("Answer", "কুরআন ২৩ বছরের ব্যবধানে অবতীর্ণ হয়েছে।");
        arrayList.add(hashMap);

// Question 12
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআন কার মাধ্যমে অবতীর্ণ হয়েছে?");
        hashMap.put("Answer", "কুরআন হজরত জিবরাইল (আঃ)");
        arrayList.add(hashMap);


// Question 13
                hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআনের কি কি বিষয় আলোচনা করা হয়েছে?");
        hashMap.put("Answer", "কুরআনে বিভিন্ন বিষয় আলোচনা করা হয়েছে, যেমন আল্লাহর একত্ব, নবী-রাসূলদের জীবনী, আখিরাতের বিবরণ, নৈতিকতা, বিধি-বিধান ইত্যাদি।");
        arrayList.add(hashMap);

// Question 14
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআন কীভাবে পাঠ করা উচিত?");
        hashMap.put("Answer", "কুরআন তালাওয়াত করার কিছু নিয়ম রয়েছে, যেমন সুস্বর করে পড়তে হবে, তাফসীর বুঝে পড়তে হবে, ইত্যাদি।");
        arrayList.add(hashMap);

// Question 15
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআন কীভাবে আমাদের জীবনে প্রভাব ফেলতে পারে?");
        hashMap.put("Answer", "কুরআন আমাদের জীবনের সব ক্ষেত্রে প্রভাব ফেলতে পারে। আমাদের বিশ্বাস, নৈতিকতা, আচার-আচরণ, সম্পর্ক ইত্যাদি সব বিষয়ে কুরআন আমাদের সঠিক পথ দেখায়।");
        arrayList.add(hashMap);

// Question 16
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআনের কি কি ফজিলত রয়েছে?");
        hashMap.put("Answer", "কুরআনের অনেক ফজিলত রয়েছে, যেমন কুরআন তিলাওয়াত করলে নেকি পাওয়া যায়, কুরআন মুখস্থ করলে জান্নাতে উঁচু মর্যাদা পাওয়া যায়, কুরআন অনুযায়ী জীবনযাপন করলে আল্লাহর সন্তুষ্টি পাওয়া যায় ইত্যাদি।");
        arrayList.add(hashMap);

// Question 17
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআন পড়ার সঠিক সময় কোনটি?");
        hashMap.put("Answer", "কুরআন যে কোন সময় পড়া যেতে পারে। তবে ফজিলত পাওয়ার জন্য কিছু সময় নির্দিষ্ট করা উচিত, যেমন ফজরের নামাজের পর, মাগরিবের নামাজের পর, ইত্যাদি।");
        arrayList.add(hashMap);

// Question 18
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআন পড়ার আগে কি করতে হবে?");
        hashMap.put("Answer", "কুরআন পড়ার আগে নিজেকে পবিত্র করে নিতে হবে, অর্থাৎ অজু করতে হবে। এছাড়াও নিয়ত করে কুরআন পড়া উচিত।");
        arrayList.add(hashMap);

// Question 19
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআন পড়ার সময় কোন সতর্কতা অবলম্বন করতে হবে?");
        hashMap.put("Answer", "কুরআন পড়ার সময় কিছু সতর্কতা অবলম্বন করা উচিত, যেমন সুস্বর করে পড়তে হবে, অর্থ বুঝে পড়তে হবে, কুরআনের সাথে শিষ্টাচার বজায় রাখতে হবে ইত্যাদি।");
        arrayList.add(hashMap);

// Question 20
        hashMap = new HashMap<>();
        hashMap.put("Question", "কুরআনের তাফসীর কী?");
        hashMap.put("Answer", "কুরআনের তাফসীর হলো কুরআনের অর্থ ব্যাখ্যা করা।");
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
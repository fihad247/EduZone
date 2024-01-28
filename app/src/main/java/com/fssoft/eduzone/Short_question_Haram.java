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

public class Short_question_Haram extends AppCompatActivity {


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
        hashMap.put("Question", "হারাম কাকে বলে?");
        hashMap.put("Answer", "হারাম হলো আল্লাহ তা'আলা নিষেধ করেছেন এমন সব কাজ যা আমাদের জন্য ক্ষতিকর।");
        arrayList.add(hashMap);

// Question 2
        hashMap = new HashMap<>();
        hashMap.put("Question", "হারামের গুরুত্ব কী?");
        hashMap.put("Answer", "হারামের গুরুত্ব অপরিসীম। হারাম কাজ করা থেকে বিরত থাকলে আমরা আল্লাহ তা'আলার সন্তুষ্টি লাভ করতে পারি এবং জান্নাতে উচ্চ মর্যাদা লাভ করতে পারি।");
        arrayList.add(hashMap);

// Question 3
        hashMap = new HashMap<>();
        hashMap.put("Question", "হারামের প্রকারভেদ কী কী?");
        hashMap.put("Answer", "হারামের দুইটি প্রকারভেদ রয়েছে: \n১. কবিরা গোনাহ \n২. সগিরা গোনাহ");
        arrayList.add(hashMap);

// Question 4
        hashMap = new HashMap<>();
        hashMap.put("Question", "কবিরা গোনাহ কাকে বলে?");
        hashMap.put("Answer", "যে গোনাহ কাজ করলে কঠিন শাস্তি হবে এবং কোনো কোনো ক্ষেত্রে কাফের হওয়ার আশঙ্কা রয়েছে, তাকে কবিরা গোনাহ বলে।");
        arrayList.add(hashMap);

// Question 5
        hashMap = new HashMap<>();
        hashMap.put("Question", "সগিরা গোনাহ কাকে বলে?");
        hashMap.put("Answer", "যে গোনাহ কাজ করলে কঠিন শাস্তি হবে না কিন্তু গুনাহ হয়, তাকে সগিরা গোনাহ বলে।");
        arrayList.add(hashMap);

// Question 6
        hashMap = new HashMap<>();
        hashMap.put("Question", "হারামের উদাহরণ কী কী?");
        hashMap.put("Answer", "হারামের উদাহরণ হলো:" +
                        "\n শির্ক করা \n জিনা করা \n চুরি করা \n মিথ্যা বলা  \n ঘুষ দেওয়া-নেওয়া \n মদ খাওয়া  \n জুয়া খেলা \n সুদের লেনদেন করা \n বাবা-মাকে অবাধ্য করা \n রাস্তায় প্রস্রাব করা \n লোক দেখানো ইবাদত করা \nমানুষকে ধোঁকা দেওয়া");
        arrayList.add(hashMap);
// Question 7
        hashMap = new HashMap<>();
        hashMap.put("Question", "হারাম কাজ করলে কী হয়?");
        hashMap.put("Answer", "হারাম কাজ করলে আল্লাহ তা'আলার গজব নেমে আসে এবং দুনিয়া-আখিরাতে কঠিন শাস্তি হবে।");
        arrayList.add(hashMap);

// Question 8
        hashMap = new HashMap<>();
        hashMap.put("Question", "হারাম কাজ করা থেকে কিভাবে বিরত থাকা যায়?");
        hashMap.put("Answer", "হারাম কাজ করা থেকে বিরত থাকার উপায় হলো:\n আল্লাহ তা'আলার ভয় করা \nজান্নাত ও জাহান্নাম সম্পর্কে চিন্তা করা \nনবী মুহাম্মদ (সাঃ) এর সুন্নত অনুসরণ করা \nসৎ ও নেককার লোকদের সাহচর্য করা \nহারাম কাজের পরিবেশ থেকে দূরে থাকা");
        arrayList.add(hashMap);


// Question 10
        hashMap = new HashMap<>();
        hashMap.put("Question", "হারাম কাজ করার কি কি ক্ষতিকর দিক রয়েছে?");
        hashMap.put("Answer", "হারাম কাজ করার কি কি ক্ষতিকর দিক রয়েছে? \nআল্লাহ তা'আলার গজব নেমে আসে \nদুনিয়া-আখিরাতে কঠিন শাস্তি হবে \nমনের শান্তি চলে যায় \nদ্বীন ও দুনিয়া উভয়টিতেই পিছিয়ে পড়া হয় \n সমাজে মান-সম্মান কমে যায় \n আল্লাহ তা'আলার বরকত কমে যায়"); arrayList.add(hashMap);
// Question 11
        hashMap = new HashMap<>();
        hashMap.put("Question", "হারাম কাজ করার কি কি সুবিধার দিক রয়েছে?");
        hashMap.put("Answer", "হারাম কাজ করার কোনো সুবিধার দিক নেই। হারাম কাজ করার সব দিকেই ক্ষতি রয়েছে।");
        arrayList.add(hashMap);

// Question 12
        hashMap = new HashMap<>();
        hashMap.put("Question", "হারাম কাজ করার ক্ষেত্রে কি কি বিষয় এড়িয়ে চলতে হবে?");
        hashMap.put("Answer", "হারাম কাজ করার ক্ষেত্রে কি কি বিষয় এড়িয়ে চলতে হবে?\n িজের নফসের ইচ্ছাকে পূর্ণ করার জন্য হারাম কাজ করা \n শয়তানের প্ররোচনায় হারাম কাজ করা \n বন্ধু-বান্ধবের অনুসরণে হারাম কাজ করা \n সমাজের প্রচলনের কারণে হারাম কাজ করা");
        arrayList.add(hashMap);
// Question 13
                hashMap = new HashMap<>();
        hashMap.put("Question", "হারাম কাজ করার ক্ষেত্রে আমাদের কিভাবে সাহায্য নিতে হবে?");
        hashMap.put("Answer", "হারাম কাজ করার ক্ষেত্রে আমাদের দ্বীনদার আলেমদের সাহাচর্য করতে হবে এবং তাদের মতামত নিতে হবে।");
        arrayList.add(hashMap);

// Question 14
        hashMap = new HashMap<>();
        hashMap.put("Question", "হারাম কাজ করার ক্ষেত্রে আমাদের কোন দোয়া করতে হবে?");
        hashMap.put("Answer", "হারাম কাজ করার ক্ষেত্রে আমাদের নিম্নলিখিত দোয়া করতে হবে:\n اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ كُلِّ مُحَرَّمٍ\n (অর্থ : হে আল্লাহ্, আমি সব হারাম কাজ থেকে আপনার কাছে আশ্রয় চাই।)");
        arrayList.add(hashMap);

// Question 15
        hashMap = new HashMap<>();
        hashMap.put("Question", "হারাম কাজ করার ক্ষেত্রে আমাদের কিভাবে নিজেকে সুরক্ষিত রাখতে হবে?");
        hashMap.put("Answer", "হারাম কাজ করার ক্ষেত্রে নিজেকে সুরক্ষিত রাখার উপায় হলো:\n আল্লাহ তা'আলার ভয় করা \n জান্নাত ও জাহান্নাম সম্পর্কে চিন্তা করা \n নবী মুহাম্মদ (সাঃ) এর সুন্নত অনুসরণ করা \n সৎ ও নেককার লোকদের সাহচর্য করা \n হারাম কাজের পরিবেশ থেকে দূরে থাকা");
        arrayList.add(hashMap);


// Question 16
        hashMap = new HashMap<>();
        hashMap.put("Question", "হারাম কাজ করার কি কি পাপসমূহ রয়েছে?");
        hashMap.put("Answer", "হারাম কাজ করার কি কি পাপসমূহ রয়েছে? \n আল্লাহর অবাধ্যতা করা \n শয়তানকে খুশি করা \n নিজেকে ক্ষতি করা \n অন্যদের ক্ষতি করা  \n আল্লাহর রহমত থেকে দূরে সরে যাওয়া");
        arrayList.add(hashMap);
// Question 17
                hashMap = new HashMap<>();
        hashMap.put("Question", "হারাম কাজ করার কি কি ফলাফল রয়েছে?");
        hashMap.put("Answer", "হারাম কাজ করার কি কি ফলাফল রয়েছে? \n দুনিয়াতে নানা রকম সমস্যা ও বিপদ \n আখিরাতে জাহান্নামের শাস্তি");
        arrayList.add(hashMap);
// Question 18
                hashMap = new HashMap<>();
        hashMap.put("Question", "হারাম কাজ করার ক্ষেত্রে আমাদের কি কি সতর্কতা অবলম্বন করতে হবে?");
        hashMap.put("Answer", "হারাম কাজ করার ক্ষেত্রে আমাদের কি কি সতর্কতা অবলম্বন করতে হবে? \n নিজের নফসের ইচ্ছাকে পূর্ণ করার জন্য হারাম কাজ করা থেকে বিরত থাকতে হবে \n শয়তানের প্ররোচনায় হারাম কাজ করা থেকে বিরত থাকতে হবে \n বন্ধু-বান্ধবের অনুসরণে হারাম কাজ করা থেকে বিরত থাকতে হবে \n সমাজের প্রচলনের কারণে হারাম কাজ করা থেকে বিরত থাকতে হবে");
        arrayList.add(hashMap);
// Question 19
                hashMap = new HashMap<>();
        hashMap.put("Question", "হারাম কাজ করার ক্ষেত্রে আমাদের কিভাবে নিজেকে সুরক্ষিত রাখতে হবে?");
        hashMap.put("Answer", "হারাম কাজ করার ক্ষেত্রে নিজেকে সুরক্ষিত রাখার উপায় হলো: \n আল্লাহ তা'আলার ভয় করা \n জান্নাত ও জাহান্নাম সম্পর্কে চিন্তা করা \n নবী মুহাম্মদ (সাঃ) এর সুন্নত অনুসরণ করা \n সৎ ও নেককার লোকদের সাহচর্য করা \n হারাম কাজের পরিবেশ থেকে দূরে থাকা");
        arrayList.add(hashMap);
// Question 20
        hashMap = new HashMap<>();
        hashMap.put("Question", "হারাম কাজ করার ক্ষেত্রে আমাদের কিভাবে তওবা করতে হবে?");
        hashMap.put("Answer", "হারাম কাজ করার ক্ষেত্রে তওবা করার পদ্ধতি হলো: \nআন্তরিকভাবে অনুতপ্ত হওয়া \nপুনরায় হারাম কাজ না করার সংকল্প করা \n আল্লাহর কাছে ক্ষমা চাওয়া");
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
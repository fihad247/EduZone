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

public class Short_question_Kafer extends AppCompatActivity {


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
        hashMap.put("Question", "কাদেরকে কাফের বলে?");
        hashMap.put("Answer", "যে ব্যক্তি আল্লাহর একত্ব এবং নবী মুহাম্মদ (সাঃ) এর রাসূলত্বে বিশ্বাস করে না, তাকে কাফের বলা হয়।");
        arrayList.add(hashMap);

// Question 2
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের কি কি শাস্তি দেওয়া হবে?");
        hashMap.put("Answer", "কাফেরদের দুনিয়াতেও শাস্তি দেওয়া হতে পারে এবং আখিরাতেও শাস্তি দেওয়া হবে। দুনিয়াতে তাদের বিভিন্ন ধরনের কষ্ট ও বিপদে পড়তে হতে পারে। আর আখিরাতে তাদের জাহান্নামে নিক্ষিপ্ত করা হবে।");
        arrayList.add(hashMap);

// Question 3
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের সাথে কিভাবে ব্যবহার করতে হবে?");
        hashMap.put("Answer", "কাফেরদের সাথে ইনসাফের সাথে ব্যবহার করতে হবে। তাদের সাথে জুলুম বা অত্যাচার করা যাবে না। তবে তাদের সাথে মিশতে হলে বা কথা বলতে হলে সতর্ক থাকতে হবে। যাতে তাদের কথা ও কাজের দ্বারা আমাদের ঈমানের ক্ষতি না হয়।");
        arrayList.add(hashMap);

// Question 4
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের সাথে কিভাবে দাওয়াত বা ইসলামের প্রচার করতে হবে?");
        hashMap.put("Answer", "কাফেরদের সাথে দাওয়াত বা ইসলামের প্রচার করতে হবে। তাদেরকে ইসলামের সত্যতা ও সৌন্দর্য সম্পর্কে অবহিত করতে হবে। তাদের সাথে কথা বলার সময় নম্র ও শিষ্টাচার বজায় রাখতে হবে। তাদের সাথে তর্ক-বিতর্ক করা যাবে না।");
        arrayList.add(hashMap);

// Question 5
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের সাথে সম্পর্ক রাখা কি জায়েজ?");
        hashMap.put("Answer", "কাফেরদের সাথে সম্পর্ক রাখা জায়েজ। তবে তাদের কাছ থেকে আমাদের ঈমানের ক্ষতি হওয়ার আশঙ্কা থাকলে তাদের সাথে সম্পর্ক রাখা জায়েজ হবে না।");
        arrayList.add(hashMap);

// Question 6
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের সাথে বিয়ে করা কি জায়েজ?");
        hashMap.put("Answer", "কাফেরদের সাথে বিয়ে করা জায়েজ নয়। তবে কাফের পুরুষ মুসলিম নারীকে বিয়ে করতে পারবে, যদি সে ইসলাম গ্রহণ করে।");
        arrayList.add(hashMap);

// Question 7
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের সাথে ব্যবসা করা কি জায়েজ?");
        hashMap.put("Answer", "কাফেরদের সাথে ব্যবসা করা জায়েজ। তবে তাদের সাথে ব্যবসা করার সময় সতর্ক থাকতে হবে। যাতে জুলুম বা অত্যাচার না হয়।");
        arrayList.add(hashMap);


// Question 9
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের মৃত্যুতে দুঃখ প্রকাশ করা কি জায়েজ?");
        hashMap.put("Answer", "কাফেরদের মৃত্যুতে দুঃখ প্রকাশ করা জায়েজ নয়। তবে তাদের বিষয়ে অশ্লীল বা কটু কথা বলাও জায়েজ নয়।");
        arrayList.add(hashMap);

// Question 10
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের কবর জিয়ারত করা কি জায়েজ?");
        hashMap.put("Answer", "কাফেরদের কবর জিয়ারত করা জায়েজ নয়।");
        arrayList.add(hashMap);

// Question 11
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের জন্য দোয়া করা কি জায়েজ?");
        hashMap.put("Answer", "কাফেরদের জন্য দোয়া করা জায়েজ নয়।");
        arrayList.add(hashMap);

// Question 12
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের সাথে জিহাদ করা কি জায়েজ?");
        hashMap.put("Answer", "কাফেরদের সাথে জিহাদ করা জায়েজ। তবে জিহাদ করার বিধি-বিধান রয়েছে। সেগুলি অনুসরণ করতে হবে।");
        arrayList.add(hashMap);

// Question 13
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদেরকে ইসলামে দাওয়াত দেওয়া কি আমাদের কর্তব্য?");
        hashMap.put("Answer", "কাফেরদেরকে ইসলামে দাওয়াত দেওয়া আমাদের কর্তব্য। যাতে তারা সঠ্য পথে আসতে পারে।");
        arrayList.add(hashMap);

// Question 14
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের সাথে মুসলমানদের সম্পর্ক কেমন হওয়া উচিত?");
        hashMap.put("Answer", "কাফেরদের সাথে মুসলমানদের সম্পর্ক ন্যায়পরতার সম্পর্ক হওয়া উচিত। তাদের সাথে জুলুম বা অত্যাচার করা যাবে না। তবে তাদের সাথে বন্ধুত্ব করা বা তাদের সাথে মিশতে হলে সতর্ক থাকতে হবে। যাতে তাদের কথা ও কাজের দ্বারা আমাদের ঈমানের ক্ষতি না হয়।");
        arrayList.add(hashMap);

// Question 15
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের সম্পর্কে আল্লাহ কি বলেন?");
        hashMap.put("Answer", "আল্লাহ তা'আলা কাফেরদের সম্পর্কে কুরআনে বলেছেন, ‘কাফেররা তো তাদের অভিমানে ফেটে যাবে, যখন তারা জানতে পারবে যে, তাদের জন্য কোন অংশ নেই। বরং সর্বাবস্থায় আল্লাহই সর্বশ্রেষ্ঠ অধিকারী।’ (সুরা:সূরা বনী ইসরাইল, আয়াত: ১০) ");
        arrayList.add(hashMap);

// Question 16
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদেরকে ইসলামে দাওয়াত দেওয়ার সঠিক পদ্ধতি কী?");
        hashMap.put("Answer", "কাফেরদেরকে ইসলামে দাওয়াত দেওয়ার সঠিক পদ্ধতি হলো, তাদের সাথে নম্র ও শিষ্টাচার বজায় রাখা। তাদের সাথে তর্ক-বিতর্ক করা যাবে না। বরং ইসলামের সত্যতা ও সৌন্দর্য সম্পর্কে তাদেরকে অবহিত করতে হবে।");
        arrayList.add(hashMap);


// Question 17
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের জন্য কি কি দোয়া করা যায়?");
        hashMap.put("Answer", "কাফেরদের জন্য হেদায়েতের দোয়া করা যায়। অর্থাৎ, তাদের জন্য দোয়া করা যায় যাতে তারা সঠ্য পথে আসতে পারে। তাদের জন্য দোয়া করা যায় যাতে তারা ইসলাম গ্রহণ করে।");
        arrayList.add(hashMap);

// Question 18
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের সাথে খেলা-ধুলা করা কি জায়েজ?");
        hashMap.put("Answer", "কাফেরদের সাথে খেলা-ধুলা করা জায়েজ। তবে তাদের সাথে খেলা-ধুলা করার সময় সতর্ক থাকতে হবে। যাতে তাদের কথা ও কাজের দ্বারা আমাদের ঈমানের ক্ষতি না হয়।");
        arrayList.add(hashMap);

// Question 19
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের সাথে বন্ধুত্ব করা কি জায়েজ?");
        hashMap.put("Answer", "কাফেরদের সাথে বন্ধুত্ব করা জায়েজ নয়। তবে তাদের সাথে ব্যবসা বা অন্যান্য কাজকর্মের সম্পর্ক রাখা জায়েজ।");
        arrayList.add(hashMap);

// Question 20
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের সাথে লেনদেন করা কি জায়েজ?");
        hashMap.put("Answer", "কাফেরদের সাথে লেনদেন করা জায়েজ। তবে তাদের সাথে লেনদেন করার সময় সতর্ক থাকতে হবে। যাতে জুলুম বা অত্যাচার না হয়।");
        arrayList.add(hashMap);

// Question 21
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের সাথে রাজনৈতিক সম্পর্ক রাখা কি জায়েজ?");
        hashMap.put("Answer", "কাফেরদের সাথে রাজনৈতিক সম্পর্ক রাখা জায়েজ। তবে তাদের সাথে রাজনৈতিক সম্পর্ক রাখার সময় সতর্ক থাকতে হবে। যাতে মুসলিমদের ক্ষতি না হয়।");
        arrayList.add(hashMap);

// Question 22
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের সাথে যুদ্ধ করা কি জায়েজ?");
        hashMap.put("Answer", "কাফেরদের সাথে যুদ্ধ করা জায়েজ। তবে যুদ্ধ করার কিছু বিধি-বিধান রয়েছে। সেগুলি অনুসরণ করতে হবে।");
        arrayList.add(hashMap);

// Question 23
        hashMap = new HashMap<>();
        hashMap.put("Question", "কাফেরদের সাথে জিহাদ কেন করতে হয়?");
        hashMap.put("Answer", "কাফেরদের সাথে জিহাদ করতে হয় যাতে তারা মুসলমানদের উপর জুলুম ও অত্যাচার না করতে পারে। যাতে তারা মুসলিমদের দ্বীনকে ধ্বংস করতে না পারে। আর যাতে তারা সঠ্য পথে আসতে পারে।");
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
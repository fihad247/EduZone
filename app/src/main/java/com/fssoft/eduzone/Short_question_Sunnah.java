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

public class Short_question_Sunnah extends AppCompatActivity {


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
        hashMap.put("Question", "সুন্নত কাকে বলে?");
        hashMap.put("Answer", "সুন্নত হলো নবী মুহাম্মদ (সাঃ) এর কাজ, কথা ও স্বীকৃতি।");
        arrayList.add(hashMap);

// Question 2
        hashMap = new HashMap<>();
        hashMap.put("Question", "সুন্নতের গুরুত্ব কী?");
        hashMap.put("Answer", "সুন্নতের গুরুত্ব অপরিসীম। সুন্নত অনুসরণ করলে আমরা আল্লাহর সন্তুষ্টি লাভ করতে পারি এবং নবী মুহাম্মদের (সাঃ) শাফায়াত লাভ করতে পারি।");
        arrayList.add(hashMap);

// Question 3
        hashMap = new HashMap<>();
        hashMap.put("Question", "সুন্নতের প্রকারভেদ কী কী?");
        hashMap.put("Answer", "সুন্নতের দুইটি প্রকারভেদ রয়েছে:\n১. সুন্নত মুয়াক্কাদা\n২. সুন্নত গায়েের মুয়াক্কাদা");
        arrayList.add(hashMap);

// Question 4
        hashMap = new HashMap<>();
        hashMap.put("Question", "সুন্নত মুয়াক্কাদা কাকে বলে?");
        hashMap.put("Answer", "যে সুন্নত না করলে গুনাহ হয় কিন্তু কাফের হওয়া যায় না, তাকে সুন্নত মুয়াক্কাদা বলে।");
        arrayList.add(hashMap);

// Question 5
        hashMap = new HashMap<>();
        hashMap.put("Question", "সুন্নত গায়েের মুয়াক্কাদা কাকে বলে?");
        hashMap.put("Answer", "যে সুন্নত না করলে গুনাহ হয় না কিন্তু সুন্নত তরক করে রাখলে নেকি পাওয়া যায় না, তাকে সুন্নত গায়েের মুয়াক্কাদা বলে।");
        arrayList.add(hashMap);

// Question 6
        hashMap = new HashMap<>();
        hashMap.put("Question", "সুন্নতের উদাহরণ কী কী?");
        hashMap.put("Answer", "সুন্নতের উদাহরণ হলো: \nনবী মুহাম্মদের (সাঃ) এর মতো পোশাক পরা\nনবী মুহাম্মদের (সাঃ) এর মতো জুতা পরা\nনবী মুহাম্মদের (সাঃ) এর মতো চুল রাখা\nনবী মুহাম্মদের (সাঃ) এর মতো দাড়ি রাখা\nনবী মুহাম্মদের (সাঃ) এর মতো খাওয়া-দাওয়া করা \nনবী মুহাম্মদের (সাঃ) এর মতো ইবাদত করা"); arrayList.add(hashMap);
// Question 7
                hashMap = new HashMap<>();
        hashMap.put("Question", "সুন্নতের ফজিলত কী কী?");
        hashMap.put("Answer", "সুন্নতের ফজিলত অপরিসীম। সুন্নত অনুসরণ করলে আমরা আল্লাহর সন্তুষ্টি লাভ করতে পারি এবং নবী মুহাম্মদের (সাঃ) শাফায়াত লাভ করতে পারি। এছাড়াও সুন্নত অনুসরণ করলে আমাদের দুনিয়া-আখিরাতের জীবন সুন্দর হয়।");
        arrayList.add(hashMap);


// Question 9
        hashMap = new HashMap<>();
        hashMap.put("Question", "নবী মুহাম্মদ (সাঃ) এর সুন্নত অনুসরণ করার কি কি উপায় রয়েছে?");
        hashMap.put("Answer", "নবী মুহাম্মদ (সাঃ) এর সুন্নত অনুসরণ করার কি কি উপায় রয়েছে?\nনবী মুহাম্মদ (সাঃ) এর জীবনী অধ্যয়ন করা\nনবী মুহাম্মদ (সাঃ) এর হাদিস অধ্যয়ন করাn\nনবী মুহাম্মদ (সাঃ) এর সুন্নত অনুসরণ করা আলেমদের সাহচর্য করা"); arrayList.add(hashMap);
// Question 10
                hashMap = new HashMap<>();
        hashMap.put("Question", "সুন্নত অনুসরণ করার সময় কি কি বিষয়ে সতর্ক থাকতে হবে?");
        hashMap.put("Answer", "সুন্নত অনুসরণ করার সময় কি কি বিষয়ে সতর্ক থাকতে হবে?\nসুন্নতের ব্যাপারে নিজের অভিমান ত্যাগ করা\nসর্বদা দ্বীনদার আলেমদের মতামত নেওয়া\nসুন্নত অনুসরণ করার ক্ষেত্রে ইখলাস বজায় রাখা"); arrayList.add(hashMap);
// Question 11
                hashMap = new HashMap<>();
        hashMap.put("Question", "সুন্নত অনুসরণ করার সবচেয়ে বড় ফজিলত কী?");
        hashMap.put("Answer", "সুন্নত অনুসরণ করার সবচেয়ে বড় ফজিলত হলো আল্লাহর সন্তুষ্টি লাভ করা এবং জান্নাতে উচ্চ মর্যাদা লাভ করা।");
        arrayList.add(hashMap);


// Question 12
        hashMap = new HashMap<>();
        hashMap.put("Question", "সুন্নত অনুসরণ করার ক্ষেত্রে আমাদের উদ্দেশ্য কী হওয়া উচিত?");
        hashMap.put("Answer", "সুন্নত অনুসরণ করার ক্ষেত্রে আমাদের উদ্দেশ্য কী হওয়া উচিত?\nআল্লাহর সন্তুষ্টি লাভ করা\nনবী মুহাম্মদ (সাঃ) এর শাফায়াত লাভ করা\nজান্নাতে উচ্চ মর্যাদা লাভ করা"); arrayList.add(hashMap);
// Question 13
                hashMap = new HashMap<>();
        hashMap.put("Question", "সুন্নত অনুসরণ করার ক্ষেত্রে আমাদের কি কি বিষয় এড়িয়ে চলতে হবে?");
        hashMap.put("Answer", "সুন্নত অনুসরণ করার ক্ষেত্রে আমাদের কি কি বিষয় এড়িয়ে চলতে হবে?\nসুন্নতের ব্যাপারে নিজের অভিমান করা\nসর্বদা দ্বীনদার আলেমদের মতামত না নেওয়া\nসুন্নত অনুসরণ করার ক্ষেত্রে ইখলাস বজায় না রাখা"); arrayList.add(hashMap);
// Question 14
                hashMap = new HashMap<>();
        hashMap.put("Question", "সুন্নত অনুসরণ করার ক্ষেত্রে আমাদের সবচেয়ে বড় বাধা কী?");
        hashMap.put("Answer", "সুন্নত অনুসরণ করার ক্ষেত্রে আমাদের সবচেয়ে বড় বাধা হলো আমাদের নিজেদের নফস ও শয়তান।");
        arrayList.add(hashMap);

// Question 15
        hashMap = new HashMap<>();
        hashMap.put("Question", "সুন্নত অনুসরণ করার ক্ষেত্রে আমাদের কিভাবে সাহায্য নিতে হবে?");
        hashMap.put("Answer", "সুন্নত অনুসরণ করার ক্ষেত্রে আমাদের দ্বীনদার আলেমদের সাহাচর্য করতে হবে এবং তাদের মতামত নিতে হবে।");
        arrayList.add(hashMap);

// Question 16
        hashMap = new HashMap<>();
        hashMap.put("Question", "সুন্নত অনুসরণ করার ক্ষেত্রে আমাদের কোন দোয়া করতে হবে?");
        hashMap.put("Answer", "সুন্নত অনুসরণ করার ক্ষেত্রে আমাদের নিম্নলিখিত দোয়া করতে হবে:\nاللَّهُمَّ صَلِّ عَلَى مُحَمَّدٍ وَعَلَى آلِ مُحَمَّدٍ\n السُّنَّةَ وَالْجَمَاعَةَ\nوَاحْفُظْنَا مِنَ الْبِدْعَةِ وَالْفِرْقَةِ\nوَاجْعَلْنَا مِنَ الْمُهْتَدِينَ بِهُدْيِ نَبِيِّنَا مُحَمَّدٍ صَلَّى اللَّهُ عَلَيْهِ وَسَلَّمَ \n(অর্থ : হে আল্লাহ্, মুহাম্মদ (সাঃ) এর এবং মুহাম্মদের পরিবারের উপর দরূদ পাঠিয়ে তাদেরকে সুবহানাহু ওয়া তা'আলা রহমত করুন। আমাদেরকে সুন্নাহ ও জামা'আতের সৌভাগ্য দান করুন এবং বিদআত ও ফিরকা থেকে আমাদেরকে হেফাজত করুন। আমাদেরকে আমাদের নবী মুহাম্মদ (সাঃ) এর হেদায়েতের মাধ্যমে হেদায়েতপ্রাপ্তদের অন্তর্ভুক্ত");
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
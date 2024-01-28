package com.fssoft.eduzone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Tashbih_List extends AppCompatActivity {


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;
    TextView subhanallah_count, alhamdulillah_count, allahuakbar_count, astagfirulllah_count;
    ImageView list_back;
    LinearLayout subhanallah, alhamdulillah, allahuakbar, astagfirulllah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tashbih_list);



        //---Status Bar Color------------
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }


        subhanallah = findViewById(R.id.subhanallah);
        alhamdulillah = findViewById(R.id.alhamdulillah);
        allahuakbar = findViewById(R.id.allahuakbar);
        astagfirulllah = findViewById(R.id.astagfirulllah);

        subhanallah_count = findViewById(R.id.subhanallah_count);
        alhamdulillah_count = findViewById(R.id.alhamdulillah_count);
        allahuakbar_count = findViewById(R.id.allahuakbar_count);
        astagfirulllah_count = findViewById(R.id.astagfirulllah_count);

        list_back = findViewById(R.id.list_back);


        sharedPreferences = Tashbih_List.this.getSharedPreferences(getString(R.string.app_name) , MODE_PRIVATE);
        editor = sharedPreferences.edit();


        String save_subhanallah = sharedPreferences.getString("save_subhanallah", "0");
        String save_alhamdulillah = sharedPreferences.getString("save_alhamdulillah", "0");
        String save_allahuakbar = sharedPreferences.getString("save_allahuakbar", "0");
        String save_astagfirulllah = sharedPreferences.getString("save_astagfirulllah", "0");

        subhanallah_count.setText("" +save_subhanallah);
        alhamdulillah_count.setText("" +save_alhamdulillah);
        allahuakbar_count.setText("" +save_allahuakbar);
        astagfirulllah_count.setText("" +save_astagfirulllah);

        //Toast.makeText(getActivity(), "Save Data "+save_count, Toast.LENGTH_SHORT).show();

        list_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Go to the previous message fragment activity
                finish();


            }
        });

        alhamdulillah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Digital_Tashbih.counter_name = "alhamdulillah";

                Intent intent = new Intent(Tashbih_List.this, Digital_Tashbih.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }
        });
        subhanallah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 Digital_Tashbih.counter_name = "subhanallah";

                Intent intent = new Intent(Tashbih_List.this, Digital_Tashbih.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }
        });
        allahuakbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Digital_Tashbih.counter_name = "allahuakbar";

                Intent intent = new Intent(Tashbih_List.this, Digital_Tashbih.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }
        });
        astagfirulllah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Digital_Tashbih.counter_name = "astagfirulllah";

                Intent intent = new Intent(Tashbih_List.this, Digital_Tashbih.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }
        });


    }  //---------last bracket start -----------------




}  //----last bracket ends -------------------
package com.fssoft.eduzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Digital_Tashbih extends AppCompatActivity {


    int limit = 33;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;
    MediaPlayer mediaPlayer;
    TextView text_tasbih_dispaly, txt_counter_name;
    public static String counter = " ";
    public static String counter_name = " ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_tashbih);

        text_tasbih_dispaly = findViewById(R.id.text_tasbih);
        txt_counter_name = findViewById(R.id.txt_counter_name);

        LinearLayout btn_jog = findViewById(R.id.btn_jog);
        ImageView btn_biyog = findViewById(R.id.btn_biyog);
        ImageView btn_reseat =findViewById(R.id.btn_reseat);
        ImageView btn_tashbih_list = findViewById(R.id.btn_tashbih_list);


        //---Status Bar Color------------
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }


        sharedPreferences = Digital_Tashbih.this.getSharedPreferences(getString(R.string.app_name) , MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if ( counter_name=="alhamdulillah") {

            String save_alhamdulillah = sharedPreferences.getString("save_alhamdulillah", "0");

            text_tasbih_dispaly.setText(save_alhamdulillah);
            txt_counter_name.setText("সুবহা-নাল্লাহ");

        } else if (counter_name == "subhanallah") {

            String save_subhanallah = sharedPreferences.getString("save_subhanallah", "0");

            text_tasbih_dispaly.setText(save_subhanallah);
            txt_counter_name.setText("আল-হামদুলিল্লাহ্");

        } else if (counter_name == "allahuakbar") {

            String save_subhanallah = sharedPreferences.getString("save_allahuakbar", "0");

            text_tasbih_dispaly.setText(save_subhanallah);
            txt_counter_name.setText("আল্লাহু আকবার");

        } else if (counter_name == "astagfirulllah") {

            String save_subhanallah = sharedPreferences.getString("save_astagfirulllah", "0");

            text_tasbih_dispaly.setText(save_subhanallah);
            txt_counter_name.setText("আস্তাগফিরুল্লা-হ");

        } else {
            text_tasbih_dispaly.setText(""+1);
        }


        btn_jog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txt = text_tasbih_dispaly.getText().toString();
                int count = Integer.parseInt(txt);

                count = count + 1;
                text_tasbih_dispaly.setText("" +count);

                if (limit==count){
                    count=0;
                    text_tasbih_dispaly.setText("" +count);

                    mediaPlayer = MediaPlayer.create(Digital_Tashbih.this,R.raw.finish);
                    mediaPlayer.start();
                }

                editor.putString("save_"+counter_name , ""+count);
                editor.apply();

            }
        });

        btn_biyog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txt = text_tasbih_dispaly.getText().toString();
                int count = Integer.parseInt(txt);

                if (count==0){
                    count = 0;
                }else {
                    count = count - 1;
                    text_tasbih_dispaly.setText("" +count);
                }

                editor.putString("save_"+counter_name , ""+count);
                editor.apply();

            }
        });

        btn_reseat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txt = text_tasbih_dispaly.getText().toString();
                int count = Integer.parseInt(txt);

                count = 0;
                text_tasbih_dispaly.setText("" +count);

                editor.putString("save_"+counter_name , ""+count);
                editor.apply();

            }
        });

        btn_tashbih_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Digital_Tashbih.this,Tashbih_List.class);
                startActivity(myIntent);
            }
        });


    }
}
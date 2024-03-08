package com.fssoft.eduzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class Chat_Dashbord extends AppCompatActivity {

    ListView my_list_View;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText ed_message_box;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_dashbord);

        my_list_View = findViewById(R.id.listView_chat_dashbord);


        progressBar = findViewById(R.id.progressBar_post);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name) , MODE_PRIVATE);
        editor = sharedPreferences.edit();

        //-----load Message---------------
       // loadMessage();


    }
    //----------last bracket Start----------------------

    //---------Adaptar----------
    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View my_View = layoutInflater.inflate(R.layout.listview_chat_dashbord, null);

            TextView tv_name = my_View.findViewById(R.id.tv_name);
            TextView tv_last_message = my_View.findViewById(R.id.tv_last_message);
            TextView tv_time = my_View.findViewById(R.id.tv_time);
            CircleImageView circleImageView1 = my_View.findViewById(R.id.img_CircleImageView1);
            CircleImageView circleImageView2 = my_View.findViewById(R.id.img_CircleImageView2);
            LinearLayout listview_chat_dashbord = my_View.findViewById(R.id.listview_chat_dashbord);


            hashMap = arrayList.get(i);
            String GEt_id = hashMap.get("Get_id");
            String GEt_sender_id = hashMap.get("Get_sender_id");
            String GEt_receiver_id = hashMap.get("Get_receiver_id");
            String GEt_message = hashMap.get("Get_message");
            String Get_last_message_Time = hashMap.get("Get_last_message_Time");
            String Get_recever_Name = hashMap.get("Get_recever_Name");
            String Get_recever_profile_image_url = hashMap.get("Get_recever_profile_image_url");

            // Display data
            tv_name.setText(Get_recever_Name);
            tv_last_message.setText(GEt_message);
            tv_time.setText("    " +Get_last_message_Time);

        //    String GeT_img_user_profile_image = sharedPreferences.getString("Get_recever_profile_image_url", "null");

            // Load image from Hosting File
            Picasso.get()
                    .load("http://fssoft.xyz/rgc/image/" + Get_recever_profile_image_url) // Replace with your API endpoint
                    .placeholder(R.drawable.dummy_profile_image) // Optional placeholder
                    .error(R.drawable.dummy_profile_image) // Optional error image
                    .into(circleImageView1);

            listview_chat_dashbord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Chat.chat_Recever_id = GEt_receiver_id;
                    Chat.chat_Recever_name = Get_recever_Name;
                    Chat.chat_Recever_profile_image_url = Get_recever_profile_image_url;
                    startActivity(new Intent(Chat_Dashbord.this, Chat.class));

                }
            });



            return my_View;
        }
    }

    //-----------Load Message Data Json Aray List-----------
    private void loadMessage() {

        arrayList = new ArrayList<>();

        String uuserid = sharedPreferences.getString("profile_id", "null");

        String api_url = getString(R.string.api_url);
        String uurl = api_url + "/rgc/chatdashboard.php?si="+uuserid+"&ri="+uuserid;
        RequestQueue requestQueue3 = Volley.newRequestQueue(Chat_Dashbord.this);
        progressBar.setVisibility(View.VISIBLE);

        JsonArrayRequest jsonArrayRequest3 = new JsonArrayRequest(Request.Method.GET, uurl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);


                for (int x = 0; x < response.length(); x++) {

                    try {

                        JSONObject jsonObject = response.getJSONObject(x);
                        String Get_id = jsonObject.getString("id");
                        String Get_sender_id = jsonObject.getString("participant1");
                        String Get_receiver_id = jsonObject.getString("participant2");
                        String Get_message = jsonObject.getString("message");
                        String Get_last_message_Time = jsonObject.getString("time");
                        String Get_recever_Name = jsonObject.getString("name");
                        String Get_recever_profile_image_url = jsonObject.getString("profile_image_url");

                        hashMap = new HashMap<>();
                        hashMap.put("Get_id", Get_id);
                        hashMap.put("Get_sender_id", Get_sender_id);
                        hashMap.put("Get_receiver_id", Get_receiver_id);
                        hashMap.put("Get_message", Get_message);
                        hashMap.put("Get_last_message_Time", Get_last_message_Time);
                        hashMap.put("Get_recever_Name", Get_recever_Name);
                        hashMap.put("Get_recever_profile_image_url", Get_recever_profile_image_url);
                        arrayList.add(hashMap);

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                //==============================
                if (arrayList.size() > 0) {
                    MyAdapter myadapter5 = new MyAdapter();
                    my_list_View.setAdapter(myadapter5);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.d("ServerRes", error.toString());

            }
        });

        requestQueue3.add(jsonArrayRequest3);


    }

    
    // load message when I back chat to chatDashbord
    @Override
    protected void onPostResume() {
        super.onPostResume();
        // Load Message
        loadMessage();
    }

    //----------last bracket ends-----------------------
}
package com.fssoft.eduzone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class Chat extends AppCompatActivity {


    ListView my_list_View;
    RecyclerView recyclerView;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText ed_message_box;
    ImageView img_message_send_button;
    ProgressBar progressBar;
    LottieAnimationView lottieAnimationView;
    public static  String chat_Recever_id = "";
    public static  String chat_Recever_name = "";
    public static  String chat_Recever_profile_image_url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        my_list_View = findViewById(R.id.historylistView);
        ed_message_box = findViewById(R.id.ed_message_box);
        img_message_send_button = findViewById(R.id.img_message_send_button);
        progressBar = findViewById(R.id.progressBar_post);
        CircleImageView circleImageView = findViewById(R.id.img_CircleImageView_Recever_image);
        TextView tv_Recever_name = findViewById(R.id.tv_Recever_name);


         sharedPreferences = getSharedPreferences(getString(R.string.app_name) , MODE_PRIVATE);
        editor = sharedPreferences.edit();

        //-----load Message---------------
        loadMessage();


        // Load image from Hosting File
        Picasso.get()
                .load("http://fssoft.xyz/rgc/image/" + chat_Recever_profile_image_url) // Replace with your API endpoint
                .placeholder(R.drawable.dummy_profile_image) // Optional placeholder
                .error(R.drawable.dummy_profile_image) // Optional error image
                .into(circleImageView);

        img_message_send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String GeT_sender_Id =  sharedPreferences.getString("profile_id", "0");

                String GeT_ed_message_text = ed_message_box.getText().toString();

                String api_url = getString(R.string.api_url);
                String url = api_url + "/rgc/sendmessage.php?sid="+GeT_sender_Id+"&rid="+chat_Recever_id+"&m="+GeT_ed_message_text;

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        if (response.equals("sent")){

                            // Clear the EditText text
                           // ed_message_box.setText("");
                            Editable text = ed_message_box.getText();
                            text.clear();


                            //-----load Message---------------
                            loadMessage();
                            Toast.makeText(Chat.this, " "+response, Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Chat.this, " else "+response, Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(Chat.this, "NO Response ER", Toast.LENGTH_SHORT).show();

                    }
                });

                RequestQueue requestQueue = Volley.newRequestQueue(Chat.this);
                requestQueue.add(stringRequest);

            }
        });


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
            View my_View = layoutInflater.inflate(R.layout.listview_chat, null);

            String uuserid = sharedPreferences.getString("profile_id", "null");

            TextView tv_chat_message = my_View.findViewById(R.id.tv_chat_message);
            TextView tv_chat_time = my_View.findViewById(R.id.tv_chat_time);
            LinearLayout layout_chat = my_View.findViewById(R.id.layout_chat);
            CircleImageView img_CircleImageView_chat = my_View.findViewById(R.id.img_CircleImageView_chat);

            hashMap = arrayList.get(i);
            String GEt_id = hashMap.get("Get_id");
            String GEt_sender_id = hashMap.get("Get_sender_id");
            String GEt_receiver_id = hashMap.get("Get_receiver_id");
            String GEt_message = hashMap.get("Get_message");
            String Get_timE = hashMap.get("Get_timE");

            tv_chat_message.setText(GEt_message);
            tv_chat_time.setText("  " +Get_timE);

            // Load image from Hosting File
            Picasso.get()
                    .load("http://fssoft.xyz/rgc/image/" + chat_Recever_profile_image_url) // Replace with your API endpoint
                    .placeholder(R.drawable.dummy_profile_image) // Optional placeholder
                    .error(R.drawable.baseline_person) // Optional error image
                    .into(img_CircleImageView_chat);

            if (GEt_sender_id.equals(uuserid)) {
                layout_chat.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                img_CircleImageView_chat.setVisibility(View.GONE);
            }

            return my_View;
        }
    }

    //-----------Load Message Data Json Aray List-----------
    private void loadMessage() {

        arrayList = new ArrayList<>();

        String uuserid = sharedPreferences.getString("profile_id", "null");

        String api_url = getString(R.string.api_url);
        String uurl = api_url + "/rgc/chat.php?si="+uuserid+"&ri="+chat_Recever_id;
        RequestQueue requestQueue3 = Volley.newRequestQueue(Chat.this);
        progressBar.setVisibility(View.VISIBLE);

        JsonArrayRequest jsonArrayRequest3 = new JsonArrayRequest(Request.Method.GET, uurl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                 progressBar.setVisibility(View.GONE);


                for (int x = 0; x < response.length(); x++) {

                    try {

                        JSONObject jsonObject = response.getJSONObject(x);
                        String Get_id = jsonObject.getString("id");
                        String Get_sender_id = jsonObject.getString("sender_id");
                        String Get_receiver_id = jsonObject.getString("receiver_id");
                        String Get_message = jsonObject.getString("message");
                        String Get_timE = jsonObject.getString("time");

                        hashMap = new HashMap<>();
                        hashMap.put("Get_id", Get_id);
                        hashMap.put("Get_sender_id", Get_sender_id);
                        hashMap.put("Get_receiver_id", Get_receiver_id);
                        hashMap.put("Get_message", Get_message);
                        hashMap.put("Get_timE", Get_timE);
                        arrayList.add(hashMap);

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                //==============================
                if (arrayList.size() > 0) {
                    MyAdapter myadapter3 = new MyAdapter();
                    my_list_View.setAdapter(myadapter3);
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

    //----------last bracket ends-----------------------
}
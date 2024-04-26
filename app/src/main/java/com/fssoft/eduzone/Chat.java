package com.fssoft.eduzone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
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
    MyAdapter myadapter3;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText ed_message_box;
    ImageView img_message_send_button;
    ProgressBar progressBar;
    LottieAnimationView lottieAnimationView;
    public static  String chat_Recever_id = "";
    public static  String chat_Recever_name = "";
    public static  String chat_Recever_profile_image_url = "";
    // Handler for periodic message loading
    private final Handler messageHandler = new Handler();
    private final int MESSAGE_LOAD_INTERVAL = 30000; // 30 seconds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //-------- set StatusBar Color  --------
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(R.color.deepyellow));
        }


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
        // Start periodic message loading
       // startPeriodicMessageLoading();


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

                if (TextUtils.isEmpty(GeT_ed_message_text)) {
                    ed_message_box.setError("Please white something..");
                    return;
                }

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

            TextView tv_message_left = my_View.findViewById(R.id.tv_message_left);
            TextView tv_message_right = my_View.findViewById(R.id.tv_message_right);
            TextView tv_chat_time = my_View.findViewById(R.id.tv_chat_time);
            LinearLayout layout_chat = my_View.findViewById(R.id.layout_chat);
            CircleImageView img_CircleImageView_chat = my_View.findViewById(R.id.img_CircleImageView_chat);

            hashMap = arrayList.get(i);
            String GEt_id = hashMap.get("Get_id");
            String GEt_sender_id = hashMap.get("Get_sender_id");
            String GEt_receiver_id = hashMap.get("Get_receiver_id");
            String GEt_message = hashMap.get("Get_message");
            String Get_timE = hashMap.get("Get_timE");

            if (GEt_sender_id.equals(uuserid)) {
                tv_message_right.setText(GEt_message);
                img_CircleImageView_chat.setVisibility(View.GONE);
                tv_message_left.setVisibility(View.GONE);
            }else {
                tv_message_left.setText(GEt_message);
                tv_message_right.setVisibility(View.GONE);
            }
            tv_chat_time.setText("  " +Get_timE);

            // Load image from Hosting File
            Picasso.get()
                    .load("http://fssoft.xyz/rgc/image/" + chat_Recever_profile_image_url) // Replace with your API endpoint
                    .placeholder(R.drawable.dummy_profile_image) // Optional placeholder
                    .error(R.drawable.baseline_person) // Optional error image
                    .into(img_CircleImageView_chat);



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
      //  progressBar.setVisibility(View.VISIBLE);

        ArrayList<HashMap<String, String>> newMessages = new ArrayList<>(); // New messages received from the server
        JsonArrayRequest jsonArrayRequest3 = new JsonArrayRequest(Request.Method.GET, uurl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
               //  progressBar.setVisibility(View.GONE);


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

                    // Add new messages to the existing list
                    arrayList.addAll(newMessages);

                    // Notify adapter about the changes
                    myadapter3.notifyDataSetChanged();

                }

                // Scroll ListView to the last item
                my_list_View.post(new Runnable() {
                    @Override
                    public void run() {
                       // my_list_View.setSelection(myadapter3.getCount() - 1);
                        my_list_View.smoothScrollToPosition(arrayList.size() - 1);

                    }
                });


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.d("ServerRes", error.toString());

            }
        });

        requestQueue3.add(jsonArrayRequest3);


    }


    // Method to start periodic message loading
    private void startPeriodicMessageLoading() {
        messageHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                loadMessage(); // Load messages
                messageHandler.postDelayed(this, MESSAGE_LOAD_INTERVAL);  // Schedule next execution
            }
        }, MESSAGE_LOAD_INTERVAL);
    }

    // Method to stop periodic message loading
    private void stopPeriodicMessageLoading() {
        messageHandler.removeCallbacksAndMessages(null); // Remove any pending callbacks
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopPeriodicMessageLoading(); // Stop periodic message loading when activity is destroyed
    }

    //----------last bracket ends-----------------------
}
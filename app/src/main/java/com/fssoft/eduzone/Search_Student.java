package com.fssoft.eduzone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

public class Search_Student extends AppCompatActivity {

    EditText edtext_search_student;
    ListView listView_chat_search;
    Button btn_search_student;
    ProgressBar progressBar_chat_search;
    SharedPreferences sharedPreferences;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_student);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //-------- set StatusBar Color  --------
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }


        edtext_search_student = findViewById(R.id.edtext_search_student);
        listView_chat_search = findViewById(R.id.listView_chat_search);
        btn_search_student = findViewById(R.id.btn_search_student);
        progressBar_chat_search = findViewById(R.id.progressBar_chat_search);

        edtext_search_student.requestFocus();

        btn_search_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                progressBar_chat_search.setVisibility(View.VISIBLE);
                arrayList = new ArrayList<>();

                String search_text = edtext_search_student.getText().toString().trim();
                String api_url = getString(R.string.api_url);
                String url = api_url + "/rgc/searchstudent.php?sq=" + search_text;

                RequestQueue requestQueue = Volley.newRequestQueue(Search_Student.this);

                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {

                        progressBar_chat_search.setVisibility(View.GONE);
                        // Log success message
                        Log.d("Volley Response", "Success: " + jsonArray.toString());

                        for (int x = 0; x < jsonArray.length(); x++) {
                            try {

                                JSONObject jsonObject = jsonArray.getJSONObject(x);
                                String Get_id = jsonObject.getString("id");
                                String Get_name = jsonObject.getString("name");
                                String Get_profile_image_url = jsonObject.getString("profile_image_url");
                                String Get_address = jsonObject.getString("address");

                                hashMap = new HashMap<>();
                                hashMap.put("Get_id", Get_id);
                                hashMap.put("Get_name", Get_name);
                                hashMap.put("Get_profile_image_url", Get_profile_image_url);
                                hashMap.put("Get_address", Get_address);
                                arrayList.add(hashMap);


                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        //==============================
                        if (arrayList.size() > 0) {
                            MyAdapter myAdapter = new MyAdapter();
                            listView_chat_search.setAdapter(myAdapter);
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                });

                requestQueue.add(jsonArrayRequest);

            }
        });



    }
    ///////////////////

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View myview = layoutInflater.inflate(R.layout.listview_search_people, null);

            TextView tv_name = myview.findViewById(R.id.tv_search_name);
            TextView tv_address = myview.findViewById(R.id.tv_address);
            CircleImageView profile_img = myview.findViewById(R.id.img_CircleImageView_Search);
            LinearLayout linearLayout = myview.findViewById(R.id.linear_layout_search);

            hashMap = arrayList.get(i);
            String GEt_id = hashMap.get("Get_id");
            String GEt_name = hashMap.get("Get_name");
            String GEt_address = hashMap.get("Get_address");
            String GEt_profile_image_url = hashMap.get("Get_profile_image_url");

            tv_name.setText(GEt_name);
            tv_address.setText(GEt_address);

            // Load image from Hosting File
            Picasso.get()
                    .load("http://fssoft.xyz/rgc/image/" + GEt_profile_image_url) // Replace with your API endpoint
                    .placeholder(R.drawable.dummy_profile_image) // Optional placeholder
                    .error(R.drawable.baseline_person) // Optional error image
                    .into(profile_img);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Chat.chat_Recever_id = GEt_id;
                    Chat.chat_Recever_name = GEt_name;
                    Chat.chat_Recever_profile_image_url = GEt_profile_image_url;
                    startActivity(new Intent(Search_Student.this, Chat.class));

                }
            });

            return myview;
        }
    }
    /////////////////////
}
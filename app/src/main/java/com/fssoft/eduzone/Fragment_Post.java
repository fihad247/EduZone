package com.fssoft.eduzone;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Post extends Fragment {

    ListView my_list_View;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    SharedPreferences.Editor editor;
    ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_post, container, false);


        my_list_View = myView.findViewById(R.id.list_View_post);
        progressBar = myView.findViewById(R.id.progressBar_post);
        Button btn_post_submit = myView.findViewById(R.id.btn_post_submit);
        Button btn_post_cancel = myView.findViewById(R.id.btn_post_cancel);
        EditText edit_text_post = myView.findViewById(R.id.edit_text_post);
        RelativeLayout relativeLayout_post_view = myView.findViewById(R.id.relativeLayout_post_view);
        RelativeLayout relativeLayout_post_add = myView.findViewById(R.id.relativeLayout_post_add);
        FloatingActionButton floatingActionButton_post_add = myView.findViewById(R.id.post_add);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        relativeLayout_post_view.setVisibility(View.VISIBLE);

        //-----load Post---------------
        loadPost();

        //add Post in server
        floatingActionButton_post_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                relativeLayout_post_add.setVisibility(View.VISIBLE);
                relativeLayout_post_view.setVisibility(View.GONE);

                btn_post_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        progressBar.setVisibility(View.VISIBLE);

                        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(edit_text_post.getWindowToken(), 0);

                        String GeT_post_user_Id = sharedPreferences.getString("profile_id", "0");

                        String GeT_edit_text_post = edit_text_post.getText().toString();

                        String api_url = getString(R.string.api_url);
                        String url = api_url + "/rgc/postadd.php?puid=" + GeT_post_user_Id + "&p=" + GeT_edit_text_post;

                        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {


                                if (response.equals("post")) {

                                    // Clear the EditText text
                                    // ed_message_box.setText("");
                                    Editable text = edit_text_post.getText();
                                    text.clear();

                                    relativeLayout_post_view.setVisibility(View.VISIBLE);
                                    relativeLayout_post_add.setVisibility(View.GONE);
                                    progressBar.setVisibility(View.GONE);

                                    //-----load Post---------------
                                    loadPost();

                                    Toast.makeText(getActivity(), " " + response, Toast.LENGTH_SHORT).show();
                                } else {
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(getActivity(), " else " + response, Toast.LENGTH_SHORT).show();
                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();

                            }
                        });

                        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                        requestQueue.add(stringRequest);


                    }
                });

                btn_post_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        relativeLayout_post_add.setVisibility(View.GONE);
                        relativeLayout_post_view.setVisibility(View.VISIBLE);
                    }
                });

            }
        });


        return myView;


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
            View my_View = layoutInflater.inflate(R.layout.listview_post, null);

            TextView tv_post_user_name = my_View.findViewById(R.id.tv_post_user_name);
            TextView tv_post_time = my_View.findViewById(R.id.tv_post_time);
            TextView tv_post = my_View.findViewById(R.id.tv_post);
            TextView tv_like = my_View.findViewById(R.id.tv_like);
            TextView tv_comment = my_View.findViewById(R.id.tv_comment);
            CircleImageView img_CircleImageView_profile = my_View.findViewById(R.id.img_CircleImageView_profile);

            ImageView img_like = my_View.findViewById(R.id.img_like);
            LinearLayout layout_like = my_View.findViewById(R.id.layout_like);
            LinearLayout layout_comment = my_View.findViewById(R.id.layout_comment);



            hashMap = arrayList.get(i);
            String GEt_id = hashMap.get("Get_id");
            String Get_post_user_id = hashMap.get("Get_post_user_id");
            String Get_user_name = hashMap.get("Get_user_name");
            String Get_post = hashMap.get("Get_post");
            String Get_time = hashMap.get("Get_time");
            String Get_profile_image_url = hashMap.get("Get_profile_image_url");
            String Get_like_count = hashMap.get("Get_like_count");
            String Get_postlike_status = hashMap.get("Get_postlike_status");

            Log.d(TAG, "Like Count: " + Get_postlike_status);


            // tv_post_user_name.setText(""+Get_post_user_id);
            tv_post_user_name.setText("" + Get_user_name);
            tv_post_time.setText("" + Get_time);
            tv_post.setText("" + Get_post);
            tv_like.setText(" " + Get_like_count);

            if (Get_postlike_status.equals("liked")) {
                img_like.setImageResource(R.drawable.img_like_green);
            }

            // Load image from Hosting File
            Picasso.get()
                    .load("http://fssoft.xyz/rgc/image/"+Get_profile_image_url) // Replace with your API endpoint
                    .placeholder(R.drawable.dummy_profile_image) // Optional placeholder
                    .error(R.drawable.baseline_person) // Optional error image
                    .into(img_CircleImageView_profile);

            SharedPreferences Preferences = getActivity().getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
            editor = Preferences.edit();

            // like system
            layout_like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String GeT_user_Id = Preferences.getString("profile_id", "0");

                    String api_url = getString(R.string.api_url);
                    String url = api_url + "/rgc/like.php?uid=" + GeT_user_Id + "&pid=" + GEt_id;


                    //--------------------
                    // Create a queue and request object
                    RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,url, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            for (int x=0; x<response.length(); x++){

                                try {

                                    JSONObject jsonObject = response.getJSONObject(x);
                                    String likeCount = jsonObject.getString("like_count");
                                    String likeStatus = jsonObject.getString("like_status");

                                   Log.d(TAG, "Like Status: " + likeStatus);
                                    Log.d(TAG, "Like Count: " + likeCount);

                                    if (likeStatus.equals("liked")) {
                                        tv_like.setText(" "+likeCount);
                                        img_like.setImageResource(R.drawable.img_like_green);
                                    } else if (likeStatus.equals("unliked")) {
                                        tv_like.setText(" "+likeCount);
                                        img_like.setImageResource(R.drawable.img_like);
                                    }

                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            //==============================
                            //==============================

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //Log.d("ServerRes", error.toString());
                            Toast.makeText(getActivity(), "VolleyError", Toast.LENGTH_SHORT).show();

                        }
                    });

                    requestQueue.add(jsonArrayRequest);




                }
            });

            layout_comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "আপনার কমেন্ট করার বয়স হয়নি \uD83D\uDE02", Toast.LENGTH_SHORT).show();
                }
            });

            return my_View;
        }
    }

    //-----------Load Post Data Json Aray List-----------
    private void loadPost() {

        arrayList = new ArrayList<>();

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        String GET_post_user_Id = sharedPreferences.getString("profile_id", "0");
        String api_url = getString(R.string.api_url);
        String uurl = api_url + "/rgc/post.php?uid="+GET_post_user_Id;
        RequestQueue requestQueue6 = Volley.newRequestQueue(getActivity());

        progressBar.setVisibility(View.VISIBLE);

        JsonArrayRequest jsonArrayRequest3 = new JsonArrayRequest(Request.Method.GET, uurl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);


                for (int x = 0; x < response.length(); x++) {

                    try {

                        //  Toast.makeText(Chat.this, "555", Toast.LENGTH_SHORT).show();

                        JSONObject jsonObject = response.getJSONObject(x);
                        String Get_id = jsonObject.getString("id");
                        String Get_post_user_id = jsonObject.getString("post_user_id");
                        String Get_user_name = jsonObject.getString("name");
                        String Get_post = jsonObject.getString("post");
                        String Get_time = jsonObject.getString("time");
                        String Get_profile_image_url = jsonObject.getString("profile_image_url");
                        String Get_like_count = jsonObject.getString("like_count");
                        String Get_postlike_status = jsonObject.getString("postlike_status");

                        hashMap = new HashMap<>();
                        hashMap.put("Get_id", Get_id);
                        hashMap.put("Get_post_user_id", Get_post_user_id);
                        hashMap.put("Get_user_name", Get_user_name);
                        hashMap.put("Get_post", Get_post);
                        hashMap.put("Get_time", Get_time);
                        hashMap.put("Get_profile_image_url", Get_profile_image_url);
                        hashMap.put("Get_like_count", Get_like_count);
                        hashMap.put("Get_postlike_status", Get_postlike_status);
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

        requestQueue6.add(jsonArrayRequest3);


    }



//----------last bracket ends-----------------------

}
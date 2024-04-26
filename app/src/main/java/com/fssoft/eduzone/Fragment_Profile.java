package com.fssoft.eduzone;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;


public class Fragment_Profile extends Fragment {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private TextView tv_user_name, tv_user_name2, tv_user_mobile, tv_user_email, tv_user_address, tv_user_education, tv_user_age, tv_user_gender;
    private CircleImageView img_user_profile_image, img_user_profile_image2;
    private ProgressBar progressBar;
    private TextInputEditText ed_profile_Name, ed_profile_Mobile, ed_profile_Email, ed_profile_Age , ed_profile_Gender, ed_profile_Address, ed_profile_Education ;
    private Button btn_profile_update, btn_profile_cansel ;
    Bitmap bitmap;
    String encodeImageString;
    String BASE_API_URL = "http://www.fssoft.xyz/rgc/profileupdate.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_profile, container, false);

        // Access SharedPreferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        tv_user_name = myView.findViewById(R.id.tv_user_name);
        tv_user_name2 = myView.findViewById(R.id.tv_user_name2);
        tv_user_mobile = myView.findViewById(R.id.tv_user_mobile);
        tv_user_email = myView.findViewById(R.id.tv_user_email);
        tv_user_age = myView.findViewById(R.id.tv_user_age);
        tv_user_gender = myView.findViewById(R.id.tv_user_gender);
        tv_user_address = myView.findViewById(R.id.tv_user_address);
        tv_user_education = myView.findViewById(R.id.tv_user_education);
        img_user_profile_image = myView.findViewById(R.id.img_user_profile_image);
        img_user_profile_image2 = myView.findViewById(R.id.img_user_profile_image2);
        FloatingActionButton floatingActionButton = myView.findViewById(R.id.profile_edit);

        RelativeLayout profile_View = myView.findViewById(R.id.layout_profile_view);
        LinearLayout profile_edit = myView.findViewById(R.id.layout_profile_edit);

         ed_profile_Name = myView.findViewById(R.id.ed_profile_Name);
         ed_profile_Mobile = myView.findViewById(R.id.ed_profile_Mobile);
         ed_profile_Email = myView.findViewById(R.id.ed_profile_Email);
         ed_profile_Age = myView.findViewById(R.id.ed_profile_Age);
         ed_profile_Gender = myView.findViewById(R.id.ed_profile_Gender);
         ed_profile_Address = myView.findViewById(R.id.ed_profile_Address);
         ed_profile_Education = myView.findViewById(R.id.ed_profile_Education);
         btn_profile_update = myView.findViewById(R.id.btn_profile_update);
         btn_profile_cansel = myView.findViewById(R.id.btn_profile_cansel);
         progressBar = myView.findViewById(R.id.progressBar_profle_udate);

        String GeT_name = sharedPreferences.getString("name", " ");
        String GeT_userphone = sharedPreferences.getString("userphone", " ");
        String GeT_email = sharedPreferences.getString("email", " ");
        String GeT_age = sharedPreferences.getString("age", " ");
        String GeT_gender = sharedPreferences.getString("gender", " ");
        String GeT_address = sharedPreferences.getString("address", " ");
        String GeT_education = sharedPreferences.getString("education", " ");

        // Display All Data
        tv_user_name.setText(GeT_name);
        tv_user_name2.setText(GeT_name);
        tv_user_mobile.setText(GeT_userphone);
        tv_user_email.setText(GeT_email);
        tv_user_age.setText(GeT_age);
        tv_user_gender.setText(GeT_gender);
        tv_user_address.setText(GeT_address);
        tv_user_education.setText(GeT_education);

        String GeT_img_user_profile_image = sharedPreferences.getString("profile_image_url", " ");

        // Load image from Hosting File
        Picasso.get()
                .load("http://fssoft.xyz/rgc/image/" + GeT_img_user_profile_image) // Replace with your API endpoint
                .placeholder(R.drawable.dummy_profile_image) // Optional placeholder
                .error(R.drawable.baseline_person) // Optional error image
                .into(img_user_profile_image);

        //----  Load Profile data
        load_Profile_data();


        // VISIBLE Proflie edit
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String GeT_img_user_profile_image = sharedPreferences.getString("profile_image_url", " ");

                // Load image from Hosting File
                Picasso.get()
                        .load("http://fssoft.xyz/rgc/image/" + GeT_img_user_profile_image) // Replace with your API endpoint
                        .placeholder(R.drawable.dummy_profile_image) // Optional placeholder
                        .error(R.drawable.baseline_person) // Optional error image
                        .into(img_user_profile_image2);

                // Display All Data
                ed_profile_Name.setText(GeT_name);
                ed_profile_Mobile.setText(GeT_userphone);
                ed_profile_Email.setText(GeT_email);
                ed_profile_Age.setText(GeT_age);
                ed_profile_Gender.setText(GeT_gender);
                ed_profile_Address.setText(GeT_address);
                ed_profile_Education.setText(GeT_education);

                profile_View.setVisibility(View.GONE);
                profile_edit.setVisibility(View.VISIBLE);

            }
        });

        img_user_profile_image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dexter.withActivity(getActivity())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent intent = new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent, "Browse Image"), 1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });



        // Update Profile Data
        btn_profile_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (encodeImageString == null){
                    Toast.makeText(getActivity(), "Please select an image again", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }else {

                    progressBar.setVisibility(View.VISIBLE);
                    btn_profile_update.setVisibility(View.GONE);

                    String Get_ed_profile_Name = ed_profile_Name.getText().toString().trim();
                    String Get_ed_profile_Mobile = ed_profile_Mobile.getText().toString().trim();
                    String Get_ed_profile_Email = ed_profile_Email.getText().toString().trim();
                    String Get_ed_profile_Age = ed_profile_Age.getText().toString().trim();
                    String Get_ed_profile_Gender = ed_profile_Gender.getText().toString().trim();
                    String Get_ed_profile_Address = ed_profile_Address.getText().toString().trim();
                    String Get_profile_Education = ed_profile_Education.getText().toString().trim();

                    String GeT_profile_user_Id = sharedPreferences.getString("profile_id", "0");

                    String api_url = getString(R.string.api_url);
                    String url = api_url + "/rgc/profileupdate.php?puid="+GeT_profile_user_Id+"&pn="+Get_ed_profile_Name+
                            "&pm="+Get_ed_profile_Mobile+"&pe="+Get_ed_profile_Email+"&pa="+Get_ed_profile_Age+"&pg="+
                            Get_ed_profile_Gender+"&pad="+Get_ed_profile_Address+"&ped="+Get_profile_Education+"&pimg="+encodeImageString ;

                    // ed_profile_Education.setText(encodeImageString);
                    StringRequest stringRequest2 = new StringRequest(Request.Method.POST, BASE_API_URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("update")) {
                                profile_View.setVisibility(View.VISIBLE);
                                profile_edit.setVisibility(View.GONE);
                                progressBar.setVisibility(View.GONE);
                                btn_profile_update.setVisibility(View.VISIBLE);
                                //----  Load Profile data
                                load_Profile_data();

                                Toast.makeText(getActivity(), "Update Successful", Toast.LENGTH_SHORT).show();
                            } else {
                                progressBar.setVisibility(View.GONE);
                                btn_profile_update.setVisibility(View.VISIBLE);
                                Toast.makeText(getActivity(), " else " + response, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getActivity(), "Error : "+error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    {
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String,String>  map = new HashMap<>();
                            // Add parameters to the HashMap

                            map.put("puid", GeT_profile_user_Id);
                            map.put("pn", Get_ed_profile_Name);
                            map.put("pm", Get_ed_profile_Mobile);
                            map.put("pe", Get_ed_profile_Email);
                            map.put("pa", Get_ed_profile_Age);
                            map.put("pg", Get_ed_profile_Gender);
                            map.put("pad", Get_ed_profile_Address);
                            map.put("ped", Get_profile_Education);
                            map.put("pimg", encodeImageString);

                            return map;
                        }
                    };
                    RequestQueue requestQueue2= Volley.newRequestQueue(getActivity());
                    requestQueue2.add(stringRequest2);


                }


            }
        });


        btn_profile_cansel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                profile_edit.setVisibility(View.GONE);
                profile_View.setVisibility(View.VISIBLE);

            }
        });




        return myView;
    }
    ///// last bracket start

    // Load Profile Data
    private void load_Profile_data() {

        // Access SharedPreferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String GeT_userphone = sharedPreferences.getString("userphone", " ");
        String GeT_user_Pass = sharedPreferences.getString("userpass", "0");
        String api_url = getString(R.string.api_url);
        String p_url = api_url + "/rgc/profile.php?ph="
                + GeT_userphone + "&pas=" + GeT_user_Pass;

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        //   progressBar.setVisibility(View.VISIBLE);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, p_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //    progressBar.setVisibility(View.GONE);

                for (int x = 0; x < response.length(); x++) {

                    try {
                        JSONObject jsonObject = response.getJSONObject(x);
                        String id = jsonObject.getString("id");
                        String name = jsonObject.getString("name");
                        String phone = jsonObject.getString("phone");
                        String email = jsonObject.getString("email");
                        String password = jsonObject.getString("password");
                        String age = jsonObject.getString("age");
                        String gender = jsonObject.getString("gender");
                        String address = jsonObject.getString("address");
                        String education = jsonObject.getString("education");
                        String profile_image_url = jsonObject.getString("profile_image_url");

                        // Display All Data
                        tv_user_name.setText(name);
                        tv_user_name2.setText(name);
                        tv_user_mobile.setText(phone);
                        tv_user_email.setText(email);
                        tv_user_age.setText(age);
                        tv_user_gender.setText(gender);
                        tv_user_address.setText(address);
                        tv_user_education.setText(education);

                        // save data in SharedPreferences
                        editor.putString("profile_id", "" + id);
                        editor.putString("name", "" + name);
                        editor.putString("userphone", "" + phone);
                        editor.putString("email", "" + email);
                        editor.putString("userpass", "" + password);
                        editor.putString("age", "" + age);
                        editor.putString("gender", "" + gender);
                        editor.putString("address", "" + address);
                        editor.putString("education", "" + education);
                        editor.putString("profile_image_url", "" + profile_image_url);
                        editor.apply();

                        String GeT_img_user_profile_image = sharedPreferences.getString("profile_image_url", " ");

                        // Load image from Hosting File
                        Picasso.get()
                                .load("http://fssoft.xyz/rgc/image/" + GeT_img_user_profile_image) // Replace with your API endpoint
                                .placeholder(R.drawable.dummy_profile_image) // Optional placeholder
                                .error(R.drawable.baseline_person) // Optional error image
                                .into(img_user_profile_image);


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

            }
        });

        requestQueue.add(jsonArrayRequest);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if (requestCode == 1 && resultCode == RESULT_OK && data!=null)
        {
            Uri filepath = data.getData();

            try {
                InputStream inputStream = getActivity().getContentResolver().openInputStream(filepath);
                bitmap = BitmapFactory.decodeStream(inputStream);
                img_user_profile_image2.setImageBitmap(bitmap);
                encodeBitmapImage(bitmap);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void encodeBitmapImage(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] bytesofimage = byteArrayOutputStream.toByteArray();
        encodeImageString = android.util.Base64.encodeToString(bytesofimage, Base64.DEFAULT);
    }



    ///  last bracket ends
}
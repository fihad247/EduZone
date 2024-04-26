package com.fssoft.eduzone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab_center;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_center = findViewById(R.id.fab_center);
        sharedPreferences = getSharedPreferences(getString(R.string.app_name) , MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String user_phone = sharedPreferences.getString("userphone", "0");
        String user_pass = sharedPreferences.getString("userpass", "0");

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);


        //  Save Shared preferences User login data
        SaveUserdataDataSP();

        //---Status Bar Color------------
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }

        //----------login checker
        String userlogincheck = sharedPreferences.getString("userlogininfo", "Plz LOgin");
        if (userlogincheck.equals("successful")) {
            // The user is logged in, so go to the dashboard activity
        }else {
            // The user is not logged in, so go to the login activity
            startActivity( new Intent(this,User_Login.class));
            finish();
            //Toast.makeText(this, "আপনাকে লগইন করতে হবে", Toast.LENGTH_SHORT).show();
        }





        bottomNavigationView.setBackground(null);
        replaceFragment(new Fragment_Home());

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        fab_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(MainActivity.this, Chat_Dashbord.class);
                 startActivity(intent);


            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int id = item.getItemId();
                item.setCheckable(true);
                drawerLayout.closeDrawer(GravityCompat.START);

                if (id == R.id.nav_data_backup) {
                    // Toast.makeText(MainActivity.this, "Data backup is Clicked", Toast.LENGTH_SHORT).show();
                    //   Intent intent = new Intent(MainActivity.this, Web_Browser.class);
                    //   startActivity(intent);
                    replaceFragment(new Fragment_Message());
                } else if (id == R.id.nav_profile) {
                    replaceFragment(new Fragment_Profile());
                   // Toast.makeText(MainActivity.this, "Synch is Clicked", Toast.LENGTH_SHORT).show();
                 //   Intent intent = new Intent(MainActivity.this, Digital_Tashbih.class);
                  //  startActivity(intent);

                } else if (id == R.id.nav_privacy_policy) {
                    Toast.makeText(MainActivity.this, "privacy policy is Clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_logout) {

                    // Save User login or not-login
                    editor.putString("userlogininfo" , "null");
                    editor.putString("profile_id" , "null");
                    editor.putString("name" , "null");
                    editor.putString("userphone" , "null");
                    editor.putString("userpass" , "null");
                    editor.putString("email" , "null");
                    editor.putString("age" , "null");
                    editor.putString("gender" , "null");
                    editor.putString("address" , "null");
                    editor.putString("education" , "null");
                    editor.apply();

                    Toast.makeText(MainActivity.this, "আপনি লগ আউট করেছেন", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(MainActivity.this, User_Login.class);
                    startActivity(myIntent);
                    finish();

                } else if (id == R.id.nav_app_version) {
                    Toast.makeText(MainActivity.this, "App Version 1.0.0 ", Toast.LENGTH_SHORT).show();
                } else {
                    return true;
                }
                return true;

            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                replaceFragment(new Fragment_Home());
            } else if (itemId == R.id.notification) {
                 Intent intent = new Intent(MainActivity.this, User_Profile_Update.class);
                 startActivity(intent);
            } else if (itemId == R.id.fab) {

            } else if (itemId == R.id.post) {
                replaceFragment(new Fragment_Post());
            } else if (itemId == R.id.profile) {
                replaceFragment(new Fragment_Profile());
            }
            return true;

        });




    }  //---------last bracket start -----------------

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }



    //-------------save user data--------------
    private void SaveUserdataDataSP(){


        String user_phone = sharedPreferences.getString("userphone", "null");
        String user_pass = sharedPreferences.getString("userpass", "null");

        String api_url = getString(R.string.api_url);
        String p_url = api_url + "/rgc/profile.php?ph="
                + user_phone + "&pas=" +user_pass ;

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //-------No internet Connection--------------
        checkInternetConnection();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, p_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //    progressBar.setVisibility(View.GONE);

                for (int x=0; x<response.length(); x++){

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

                        // save data in SharedPreferences
                        editor.putString("profile_id" , ""+id);
                        editor.putString("name" , ""+name);
                        editor.putString("userphone" , ""+phone);
                        editor.putString("email" , ""+email);
                        editor.putString("userpass" , ""+password);
                        editor.putString("age" , ""+age);
                        editor.putString("gender" , ""+gender);
                        editor.putString("address" , ""+address);
                        editor.putString("education" , ""+education);
                        editor.putString("profile_image_url" , ""+profile_image_url);
                        editor.apply();

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
                Toast.makeText(MainActivity.this, "Network No Respons", Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonArrayRequest);


    }

    //Back Button
    @Override
    public void onBackPressed() {
       // super.onBackPressed();
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Conform Exit")
                .setMessage("Do You realy want exit?")
                .setIcon(R.drawable.baseline_notifications)
                .setNegativeButton("No thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setPositiveButton("Yes Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finishAndRemoveTask();
                    }
                })
                .show();



    }

    //-------No internet Connection--------------
    public void checkInternetConnection() {


        ConnectivityManager connectivityManager = (ConnectivityManager) MainActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            Toast.makeText(MainActivity.this, "No internet connection", Toast.LENGTH_SHORT).show();
        }

    }


}  //----last bracket ends -------------------
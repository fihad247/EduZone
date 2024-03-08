package com.fssoft.eduzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class User_Login extends AppCompatActivity {

    private EditText edphone_signIn, edpassword_signIn;
    private Button btn_signIn , btn_signIn3;
    private ProgressBar progressBar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        edphone_signIn = findViewById(R.id.edphone_signIn2);
        edpassword_signIn = findViewById(R.id.edpassword_signIn2);
        btn_signIn = findViewById(R.id.btn_signIn2);
        btn_signIn3 = findViewById(R.id.btn_signIn3);

        progressBar = findViewById(R.id.progressBar_login2);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name) , MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String user_phone = sharedPreferences.getString("userphone", "0");
        String user_pass = sharedPreferences.getString("userpass", "0");


        //-------No internet Connection--------------
        checkInternetConnection();

        //----------login cheker
        String userlogincheck = sharedPreferences.getString("userlogininfo", "ok");
        if (userlogincheck.equals("successful")) {
            // The user is logged in, so go to the dashboard activity
            startActivity( new Intent(User_Login.this, MainActivity.class));
            finish();
        }



        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //---------login code----------

                String login_phone = edphone_signIn.getText().toString().trim();
                String api_url = getString(R.string.api_url);
                String phonecheck = api_url + "/rgc/loginphonecheck.php?ph="+ login_phone;

                StringRequest stringRequest2 = new StringRequest(Request.Method.GET, phonecheck, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar.setVisibility(View.GONE);

                        if (response.equals("Phonenotfound")) {
                            Toast.makeText(User_Login.this, "User Not Found", Toast.LENGTH_SHORT).show();
                            // Perform necessary actions on successful login

                            // Redirect to the Register page
                            Intent myIntent = new Intent(User_Login.this, User_Register.class);
                            startActivity(myIntent);

                        } else if (response.equals("Phonenumbealreadyregistered")) {
                            Toast.makeText(User_Login.this, "Input password", Toast.LENGTH_SHORT).show();
                            // Perform necessary actions when username is not found
                            edphone_signIn.setVisibility(View.GONE);
                            edpassword_signIn.setVisibility(View.VISIBLE);
                            btn_signIn3.setVisibility(View.VISIBLE);
                            btn_signIn.setVisibility(View.GONE);


                        } else {
                            Toast.makeText(User_Login.this, "Sumthing is Wrong", Toast.LENGTH_SHORT).show();
                            // Perform necessary actions on failed login
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ServerRes", error.toString());
                        Toast.makeText(User_Login.this, "Low Internet Connection", Toast.LENGTH_SHORT).show();
                    }
                });

                if (TextUtils.isEmpty(login_phone)) {
                    edphone_signIn.setError("Please enter your phone number");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                RequestQueue requestQueue2 = Volley.newRequestQueue(User_Login.this);
                requestQueue2.add(stringRequest2);


            }
        });

        //--------  Sign in---------
        btn_signIn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //---------login code----------
                logincheker();




            }
        });


    }       //-----------last bracket start

    //---------login code----------
    public void logincheker () {

        String login_phone = edphone_signIn.getText().toString().trim();
        String login_password = edpassword_signIn.getText().toString().trim();

        String api_url = getString(R.string.api_url);
        String login_url = api_url + "/rgc/login.php?ph="
                + login_phone + "&pas=" + login_password ;

        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, login_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressBar.setVisibility(View.GONE);

                if (response.equals("successful")) {
                    Toast.makeText(User_Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                    // Perform necessary actions on successful login

                    // Save User login or not-login
                    editor.putString("userphone" , ""+ login_phone);
                    editor.putString("userpass" , ""+ login_password);
                    editor.putString("userlogininfo" ,  "successful");
                    editor.apply();

                    // Redirect to the home page
                    Intent myIntent = new Intent(User_Login.this, MainActivity.class);
                    startActivity(myIntent);
                    finish();


                } else if (response.equals("passwordnotmatching")) {
                    //   Toast.makeText(New_Login.this, "Password not Match", Toast.LENGTH_SHORT).show();
                    // Perform necessary actions on incorrect password
                    //  startActivity( new Intent(New_Login.this, User_Register.class));

                    edpassword_signIn.setError("Password not Match");
                    progressBar.setVisibility(View.GONE);

                    //-------No internet Connection--------------
                    checkInternetConnection();

                } else if (response.equals("Username not found")) {
                    Toast.makeText(User_Login.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                } else {
                    Toast.makeText(User_Login.this, "VPN Detected", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ServerRes", error.toString());
                Toast.makeText(User_Login.this, "ErrorListener", Toast.LENGTH_SHORT).show();
            }
        });



        if (TextUtils.isEmpty(login_phone)) {
            edphone_signIn.setError("Please enter your phone number");
            return;
        }

        if (TextUtils.isEmpty(login_password)) {
            edpassword_signIn.setError("Please enter your password");
            progressBar.setVisibility(View.GONE);
            return;
        }



        //-------No internet Connection--------------
        ConnectivityManager connectivityManager = (ConnectivityManager) User_Login.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            Toast.makeText(User_Login.this, "No internet connection", Toast.LENGTH_SHORT).show();
            return;
        }



        // If all fields are valid, proceed with further actions
        // For example, you can perform form submission or other operations
        // Toast.makeText(Register.this, "Sign Up successfully", Toast.LENGTH_SHORT).show();
        RequestQueue requestQueue = Volley.newRequestQueue(User_Login.this);
        requestQueue.add(stringRequest);


    };

    //-------No internet Connection--------------
    public void checkInternetConnection() {

        //-------No internet Connection--------------
        ConnectivityManager connectivityManager = (ConnectivityManager) User_Login.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            Toast.makeText(User_Login.this, "No internet connection", Toast.LENGTH_SHORT).show();
        }

    }


}       //-----------last bracket ends



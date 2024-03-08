package com.fssoft.eduzone;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class User_Register extends AppCompatActivity {

    private Button btn_go_sign_in, btn_signUp;
    private LinearLayout layout_sign_up;
    private EditText edname_signUp, edphone_signUp, edemail_signUp, edpassword_signUp;
    private ProgressBar progressBar;
    private LottieAnimationView lottieAnimationView;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        btn_go_sign_in = findViewById(R.id.btn_go_sign_in);
        btn_signUp = findViewById(R.id.btn_signUp);

        layout_sign_up = findViewById(R.id.layout_sign_up);

        edname_signUp = findViewById(R.id.edname_signUp);
        edphone_signUp = findViewById(R.id.edphone_signUp);
        edemail_signUp = findViewById(R.id.edemail_signUp);
        edpassword_signUp = findViewById(R.id.edpassword_signUp);

        lottieAnimationView = findViewById(R.id.animationView);

        progressBar = findViewById(R.id.progressBar_post);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name) , MODE_PRIVATE);
        editor = sharedPreferences.edit();


        //----------login cheker
        String userlogincheck = sharedPreferences.getString("userlogininfo", "ok");
        if (userlogincheck.equals("successful")) {
            // The user is logged in, so go to the dashboard activity
            startActivity( new Intent(this, MainActivity.class));
            finish();
        }



        //--------- Visibil sign in  -----------
        btn_go_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity( new Intent(User_Register.this, User_Login.class));

            }
        });

        //-------  Sign Up --------------
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name_signUp = edname_signUp.getText().toString();
                String phone_signUp = edphone_signUp.getText().toString();
                String email_signUp = edemail_signUp.getText().toString();
                String password_signUp = edpassword_signUp.getText().toString();

                String api_url = getString(R.string.api_url);
                String url_signUp = api_url+"/rgc/registar.php?n="
                        + name_signUp + "&p=" + phone_signUp + "&e=" + email_signUp + "&s=" + password_signUp;

                progressBar.setVisibility(View.VISIBLE);


                //-----------register Request------
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url_signUp, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);
                        /**    new AlertDialog.Builder(Register.this)
                         .setTitle("Server Response")
                         .setMessage(response)
                         .show();
                         **/

                        if (response.equals("Inserted")) {

                            Toast.makeText(User_Register.this, " Registration Successful", Toast.LENGTH_SHORT).show();
                            layout_sign_up.setVisibility(View.GONE);
                            lottieAnimationView.setVisibility(View.VISIBLE);
                            //----animation Start
                            lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
                                @Override
                                public void onAnimationStart(Animator animator) {
                                    // Animation started
                                }

                                @Override
                                public void onAnimationEnd(Animator animator) {
                                    // Animation ended
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            // Show the button after 1.5 seconds
                                            // go to login activity.........
                                            startActivity(new Intent(User_Register.this, User_Login.class));
                                        }
                                    }, 1500);
                                }

                                @Override
                                public void onAnimationCancel(Animator animator) {
                                    // Animation cancelled
                                }

                                @Override
                                public void onAnimationRepeat(Animator animator) {
                                    // Animation repeated
                                }
                            });
                            //----animation ends
                        } else if(response.equals("Phonenumbealreadyregistered")) {

                            // Redirect to the Login page
                            Intent myIntent = new Intent(User_Register.this, User_Login.class);
                            startActivity(myIntent);
                            Toast.makeText(User_Register.this, "Phone number already Registered ", Toast.LENGTH_SHORT).show();

                        } else if(response.equals("Emailalreadyregistered")) {
                            Toast.makeText(User_Register.this, "Email already Registered", Toast.LENGTH_SHORT).show();
                        } else if(response.equals("RegistrationFailed")) {
                            Toast.makeText(User_Register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(User_Register.this, "Use   1.1.1.1   VPN ", Toast.LENGTH_SHORT).show();
                            // Perform necessary actions on failed login
                        }




                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });

                /**
                 if (name_signUp.length()>0) {
                 RequestQueue requestQueue = Volley.newRequestQueue(Register.this);
                 requestQueue.add(stringRequest);
                 }else edname_signUp.setError("Input Your Name");
                 **/


                // Validate input fields
                if (TextUtils.isEmpty(name_signUp)) {
                    edname_signUp.setError("Please enter your name");
                    return;
                }

                if (TextUtils.isEmpty(phone_signUp)) {
                    edphone_signUp.setError("Please enter your phone number");
                    return;
                }

                if (TextUtils.isEmpty(email_signUp)) {
                    edemail_signUp.setError("Please enter your email");
                    return;
                }

                if (TextUtils.isEmpty(password_signUp)) {
                    edpassword_signUp.setError("Please enter your password");
                    return;
                }
                //-------No internet Connection--------------
                ConnectivityManager connectivityManager = (ConnectivityManager) User_Register.this.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if (networkInfo == null || !networkInfo.isConnected()) {
                    Toast.makeText(User_Register.this, "No internet connection", Toast.LENGTH_SHORT).show();
                    return;
                }

                // If all fields are valid, proceed with further actions
                // For example, you can perform form submission or other operations
                // Toast.makeText(Register.this, "Sign Up successfully", Toast.LENGTH_SHORT).show();
                RequestQueue requestQueue = Volley.newRequestQueue(User_Register.this);
                requestQueue.add(stringRequest);






            }
        });





    }//-----------last bracket start


    //-------No internet Connection--------------
    public void checkInternetConnection() {

        //-------No internet Connection--------------
        ConnectivityManager connectivityManager = (ConnectivityManager) User_Register.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            Toast.makeText(User_Register.this, "No internet connection", Toast.LENGTH_SHORT).show();
        }

    }

}//-----------last bracket ends
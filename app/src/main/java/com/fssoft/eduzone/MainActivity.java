package com.fssoft.eduzone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab_center;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_center = findViewById(R.id.fab_center);


        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        //---Status Bar Color------------
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(R.color.status_bar_color));
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

                Intent intent = new Intent(MainActivity.this, Digital_Tashbih.class);
                startActivity(intent);


            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int id = item.getItemId();
                item.setCheckable(true);
                drawerLayout.closeDrawer(GravityCompat.START);

                if (id == R.id.nav_message) {
                    // Toast.makeText(MainActivity.this, "Message is Clicked", Toast.LENGTH_SHORT).show();
                    replaceFragment(new Fragment_Message());
                } else if (id == R.id.nav_sync) {

                    Toast.makeText(MainActivity.this, "Synch is Clicked", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Digital_Tashbih.class);
                    startActivity(intent);

                } else if (id == R.id.nav_trush) {
                    Toast.makeText(MainActivity.this, "Trash is Clicked", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_settings) {
                    Toast.makeText(MainActivity.this, "Settings is Clicked", Toast.LENGTH_SHORT).show();
                    replaceFragment(new Fragment_Settings());
                } else if (id == R.id.nav_login) {
                    Toast.makeText(MainActivity.this, "Login is Clicked", Toast.LENGTH_SHORT).show();
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
                replaceFragment(new Fragment_Message());
            } else if (itemId == R.id.fab) {

                Intent intent = new Intent(MainActivity.this, Digital_Tashbih.class);
                startActivity(intent);

            } else if (itemId == R.id.leaderbord) {
                replaceFragment(new Fragment_Settings());
            } else if (itemId == R.id.tashbih) {
                replaceFragment(new Fragment_Message());
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



}  //----last bracket ends -------------------
package com.fssoft.eduzone;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Web_Browser extends AppCompatActivity {

    ProgressBar progressBar_wev_view;
    WebView web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);

        progressBar_wev_view = findViewById(R.id.progressBar_wev_view);
        web_view = findViewById(R.id.web_view);

        web_view.getSettings().setJavaScriptEnabled(true);

        // Add a WebViewClient to hide the progress bar and handle loading events
        web_view.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar_wev_view.setVisibility(View.GONE);
            }
        });

        // Show the progress bar while the page loads
        web_view.loadUrl("https://www.google.com");


    }
}
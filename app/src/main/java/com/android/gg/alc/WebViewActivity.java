package com.android.gg.alc;

import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView= findViewById(R.id.webView);


        Toast.makeText(this, "loading...", Toast.LENGTH_SHORT).show();

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view ,int errorCode,String description,String failingUrl){
                Toast.makeText(WebViewActivity.this, description, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                handler.proceed();
            }
        });
        webView.loadUrl("https://andela.com/alc/");
    }
}

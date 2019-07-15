package com.varscon.alc4_android_challenge;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.net.http.*;

public class WebViewActivity extends AppCompatActivity {
    private WebView browser;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_OPTIONS_PANEL);
        setContentView(R.layout.activity_web_view);
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);
        browser = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);

        if (savedInstanceState != null){

            browser.restoreState(savedInstanceState);
            progressBar.setVisibility(View.GONE);

        }else {


            browser.getSettings().setJavaScriptEnabled(true);
            browser.getSettings().setLoadWithOverviewMode(true);
            browser.getSettings().setUseWideViewPort(true);
            browser.getSettings().setDomStorageEnabled(true);
            browser.setWebChromeClient(new WebChromeClient());

            final Activity activity = this;

            browser.setWebChromeClient(new WebChromeClient() {

                public void onProgressChanged(WebView view, int progress) {
                    activity.setTitle("Loading...");
                    activity.setProgress(progress * 100);
                    if (progress == 100)
                        activity.setTitle("About ALC");
                        progressBar.setVisibility(View.GONE);
                }
            });

            browser.getSettings().setJavaScriptEnabled(true);
            browser.getSettings().setLoadWithOverviewMode(true);
            browser.getSettings().setUseWideViewPort(true);
            browser.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);

                    return true;
                }
                @Override
                public void onPageFinished(WebView view, final String url) {
//                    progDailog.dismiss();
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                    handler.proceed();
                }
            });

           browser.loadUrl("https://www.andela.com/alc");

        }


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        browser.saveState(outState);
        super.onSaveInstanceState(outState);
    }
}

package com.kaiappgo.go;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class cardWeb extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_web);

        WebView webView = (WebView) findViewById(R.id.webView01);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl("https://ezweb.easycard.com.tw/search/CardSearch.php");
        String url = "https://ezweb.easycard.com.tw/search/CardSearch.php";
        webView.loadUrl(url);
    }
}

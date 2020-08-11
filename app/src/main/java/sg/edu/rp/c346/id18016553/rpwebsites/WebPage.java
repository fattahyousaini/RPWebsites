package sg.edu.rp.c346.id18016553.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebPage extends AppCompatActivity {

    WebView wvPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);


        wvPage = findViewById(R.id.webView);
        wvPage.setWebViewClient(new WebViewClient());

        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");

//        String url = "https://www.rp.edu.sg/";
//        String url1 = "https://www.rp.edu.sg/student-life";
//        String url2 = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
//        String url3 = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";

        wvPage.getSettings().setJavaScriptEnabled(true);
        wvPage.getSettings().setAllowFileAccess(false);
        wvPage.getSettings().setBuiltInZoomControls(true);

        wvPage.loadUrl(url);

    }
}

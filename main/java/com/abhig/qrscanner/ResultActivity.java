package com.abhig.qrscanner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.abhig.qrscanner.MainActivity;
import com.google.zxing.integration.android.IntentResult;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String result = getIntent().getStringExtra("SCAN_RESULT");

        if (result != null && result.startsWith("http://") || result.startsWith("https://")) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(result));
            startActivity(browserIntent);
            finish();

        } else {
            Toast.makeText(this, "Some Error Occurred", Toast.LENGTH_SHORT).show();
        }

    }
}
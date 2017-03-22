package com.example.android.inkaleidoskop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void map(View view) {
        String position = getString(R.string.address);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(Uri.parse("geo:" + position));

        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void phone(View view) {
        String phone_no = getString(R.string.phone);
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + phone_no));

        if (callIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callIntent);
        }
    }

    public void url(View view) {
        Uri webPage = Uri.parse(getString(R.string.url));
        Intent urlIntent = new Intent(Intent.ACTION_VIEW, webPage);

        if (urlIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(urlIntent);
        }
    }
}
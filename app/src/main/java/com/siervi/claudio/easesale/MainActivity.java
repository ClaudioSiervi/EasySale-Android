package com.siervi.claudio.easesale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void call_activity_sale(View view) {
        Intent intent = new Intent(this, activity_sales.class);
        startActivity(intent);
    }

    public void call_activity_product_registration(View view) {
        Intent intent = new Intent(this, activity_product_registration.class);
        startActivity(intent);
    }

    public void call_activity_report(View view) {
        Intent intent = new Intent(this, activity_report.class);
        startActivity(intent);
    }

    public void call_activity_config(View view) {
        Intent intent = new Intent(this, activity_config.class);
        startActivity(intent);
    }
}


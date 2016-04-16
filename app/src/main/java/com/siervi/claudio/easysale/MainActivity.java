package com.siervi.claudio.easysale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // main activity objects
    Button btnProductRegistration, btnMakeSale, btnReport, btnConfig;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
        setActions();
    }

    // address buttons id
    private void setUI(){
        btnProductRegistration = (Button) findViewById(R.id.btn_ProductRegistration );
        btnMakeSale = (Button) findViewById(R.id.btn_MakeSale );
        btnReport = (Button) findViewById(R.id.btn_Report );
    }

    // set buttons methods
    private void setActions(){
        btnProductRegistration.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                productRegistrationActivity(v);
            }
        });

        btnMakeSale.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saleActivity(v);
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reportActivity(v);
            }
        });


    }

    // methods
    public void productRegistrationActivity(View view) {
        Intent intent = new Intent(this, ProductRegistrationActivity.class);
        startActivity(intent);
    }

    public void saleActivity(View view) {
        Intent intent = new Intent(this, SalesActivity.class);
        startActivity(intent);
    }

    public void reportActivity(View view) {
        Intent intent = new Intent(this, ReportActivity.class);
        startActivity(intent);
    }

}


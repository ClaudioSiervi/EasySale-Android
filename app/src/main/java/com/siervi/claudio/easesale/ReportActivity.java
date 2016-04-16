package com.siervi.claudio.easesale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import io.realm.Realm;

public class ReportActivity extends AppCompatActivity {

    private List<Sale> sales;
    private RecyclerView mRecyclerView;
    private SalesAdapter mSaleAdapter;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        setUI();
        setActions();

        realm = Realm.getDefaultInstance();

        sales = realm.where(Sale.class).findAll();

        mRecyclerView = (RecyclerView) findViewById(R.id.rcv_sales_report);

        mSaleAdapter = new SalesAdapter(sales);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mSaleAdapter);

    }

    private void setActions() {    }

    private void setUI() {    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close(); // close Realm when done
    }

}

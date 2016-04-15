package com.siervi.claudio.easesale;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import io.realm.Realm;

public class SalesActivity extends AppCompatActivity {

    private List<Product> product;
    private RecyclerView mRecyclerView;
    private ProductsAdapter mProductAdapter;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        realm = Realm.getDefaultInstance();

        product = realm.where(Product.class).findAll();

        mRecyclerView = (RecyclerView) findViewById(R.id.rcv_sales);

        mProductAdapter = new ProductsAdapter(product);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mProductAdapter);

  }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close(); // Remember to close Realm when done.
    }

}

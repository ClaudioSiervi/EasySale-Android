package com.siervi.claudio.easesale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;

public class SalesActivity extends AppCompatActivity {

    private List<Product> product;
    private RecyclerView mRecyclerView;
    private ProductsAdapter mProductAdapter;
    private Realm realm;

    Button btnConfirmSale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        setUI();
        setActions();

        realm = Realm.getDefaultInstance();

        product = realm.where(Product.class).findAll();

        mRecyclerView = (RecyclerView) findViewById(R.id.rcv_sales);

        mProductAdapter = new ProductsAdapter(product);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mProductAdapter);

  }

    // address buttons id
    private void setUI(){
        btnConfirmSale = (Button) findViewById(R.id.btn_confirmSale );
    }

    // set buttons methods
    private void setActions(){
        btnConfirmSale.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                confirmSale(v);
            }
        });

    }

// Salva os itens vendidos no banco de dados
    public void confirmSale(View view) {

        realm.beginTransaction();
        for (int i = 0; i < mProductAdapter.saleList.size(); i++) {
            Sale sale = realm.createObject(Sale.class);
// Recupera o próximo id
            sale.setId(realm.where(Sale.class).max("id").intValue() + 1);
            sale.setQuantity(mProductAdapter.saleList.get(i).getQuantity());
            sale.setProduct(mProductAdapter.saleList.get(i).getProduct());

        }
        realm.commitTransaction();
        Toast.makeText(SalesActivity.this, "Dados Salvos",Toast.LENGTH_SHORT).show();

        // Limpa reinicia a venda
        mProductAdapter.saleList.clear();
        mProductAdapter.notifyDataSetChanged();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close(); // close Realm when done
    }

}

package com.siervi.claudio.easesale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class ProductRegistrationActivity extends AppCompatActivity {

    Button btnRegisterProduct;
    EditText edtProductName, edtProductPrice;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_registration);
        setUI();
        setActions();

        realm = Realm.getDefaultInstance();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    private void setUI() {
        btnRegisterProduct = (Button) findViewById(R.id.btn_RegisterProduct);
        edtProductName = (EditText) findViewById(R.id.edt_ProductName);
        edtProductPrice = (EditText) findViewById(R.id.edt_ProductPrice);
    }

    private void setActions() {
        btnRegisterProduct.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                registerProduct(v);
            }
        });
    }

    // IMPLEMENTAR O MÉTODO DE INSERÇÃO
    private  void registerProduct(View view){

    try{
    // Salva o novo ingresso no banco de dados
    realm.beginTransaction();

    ProductList product = realm.createObject(ProductList.class);

    product.setName(edtProductName.getText().toString());
        product.setPrice(Double.parseDouble(edtProductPrice.getText().toString()));

    realm.commitTransaction();



    } catch (Exception e){
        Log.e("Realm Error", "error", e);
    }


// clean view
    edtProductName.setText("");
    edtProductPrice.setText("");
    }

}
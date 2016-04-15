package com.siervi.claudio.easesale;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Claudio on 09/04/2016.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {


    private List<Product> Product;
    private Realm realm;


    public ProductsAdapter(List<Product> Product) {
        this.Product = Product;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView productName, productPrice;

        public MyViewHolder(View view) {
            super(view);
            productName = (TextView) view.findViewById(R.id.txt_nome);
            productPrice = (TextView) view.findViewById(R.id.txt_documento);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_products, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Product Product = this.Product.get(position);

        holder.productName.setText(Product.getName());
        holder.productPrice.setText("PreÇo: " + Product.getPrice());
    }

    @Override
    public int getItemCount() {
        return Product.size();
    }
}
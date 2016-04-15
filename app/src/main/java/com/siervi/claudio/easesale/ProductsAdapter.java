package com.siervi.claudio.easesale;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Claudio on 09/04/2016.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private List<Product> productList;
    private Realm realm;

    public ProductsAdapter(List<Product> products) {

        this.productList = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_products, parent, false);

        ViewHolder holder = new ViewHolder(v);

        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.productName.setText(productList.get(position).getName());
        holder.productQuantity.setText("0");

        holder.sumProducts.setTag(new Integer(position));

        holder.sumProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                int clickedPos = ((Integer) btn.getTag()).intValue();

                Product product = productList.get(clickedPos);



                notifyItemChanged(clickedPos);

            }
        });
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView productName, productQuantity;
        public Button sumProducts;

        public ViewHolder(View view) {
            super(view);
            productName = (TextView) view.findViewById(R.id.txt_productName);
            productQuantity = (TextView) view.findViewById(R.id.txt_quantity);
            sumProducts = (Button) view.findViewById(R.id.btn_sumProducts);
        }
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }
}
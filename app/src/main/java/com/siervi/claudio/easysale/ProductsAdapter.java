package com.siervi.claudio.easysale;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import io.realm.Realm;

/**
 * Created by Claudio on 09/04/2016.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    public List<Sale> saleList = new ArrayList<Sale>();
    private List<Product> productList;
    private int idSale = 1;
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

        // get product
        Product product = productList.get(position);

        // update sale
        Sale sale = recoverSale(product.getName());

        if (sale != null){
           holder.productQuantity.setText(String.valueOf(sale.getQuantity()));
        } else {
            holder.productQuantity.setText("0");
        }

        holder.sumProducts.setTag(new Integer(position));
        holder.sumProducts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                atualizeSale(v);
            }
        });
    }
    // verify if there are sales
    private Sale recoverSale(String name) {
        Sale sale = null;
        for (int i = 0; i < saleList.size(); i++) {
            if (saleList.get(i).getProduct().getName().equals(name)) {
                return saleList.get(i);

            }
        }
        return sale;
    }

    public void atualizeSale(View v) {

        Button btn = (Button) v;
        int clickedPos = ((Integer) btn.getTag()).intValue(); // return position

        Product product = productList.get(clickedPos);  // recover product
        Sale sale = recoverSale(product.getName());     // recover sale
        int item = recoverItemSale(product.getName());

        // If the product there exists add quantity
        if ( sale != null ) {
            sale.setQuantity(sale.getQuantity() + 1);
            saleList.set(item,sale);
        } else {
            // else add sale
            sale = new Sale();
            sale.setId(idSale);
            sale.setProduct(product);
            sale.setQuantity(1);
            //DateFormat today = new SimpleDateFormat("");
            // TODO ATRIBUIR DATA
            saleList.add(sale);
        }

        notifyItemChanged(clickedPos);
    }
    // return sale position
    private int recoverItemSale(String name) {
        int i;
        for (i = 0; i < saleList.size(); i++) {
            if (saleList.get(i).getProduct().getName().equals(name)) {
                return i;

            }
        }
        return i;
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
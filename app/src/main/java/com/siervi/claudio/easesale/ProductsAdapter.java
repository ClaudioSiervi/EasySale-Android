package com.siervi.claudio.easesale;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import io.realm.Realm;

/**
 * Created by Claudio on 09/04/2016.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private List<Product> productList;
    private List<Sale> saleList = new ArrayList<Sale>();
    private int idSale = 1;
    private Realm realm; // Verificar se essa variável é util

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

// Recupera quantidade vendida do produto
        Product product = productList.get(position);
        //Sale sale = null;

//        Boolean verificaProduto = saleList.contains(product);
        int index = saleList.indexOf(product);

        if (index >= 0){
           Sale sale = saleList.get(saleList.indexOf(product));
           holder.productQuantity.setText(sale.getQuantity());

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


    public void atualizeSale(View v) {

        Button btn = (Button) v;
        int clickedPos = ((Integer) btn.getTag()).intValue(); // Retorna a posição da view selecionada

// Recupera o produto clicado
        Product product = productList.get(clickedPos);
        Sale sale = null;

// Se a lista não está vazia e contem o produto clicado recupera o item
        if (!saleList.isEmpty() && saleList.contains(product)){
            sale = saleList.get(saleList.indexOf(product)) ;
        }

// Se o item ainda nao estava na venda adiciona
        if (sale == null) {

            sale = new Sale();
            sale.setId(idSale);
            sale.setProduct(product);
            sale.setQuantity(1);
            //DateFormat today = new SimpleDateFormat("");
            // TODO ATRIBUIR DATA
            saleList.add(sale);

        }
// Senão somente atualiza a quantidade
        else {
            saleList.get(saleList.indexOf(product)).setQuantity(sale.getQuantity()+1);
        }


/*
        realm = Realm.getDefaultInstance();
        Sale sale = realm.createObject(Sale.class);
        realm.commitTransaction();
*/
        notifyItemChanged(clickedPos);
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
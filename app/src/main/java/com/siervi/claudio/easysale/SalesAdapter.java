package com.siervi.claudio.easysale;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Claudio on 15/04/2016.
 */
public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.ViewHolder> {

    private List<Sale> saleList;

    private Realm realm; // Verificar se essa variável é util

    public SalesAdapter(List<Sale> sales) {
        this.saleList = sales;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sales, parent, false);

        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.v_txt_id.setText(String.valueOf(saleList.get(position).getId()));
        holder.v_txt_itemName.setText(saleList.get(position).getProduct().getName());
        holder.v_txt_qtd.setText(String.valueOf(saleList.get(position).getQuantity()));

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView v_txt_id, v_txt_itemName, v_txt_qtd;

        public ViewHolder(View view) {
            super(view);
            v_txt_id = (TextView) view.findViewById(R.id.txt_id);
            v_txt_itemName = (TextView) view.findViewById(R.id.txt_itemName);
            v_txt_qtd = (TextView) view.findViewById(R.id.txt_qtd);

        }
    }


    @Override
    public int getItemCount() {

        return saleList.size();
    }
}

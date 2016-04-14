package com.siervi.claudio.easesale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Claudio on 09/04/2016.
 */
public class ProductsAdapter {
/*
    private LayoutInflater inflater;

    private List<list_products> products = null;

    public ProductsAdapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public void setData(List<Ingresso> details) {
        this.ingressos = details;
    }

    @Override
    public int getCount() {
        if (ingressos == null) {
            return 0;
        }
        return ingressos.size();
    }


    @Override
    public Object getItem(int position) {
        if (ingressos == null || ingressos.get(position) == null) {
            return null;
        }
        return ingressos.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent) {
        if (currentView == null) {
            currentView = inflater.inflate(R.layout.ingresso_list_item, parent, false);
        }

        Ingresso ingresso = ingressos.get(position);

        if (ingresso != null) {
            ((TextView) currentView.findViewById(R.id.txt_nome)).setText(ingresso.getNome());
            ((TextView) currentView.findViewById(R.id.txt_documento)).setText(ingresso.getDocumento());
            ((CheckBox) currentView.findViewById(R.id.cb_checkedIn)).setChecked(ingresso.isChecked());

        }

        return currentView;
    } */

}

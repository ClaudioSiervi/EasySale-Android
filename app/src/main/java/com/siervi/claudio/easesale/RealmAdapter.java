package com.siervi.claudio.easesale;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Claudio on 09/04/2016.
 */

public class RealmAdapter {}
  /*  private Realm realm;
    private ListView lvIngressos;
    private ProductsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.SalesActivity);

        setUI();
        setActions();

    }

    @Override
    public void onResume() {
        super.onResume();

        // Load from file "cities.json" first time
        if(mAdapter == null) {
            List<Ingresso> ingressos = realm.where(Ingresso.class).findAll();

            //This is the GridView adapter
            mAdapter = new IngressoAdapter(this);
            mAdapter.setData(ingressos);

            //This is the GridView which will display the list of cities
            lvIngressos = (ListView) findViewById(R.id.lst_ingressos);
            lvIngressos.setAdapter(mAdapter);
//            mGridView.setOnItemClickListener(GridViewExampleActivity.this);
//            mAdapter.notifyDataSetChanged();
//            mGridView.invalidate();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close(); // Remember to close Realm when done.
    }

    private void setUI() {
        lvIngressos = (ListView) findViewById(R.id.lst_ingressos);
    }

    private void setActions() {
    }


}*/

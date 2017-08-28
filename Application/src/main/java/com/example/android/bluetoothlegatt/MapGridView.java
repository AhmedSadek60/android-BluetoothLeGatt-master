package com.example.android.bluetoothlegatt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by ahmed on 8/27/2017.
 */

public class MapGridView extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_page);

        GridView gridview = (GridView) findViewById(R.id.map_grid);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MapGridView.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }


}

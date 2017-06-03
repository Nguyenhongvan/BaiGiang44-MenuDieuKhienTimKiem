package com.vansuzy.baigiang44_menudieukhientimkiem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView lvBaiHat;
    ArrayList<String> dsBaiHat;
    ArrayAdapter<String> adapterBaiHat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
    }

    private void addControls() {
        lvBaiHat = (ListView) findViewById(R.id.lvBaiHat);
        dsBaiHat = new ArrayList<>();
        dsBaiHat.addAll(Arrays.asList(getResources().getStringArray(R.array.arrBaiHat)));
        adapterBaiHat = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                dsBaiHat
        );
        lvBaiHat.setAdapter(adapterBaiHat);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_timkiem, menu);
        MenuItem mnuSearch = menu.findItem(R.id.mnuSearch);
        SearchView searchView = (SearchView) mnuSearch.getActionView();  // tới đây chúng ta đã có 1 control có khả năng tìm kiếm
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterBaiHat.getFilter().filter(newText);  // tìm kiếm bằng cách sử dụng ArrayAdapter
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}

package com.example.viikko11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Storage itemStorage;
    private RecyclerView recyclerView;
    private ItemListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemStorage = Storage.getInstance();
        recyclerView = findViewById(R.id.rvItemList);
        adapter = new ItemListAdapter(getApplicationContext(), itemStorage.getItems());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public void switchToAddItem(View view) {
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);
    }

    public void sortListByName(View view) {
        Storage.getInstance().sortByName();
        adapter.notifyDataSetChanged();
    }

    public void sortListByTime(View view) {
        Storage.getInstance().sortByDate();
        adapter.notifyDataSetChanged();
    }
}
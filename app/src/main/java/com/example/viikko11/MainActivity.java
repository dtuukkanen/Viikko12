package com.example.viikko11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.viikko11.fragments.FragmentAdd;
import com.example.viikko11.fragments.FragmentMain;

public class MainActivity extends AppCompatActivity {
    private Storage itemStorage;
    private RecyclerView recyclerView;
    private ItemListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fragmentMain = findViewById(R.id.btnMain);
        Button fragmentAdd = findViewById(R.id.btnAdd);

        fragmentMain.setOnClickListener(listener);
        fragmentAdd.setOnClickListener(listener);
    }

    private View.OnClickListener listener = view -> {
        Fragment fragment;

        switch (view.getId()) {
            case R.id.btnAdd:
                fragment = new FragmentAdd();
                break;
            default:
                fragment = new FragmentMain();
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, fragment)
                .commit();
    };
}
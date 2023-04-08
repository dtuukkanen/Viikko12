package com.example.viikko11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        context = AddItemActivity.this;
    }

    public void addItem(View view) {
        String textItemNotes = ((EditText)findViewById(R.id.editNotes)).getText().toString();

        Storage.getInstance().addItem(new Item(textItemNotes));
    }
}
package com.example.gohasu.notes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    String content;
    EditText editText;
    int noteNumber;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        String updatedContent = editText.getText().toString();

        MainActivity.arrayList.set(noteNumber, updatedContent);
        MainActivity.arrayAdapter.notifyDataSetChanged();

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.gohasu.notes", Context.MODE_PRIVATE);

        try {
            sharedPreferences.edit().putString("notes", ObjectSerializer.serialize(MainActivity.arrayList)).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = findViewById(R.id.editText2);

        noteNumber = getIntent().getIntExtra("noteNo", -1);

        if (noteNumber != -1) {
            editText.setText(MainActivity.arrayList.get(noteNumber));
        }

//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });


    }
}

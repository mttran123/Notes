package com.example.gohasu.notes;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.io.IOException;

public class ThirdActivity extends AppCompatActivity {

    EditText editText;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        MainActivity.arrayList.add(editText.getText().toString());
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
        setContentView(R.layout.activity_third);

        editText = findViewById(R.id.editText3);


    }
}

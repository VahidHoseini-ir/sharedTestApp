package com.example.sheardtestapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
//sadfsadfasdfasdf

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView btn_test = findViewById(R.id.btn_test);
        TextView test2 = findViewById(R.id.test2);

        sharedPref = getApplicationContext().getSharedPreferences("test_app_setting", Context.MODE_PRIVATE);

        editor = sharedPref.edit();


        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("test_key","12365464798789");
                editor.apply();
            }
        });

        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test2.setText(getTestKey());
            }
        });

    }

    private String getTestKey(){
       return sharedPref.getString("test_key", "");
    }



}
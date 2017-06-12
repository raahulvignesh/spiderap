package com.example.rahul.spiderappfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tx;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tx = (TextView) findViewById(R.id.textView);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("                          Display");

        textboxchange();

    }

    public void textboxchange(){

        Bundle bundle = getIntent().getExtras();
        String str = bundle.getString("Addeditem");
        tx.setText(str);
    }


}

package com.example.rahul.spiderappfinal;

import android.content.Intent;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText ed;
    Button bt;
    EditText ed1;
    Toolbar toolbar;
    ArrayList<String> arr;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listitem);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("                      List Creater");
        ed = (EditText) findViewById(R.id.editText2);
        ed1= (EditText) findViewById(R.id.editText3);
        arr = new ArrayList<String>();
        listViewFunction();
    }
    public  void  onClickAdd(View v){

        String str = ed.getText().toString();
        arr.add(str);
        arrayAdapter.notifyDataSetChanged();
    }

    public  void onclickRemove(View v) {

        try {
            int num = Integer.parseInt(ed1.getText().toString());
            String str = arr.get(num);
            arr.remove(num);
            arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arr);
            listView.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            Toast.makeText(this, "NO ITEM FOUND", Toast.LENGTH_LONG).show();
        }
    }
    public void listViewFunction() {

        arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arr);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("Addeditem",listView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}

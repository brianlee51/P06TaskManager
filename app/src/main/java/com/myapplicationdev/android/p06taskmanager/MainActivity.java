package com.myapplicationdev.android.p06taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    Button btnAdd;
    ArrayList<String> task;
    ArrayList<Task> tasks;
    ArrayAdapter<Task> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.taskListView);
        btnAdd = findViewById(R.id.btnAdd);

        task = new ArrayList<String>();
        DBHelper db = new DBHelper(MainActivity.this);
        tasks = db.getTasks();
        aa = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1 ,tasks);
        lv.setAdapter(aa);
        aa.notifyDataSetChanged();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddActivity.class);
                startActivityForResult(intent, 9);
            }
        });
    }
}

package com.example.sortingalgorithmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.listView);
        ArrayList<String> arr=new ArrayList<>();
        arr.add("Bubble Sort");
        arr.add("Selection Sort");
        arr.add("Insertion Sort");
        arr.add("Merge Sort");
        arr.add("Quick Sort");
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent = new Intent(MainActivity.this, BubbleSort.class);
                    startActivity(intent);
                }
                else if(position==1)
                {
                    Intent intent1 = new Intent(MainActivity.this, SelectionSort.class);
                    startActivity(intent1);
                }
                else if(position==2)
                {
                    Intent intent2 = new Intent(MainActivity.this, InsertionSort.class);
                    startActivity(intent2);
                }
                else  if(position==3)
                {
                    Intent intent3 = new Intent(MainActivity.this, MergeSort.class);
                    startActivity(intent3);
                }
                else
                {
                    Intent intent4 = new Intent(MainActivity.this, QuickSort.class);
                    startActivity(intent4);
                }
            }
        });

    }
}
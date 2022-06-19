package com.example.sortingalgorithmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class InsertionSort extends AppCompatActivity {
    Button sort2;
    EditText enter2;
    TextView ans2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion_sort);
        sort2 = findViewById(R.id.sort2);
        enter2 = findViewById(R.id.enter);
        ans2 = findViewById(R.id.ans);
        sort2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] numberList = enter2.getText().toString().split(",");
                Integer[] arr = new Integer[numberList.length];
                for (int i = 0; i < numberList.length; i++) {
                    arr[i] = Integer.parseInt(numberList[i]);//conversion of string of arrays into integer of arrays
                }
                insertionSort(arr, arr.length);
                ans2.setText(Arrays.toString(arr));
            }
        });

    }

    static void insertionSort(Integer arr[], int n) {
        // Base case
        if (n <= 1)
            return;

        // Sort first n-1 elements
        insertionSort(arr, n - 1);

        // Insert last element at its correct position
        // in sorted array.
        int last = arr[n - 1];
        int j = n - 2;

        /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }
}
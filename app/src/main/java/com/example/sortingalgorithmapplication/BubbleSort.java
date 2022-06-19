package com.example.sortingalgorithmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class BubbleSort extends AppCompatActivity {
    Button sort;
    EditText enter;
    TextView ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_sort);
        sort=findViewById(R.id.sort);
        enter=findViewById(R.id.enter);
        ans=findViewById(R.id.ans);
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] numberList=enter.getText().toString().split(",");
                Integer[] arr=new Integer[numberList.length];
                for(int i=0;i<numberList.length;i++)
                {
                    arr[i]=Integer.parseInt(numberList[i]);//conversion of string of arrays into integer of arrays
                }
                bubbleSort(arr,arr.length);
                ans.setText(Arrays.toString(arr));
            }
        });

    }
    private void bubbleSort(Integer[]arr,int length)
    {
        if (length == 1)
            return;

        int count = 0;
        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        for (int i=0; i<length-1; i++)
            if (arr[i] > arr[i+1])
            {
                // swap arr[i], arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                count = count+1;
            }

        // Check if any recursion happens or not
        // If any recursion is not happen then return
        if (count == 0)
            return;

        // Largest element is fixed,
        // recur for remaining array
        bubbleSort(arr, length-1);
    }
}
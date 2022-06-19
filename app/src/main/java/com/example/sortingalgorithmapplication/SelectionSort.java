package com.example.sortingalgorithmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class SelectionSort extends AppCompatActivity {
    Button sort1;
    EditText enter1;
    TextView ans1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_sort);
        sort1=findViewById(R.id.sort1);
        enter1=findViewById(R.id.enter1);
        ans1=findViewById(R.id.ans1);

        sort1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] numberList=enter1.getText().toString().split(",");
                Integer[] arr=new Integer[numberList.length];
                for(int i=0;i<numberList.length;i++)
                {
                    arr[i]=Integer.parseInt(numberList[i]);//conversion of string of arrays into integer of arrays
                }
                SelectionSort(arr,arr.length,0);
                ans1.setText(Arrays.toString(arr));
            }
        });

    }
    static int minIndex(Integer a[], int i, int j)
    {
        if (i == j)
            return i;

        // Find minimum of remaining elements
        int k = minIndex(a, i + 1, j);

        // Return minimum of current and remaining.
        return (a[i] < a[k])? i : k;
    }
    private void SelectionSort(Integer[]a,int n,int index)
    {
// Return when starting and size are same
        if (index == n)
            return;

        // calling minimum index function for minimum index
        int k = minIndex(a, index, n-1);

        // Swapping when index nd minimum index are not same
        if (k != index){
            // swap
            int temp = a[k];
            a[k] = a[index];
            a[index] = temp;
        }
        // Recursively calling selection sort function
        SelectionSort(a, n, index + 1);
    }
}
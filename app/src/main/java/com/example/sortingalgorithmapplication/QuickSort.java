package com.example.sortingalgorithmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class QuickSort extends AppCompatActivity {
    Button sort4;
    EditText enter4;
    TextView ans4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_sort);
        sort4=findViewById(R.id.sort4);
        enter4=findViewById(R.id.enter4);
        ans4=findViewById(R.id.ans4);
        sort4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] numberList=enter4.getText().toString().split(",");
                Integer[] arr=new Integer[numberList.length];
                for(int i=0;i<numberList.length;i++)
                {
                    arr[i]=Integer.parseInt(numberList[i]);//conversion of string of arrays into integer of arrays
                }
                quickSort(arr,0, arr.length-1);
                ans4.setText(Arrays.toString(arr));
            }
        });
    }
    static void swap(Integer[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(Integer[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot)
            {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(Integer[] arr, int low, int high)
    {
        if (low < high)
        {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
package com.example.sortingalgorithmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MergeSort extends AppCompatActivity {
    Button sort3;
    EditText enter3;
    TextView ans3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge_sort);
        sort3=findViewById(R.id.sort3);
        enter3=findViewById(R.id.enter3);
        ans3=findViewById(R.id.ans3);
        sort3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] numberList=enter3.getText().toString().split(",");
                Integer[] arr=new Integer[numberList.length];
                for(int i=0;i<numberList.length;i++)
                {
                    arr[i]=Integer.parseInt(numberList[i]);//conversion of string of arrays into integer of arrays
                }
                mergesort(arr,0,arr.length-1);
                ans3.setText(Arrays.toString(arr));
            }
        });

    }
    void merge(Integer arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void mergesort(Integer arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
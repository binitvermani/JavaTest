package com.example.binit.javatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    int[] array = new int[100];
    int count = 0;
    Button btnAdd, btnRemove, btnTarget;
    TextView textViewOutput;
    EditText editTextAdd, editTextTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);
        btnTarget = findViewById(R.id.btnTarget);
        textViewOutput = findViewById(R.id.textViewOutput);
        editTextAdd = findViewById(R.id.editTextAddNumber);
        editTextTarget = findViewById(R.id.editTextTargetNumber);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(0 != editTextAdd.getText().toString().trim().length()) {

                    addElement(Integer.valueOf(editTextAdd.getText().toString().trim()));
                    editTextAdd.setText("");
                } else {

                    Toast.makeText(getApplicationContext(),"Please enter the number",Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                removeElement();
            }
        });

        btnTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(0 != editTextTarget.getText().toString().trim().length()) {

                    targetElement(Integer.valueOf(editTextTarget.getText().toString().trim()));
                    editTextTarget.setText("");
                } else {

                    Toast.makeText(getApplicationContext(),"Please enter the number",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Add Element

    void addElement(Integer integer) {

        if(0 == count) {

            array[0] = integer;
        } else {

            array[count] = integer;
        }

        count++;

        textViewOutput.setText("");

        for(int index = 0; index < array.length; index++) {

            if(0 != array[index]) {

                textViewOutput.setText(textViewOutput.getText()+" "+array[index]);
            }
        }
    }

    //Remove Element

    void removeElement() {

        int newCount = count;
        int indexFinal = -1;

        if(0 != count) {

            for (int index = 0; index < array.length; index++) {

                if (0 != array[index]) {

                    newCount--;

                    if(0 == newCount) {

                        indexFinal = index;
                        break;
                    }
                }
            }

            count--;
            array[indexFinal] = 0;
        }

        textViewOutput.setText("");

        for(int index = 0; index < array.length; index++) {

            if(0 != array[index]) {

                textViewOutput.setText(textViewOutput.getText()+" "+array[index]);
            }
        }
    }

    //Remove the elements greater than target number

    void targetElement(Integer integer) {

        int target_index = 0;

        for(int index = 0; index < array.length; index++) {

            if(0 != array[index]) {

                if (integer < array[index]) {

                    array[index] = 0;
                } else {

                    target_index++;
                }
            }
        }

        count = target_index;

        textViewOutput.setText("");

        for(int index = 0; index < array.length; index++) {

            if(0 != array[index]) {

                textViewOutput.setText(textViewOutput.getText()+" "+array[index]);
            }
        }
    }
}
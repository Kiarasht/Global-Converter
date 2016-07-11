package com.restart.globalconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;


public class Convert extends AppCompatActivity {
    private TextView source_textView;
    private TextView destination_textView;
    private Spinner source_Spinner;
    private Spinner destination_Spinner;
    private String input = "0";
    private String output = "0";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_weight);

        source_textView = (TextView) findViewById(R.id.source_textView);
        destination_textView = (TextView) findViewById(R.id.destination_textView);
        source_Spinner = (Spinner) findViewById(R.id.source_spinner);
        destination_Spinner = (Spinner) findViewById(R.id.destination_spinner);
        source_textView.setText(input);
        destination_textView.setText(output);
    }

    public void button(View view) {
        if (source_textView.getText().toString().equals("0")) input = "";

        switch (view.getId()) {
            case R.id.zero_0:
                input += 0;
                break;
            case R.id.one_1:
                input += 1;
                break;
            case R.id.two_2:
                input += 2;
                break;
            case R.id.three_3:
                input += 3;
                break;
            case R.id.four_4:
                input += 4;
                break;
            case R.id.five_5:
                input += 5;
                break;
            case R.id.six_6:
                input += 6;
                break;
            case R.id.seven_7:
                input += 7;
                break;
            case R.id.eight_8:
                input += 8;
                break;
            case R.id.nine_9:
                input += 9;
                break;
            case R.id.sign:
                boolean check = false;
                if (input.equals("")) return;
                if (!input.contains(".")) check = true;
                input = String.valueOf(Double.valueOf(input) * -1);
                if (check) input = input.substring(0,input.length()-2);
                break;
            case R.id.period:
                if (!input.contains(".")) input += ".";
                break;
        }

        source_textView.setText(input);
    }

    public void backspace(View view) {
        if (input.length() < 1) return;

        input = input.substring(0,input.length()-1);
        source_textView.setText(input);
    }

    public void swap(View view) {
        String temp = destination_textView.getText().toString();
        destination_textView.setText(source_textView.getText());
        source_textView.setText(temp);
    }

    public void clear(View view) {
        source_textView.setText("0");
        destination_textView.setText("0");
    }
}

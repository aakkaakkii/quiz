package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;

    private double operand = 0;
    private String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

    }

    public void numberClick(View view) {

        if (!(view instanceof TextView)) {
            return;
        }

        TextView clicked = (TextView) view;

        String number = clicked.getText().toString();
        String res = resultTextView.getText().toString();

        if (Objects.equals(res, "0")) {
            res = "";
        }

        String result = res + number;

        resultTextView.setText(result);

    }

    public void operationClick(View view) {

        if (!(view instanceof TextView)) {
            return;
        }

        if (!TextUtils.isEmpty(resultTextView.getText())) {
            operand = Double.parseDouble(resultTextView.getText().toString());
        }

        resultTextView.setText("");

        operation = ((TextView) view).getText().toString();

    }

    public void equalsClick(View view) {

        String secOperandText = resultTextView.getText().toString();
        double secOperand = 0.0;

        if (!TextUtils.isEmpty(secOperandText)) {
            secOperand = Double.parseDouble(secOperandText);
        }

        switch (this.operation) {
            case "+":
                resultTextView.setText(String.valueOf(operand + secOperand));
                break;
            case "-":
                resultTextView.setText(String.valueOf(operand - secOperand));
                break;
            case "*":
                resultTextView.setText(String.valueOf(operand * secOperand));
                break;
            case "/":
                resultTextView.setText(String.valueOf(operand / secOperand));
                break;
        }

    }

    public void delClick(View view) {
        String res = resultTextView.getText().toString();

        if (TextUtils.isEmpty(res)) {
            return;
        }

        resultTextView.setText(res.substring(0, res.length() - 1));
    }

    public void clearClick(View view) {
        operand = 0;
        operation = "";
        resultTextView.setText("");
    }

}
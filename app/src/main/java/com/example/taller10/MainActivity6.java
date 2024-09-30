package com.example.taller10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity6 extends AppCompatActivity {

    private TextView result;
    private String currentInput = "";
    private String operator = "";
    private double firstOperand = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        result = findViewById(R.id.result);


        int[] numberButtonIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9
        };

        for (int id : numberButtonIds) {
            Button numberButton = findViewById(id);
            numberButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button button = (Button) view;
                    currentInput += button.getText().toString();
                    result.setText(currentInput);
                }
            });
        }


        int[] operatorButtonIds = {
                R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply, R.id.buttonDivide
        };

        for (int id : operatorButtonIds) {
            Button operatorButton = findViewById(id);
            operatorButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button button = (Button) view;
                    operator = button.getText().toString();
                    firstOperand = Double.parseDouble(currentInput);
                    currentInput = "";
                }
            });
        }


        Button equalsButton = findViewById(R.id.buttonEquals);
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double secondOperand = Double.parseDouble(currentInput);
                double resultValue = 0;

                switch (operator) {
                    case "+":
                        resultValue = firstOperand + secondOperand;
                        break;
                    case "-":
                        resultValue = firstOperand - secondOperand;
                        break;
                    case "*":
                        resultValue = firstOperand * secondOperand;
                        break;
                    case "/":
                        if (secondOperand != 0) {
                            resultValue = firstOperand / secondOperand;
                        } else {
                            result.setText("Error");
                            return;
                        }
                        break;
                }

                result.setText(String.valueOf(resultValue));
                currentInput = String.valueOf(resultValue);
            }
        });


        Button clearButton = findViewById(R.id.buttonClear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput = "";
                operator = "";
                firstOperand = 0;
                result.setText("0");
            }
        });


        Button dotButton = findViewById(R.id.buttonDot);
        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!currentInput.contains(".")) {
                    currentInput += ".";
                    result.setText(currentInput);
                }
            }
        });

        Button buttonRegresar = findViewById(R.id.regresa);
        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity6.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

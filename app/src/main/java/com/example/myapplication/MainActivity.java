package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // ---- Initialize variables for reference ---- \\
    private EditText textBoxOperand1;
    private EditText textBoxOperand2;
    private TextView textLabelResult;

    private Button buttonSubtract;
    private Button buttonAdd;
    private Button buttonMultiply;
    private Button buttonDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Instantiates XML elements into accessible objects in memory
        setContentView(R.layout.activity_main);

        // Get references to GUI objects in activity_main.

        // ---- TextLabels ---- \\

        textLabelResult = (TextView) findViewById(R.id.textLabelResult);

        // ---- TextBox ---- \\

        textBoxOperand1 = (EditText) findViewById(R.id.textBoxOperand1);
        textBoxOperand2 = (EditText) findViewById(R.id.textBoxOperand2);

        // ---- Buttons ---- \\

        buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);

        Button[] buttonList = { buttonSubtract, buttonAdd, buttonMultiply, buttonDivide };

        // Button Events

        // Passes an interface containing View.OnClickListener's attributes
        // Overrides the defaulted onClick() method of View.OnClickListener()

        for (Button i : buttonList ) {
            i.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        double operand1 = 0.0;
                        double operand2 = 0.0;
                        double result;

                        String operator = (String) i.getText();

                        if ( ! textBoxOperand1.getText().toString().equals("") ) {
                            operand1 = Double.parseDouble(textBoxOperand1.getText().toString());
                        }

                        if ( ! textBoxOperand2.getText().toString().equals("") ) {
                            operand2 = Double.parseDouble(textBoxOperand2.getText().toString());
                        }

                        switch (operator) {
                            case "+":
                                result = operand1 + operand2;
                                break;

                            case "—":
                                result = operand1 - operand2;
                                break;

                            case "×":
                                result = operand1 * operand2;
                                break;

                            case "÷":
                                if (operand2 == 0.0) {
                                    result = Double.NaN;
                                }
                                else {
                                    result = operand1 / operand2;
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + operator);
                        }
                        if ( Math.abs(result) % 1.0 > 0 || Math.abs(result) > 9999999.0 ) {
                            textLabelResult.setText(Double.toString(result));
                        } else {
                            textLabelResult.setText(String.format("%.0f", result));
                        }
                    }
                    catch (Exception e) {
                        textLabelResult.setText("Err");
                    }
                }
            });
        }

        /*
        buttonAdd.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                double operand1 = Double.parseDouble(textBoxOperand1.getText().toString());
                double operand2 = Double.parseDouble(textBoxOperand2.getText().toString());

                double result = operand1 + operand2;
                textLabelResult.setText(Double.toString(result));

            }

        });

        buttonSubtract.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
            }

        });

        buttonMultiply.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
            }

        });

        buttonDivide.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
            }

        });
    */

    }


}
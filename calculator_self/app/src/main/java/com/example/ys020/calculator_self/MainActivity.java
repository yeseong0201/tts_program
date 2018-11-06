package com.example.ys020.calculator_self;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String number1="";// 위에 올릴꺼 가짜
    String number2=""; // 찐
    Button plus, minus, multi, div, equal, doc;
    Button ac;
//    String number;
    int value;
    int DIVISION = 0;
    int PLUS = 1;
    int MULTI = 2;
    int MINUS = 3;
    double d1;
    double d2;
    String history = "";
    TextView Text;
    TextView Uptext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Text = findViewById(R.id.text);
        Uptext = findViewById(R.id.uptext);
        number = "";
        div = findViewById(R.id.div);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multi = findViewById(R.id.multi);
        equal = findViewById(R.id.equal);
        doc = findViewById(R.id.point);

        div.setOnClickListener(mListener);
        plus.setOnClickListener(mListener);
        equal.setOnClickListener(mListener);
        multi.setOnClickListener(mListener);
        minus.setOnClickListener(mListener);

        ac = findViewById(R.id.AC);
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //number = "";
                Text.setText("");
                Uptext.setText("");
                d1 = d2 = 0;
                history = number1= number2="";
            }

        });
    }

    Button.OnClickListener mListener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
if(Text.getText().toString()==null){
    Toast.makeText(MainActivity.this,"수를 입력하세요.",Toast.LENGTH_SHORT).show();
}
            switch (view.getId()) {

                case R.id.div:
                    number1 = Text.getText().toString();
                    history = Text.getText().toString()+"÷";

                    Text.setText("");
                    // uptext = text.getText().toString();
                    value = DIVISION;
                    Toast.makeText(MainActivity.this, "÷", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.plus:
                    number1 = Text.getText().toString();
                    history = Text.getText().toString()+"+";
                    Text.setText("");
                    value = PLUS;
                    history = equal.getText().toString() + "+";
                    Toast.makeText(MainActivity.this, "+", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.multi:
                    number1 = Text.getText().toString();
                    history = Text.getText().toString()+"x";
                    Text.setText("");
                    value = MULTI;
                    Toast.makeText(MainActivity.this, "X", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.equal:
                    if (value == MULTI) {
                        Text.setText("" + (Double.parseDouble(number1) * Double.parseDouble(Text.getText().toString())));
                    } else if (value == MINUS) {
                        Text.setText("" + (Double.parseDouble(number1) - Double.parseDouble(Text.getText().toString())));

                    } else if (value == PLUS) {
                        Text.setText("" + (Double.parseDouble(number1) + Double.parseDouble(Text.getText().toString())));
                    } else if (value == DIVISION) {
                        Text.setText("" + (Double.parseDouble(number1) / Double.parseDouble(Text.getText().toString())));
                    }

                    number1 = Text.getText().toString();
                    break;
            }
        }
    };

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                Text.setText(Text.getText().toString() + 0);
                break;
            case R.id.btn_1:
                Text.setText(Text.getText().toString() + 1);
                break;
            case R.id.btn_2:
                Text.setText(Text.getText().toString() + 2);
                break;
            case R.id.btn_3:
                Text.setText(Text.getText().toString() + 3);
                break;
            case R.id.btn_4:
                Text.setText(Text.getText().toString() + 4);
                break;
            case R.id.btn_5:
                Text.setText(Text.getText().toString() + 5);
                break;
            case R.id.btn_6:
                Text.setText(Text.getText().toString() + 6);
                break;
            case R.id.btn_7:
                Text.setText(Text.getText().toString() + 7);
                break;
            case R.id.btn_8:
                Text.setText(Text.getText().toString() + 8);
                break;
            case R.id.btn_9:
                Text.setText(Text.getText().toString() + 9);
                break;
            case R.id.point:
                Text.setText(Text.getText().toString() + ".");
                break;
//            case R.id.plus:   text.setText(text.getText().toString()+"+");break;
//            case R.id.minus:  text.setText(text.getText().toString()+"-");break;
//            case R.id.div:   text.setText(text.getText().toString()+"÷");break;
//            case R.id.multi: text.setText(text.getText().toString()+"X");break;
//            case R.id.equal: text.setText(text.getText().toString()+"=");break;
//

        }

    }
}

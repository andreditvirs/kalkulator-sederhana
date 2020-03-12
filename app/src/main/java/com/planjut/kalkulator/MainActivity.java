package com.planjut.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnMinus, btnPlus, btnMultiply, btnDivision, btnEqual, btnClear, btnDot, btnPercent, btnBracket;
    TextView tvInput, tvOutput, btnRiwayat;
    boolean checkBracket = false;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDot = findViewById(R.id.btnDot);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivision = findViewById(R.id.btnDivision);
        btnPercent = findViewById(R.id.btnPercent);
        btnBracket = findViewById(R.id.btnBracket);

        btnEqual = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClear);

        btnRiwayat = findViewById(R.id.btnRiwayat);
        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText("");
                tvOutput.setText("");
                checkBracket=false;
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputIsEmpty()){
                    // do nothing
                }else {
                    if(!checkOperator()){
                        if(defaultDot()){
                            process = tvInput.getText().toString();
                            tvInput.setText(process + "+");
                        }else{
                            process = tvInput.getText().toString();
                            tvInput.setText(process + "+");
                        }
                    }
                }
                
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputIsEmpty()){
                    // do nothing
                }else {
                    if(!checkOperator()){
                        if(defaultDot()){
                            process = tvInput.getText().toString();
                            tvInput.setText(process + "-");
                        }else{
                            process = tvInput.getText().toString();
                            tvInput.setText(process + "-");
                        }
                    }
                }
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputIsEmpty()){
                    // do nothing
                }else {
                    if(!checkOperator()){
                        if(defaultDot()){
                            process = tvInput.getText().toString();
                            tvInput.setText(process + "×");
                        }else{
                            process = tvInput.getText().toString();
                            tvInput.setText(process + "×");
                        }
                    }
                }
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputIsEmpty()){
                    // do nothing
                }else {
                    if(!checkOperator()){
                        if(defaultDot()){
                            process = tvInput.getText().toString();
                            tvInput.setText(process + "÷");
                        }else{
                            process = tvInput.getText().toString();
                            tvInput.setText(process + "÷");
                        }
                    }
                }
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();

                if(inputIsEmpty()){
                        tvInput.setText(process + "0.");
                }else{
                    int i = process.length()-1;
                    while(i > -1 && !checkOperator()){
                        if(process.charAt(i) == '+' || process.charAt(i) == '-' || process.charAt(i) == '×' || process.charAt(i) == '÷' ){
                                // jika ada operator sebelumny maka boleh menulis titik
                            tvInput.setText(process + ".");
                            break;
                        }else if(process.charAt(i) == '.'){
                            // jika ada '.' maka langsung tolak/break
                            break;
                        }else if (i == 0){
                            // jika tidak ada . dan sudah habis dicek semua maka tulis saja .
                            tvInput.setText(process + ".");
                            break;
                        }
                        i--;
                    }
                }
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputIsEmpty()){
                    // do nothing
                }else {
                    if(!checkOperator()){
                        if(defaultDot()){
                            process = tvInput.getText().toString();
                            tvInput.setText(process + "%");
                        }else{
                            process = tvInput.getText().toString();
                            tvInput.setText(process + "%");
                        }
                    }
                }
            }
        });

        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                if(checkBracket){
                    tvInput.setText(process + ")");
                    checkBracket = false;
                }else{
                    tvInput.setText(process + "(");
                    checkBracket = true;
                }
                
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputIsEmpty()){
                    // do nothing
                }else {
                    process = tvInput.getText().toString();
                    process = process.replaceAll("×", "*");
                    process = process.replaceAll("%", "/100");
                    process = process.replaceAll("÷", "/");

                    Context rhino = org.mozilla.javascript.Context.enter();

                    rhino.setOptimizationLevel(-1);
                    String finalResult = "";
                    boolean isEmpty = true;

                    try {
                        Scriptable scriptable = rhino.initSafeStandardObjects();
                        finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
                    } catch (Exception e) {
                        finalResult = "Error";
                    }

                    tvOutput.setText(finalResult);
                }
            }
        });
    }

    private boolean inputIsEmpty(){
        process = tvInput.getText().toString();
        try{
            int i = process.length();
            if(i == 0){
                return true;
            }
        }catch (NullPointerException e){
            System.out.println(e);
        }
        return false;
    }

        private boolean checkOperator(){
            process = tvInput.getText().toString();
            int i = process.length()-1;
            switch (process.charAt(i)){
                case '+' : case '-' : case '×' : case '÷' : case '%' : case '(':  /*do nothing */ return true;
                default : return false;
            }
        }

        private boolean defaultDot(){
            process = tvInput.getText().toString();
            int i = process.length()-1;
            if(process.charAt(i) == '.'){
                tvInput.setText(process + "0");
                return true;
            }
            return false;
        }
    }

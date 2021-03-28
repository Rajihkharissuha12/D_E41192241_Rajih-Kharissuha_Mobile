package com.example.aplikasipertama;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display= findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1 );
        }
        else{
            display.setText(String.format("%s%s%s", leftStr,strToAdd,rightStr ));
            display.setSelection(cursorPos + 1 );
        }
    }

    public void zeroBTN(View View){
        updateText("0");
    }
    public void clear(View View){
        display.setText("");
    }
    public void parenthesesBTN(View View){
        int cursorPOS = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLen = display.getText().length();

        for (int i=0 ; i < cursorPOS; i++){
            if (display.getText().toString().substring(i, i+1).equals("(")){
                openPar += 1;
            }
            if (display.getText().toString().substring(i, i+1).equals(")")){
                closedPar += 1;
            }
        }
        if (openPar == closedPar || display.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText("(");
        }
        else if (closedPar < openPar && !display.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText(")");
        }
        display.setSelection(cursorPOS + 1);
    }
    public void exponentBTN(View View){
        updateText("^");
    }
    public void divideBTN(View View){
        updateText("÷");
    }
    public void oneBTN(View View){
        updateText("1");
    }
    public void twoBTN(View View){
        updateText("2");
    }
    public void threeBTN(View View){
        updateText("3");
    }
    public void multiplyBTN(View View){

    }

    public void fourBTN(View View){
        updateText("4");
    }
    public void fiveBTN(View View){
        updateText("5");
    }
    public void sixBTN(View View){
        updateText("6");
    }
    public void subtractBTN(View View){
        updateText("-");
    }
    public void sevenBTN(View View){
        updateText("7");
    }
    public void eightBTN(View View){
        updateText("8");
    }
    public void nineBTN(View View){
        updateText("9");
    }
    public void addBTN(View View){
        updateText("+");
    }
    public void PlusMinusBTN(View View){
        updateText("-");
    }
    public void pointBTN(View View){
        updateText(".");
    }
    public void equalsBTN(View View){
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("x", "x");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

    }
    public void delete(View View){
        int cursorPOS = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPOS != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace( cursorPOS - 1, cursorPOS, "");
            display.setText(selection);
            display.setSelection(cursorPOS - 1);
        }
    }


}
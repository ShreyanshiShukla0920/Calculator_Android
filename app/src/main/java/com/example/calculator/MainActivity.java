package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;
public class MainActivity extends AppCompatActivity {
    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }
    public void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }
    public void zeroBTN(View view){
        String strToAdd="0";
        updateText(strToAdd);
    }
    public void oneBTN(View view){
        String strToAdd="1";
        updateText(strToAdd);
    }
    public void twoBTN(View view){
        String strToAdd="2";
        updateText(strToAdd);
    }
    public void threeBTN(View view){
        String strToAdd="3";
        updateText(strToAdd);
    }
    public void fourBTN(View view){
        String strToAdd="4";
        updateText(strToAdd);
    }
    public void fiveBTN(View view){
        String strToAdd="5";
        updateText(strToAdd);
    }
    public void sixBTN(View view){
        String strToAdd="6";
        updateText(strToAdd);
    }
    public void sevenBTN(View view){
        String strToAdd="7";
        updateText(strToAdd);
    }
    public void eightBTN(View view){
        String strToAdd="8";
        updateText(strToAdd);
    }
    public void nineBTN(View view){
        String strToAdd="9";
        updateText(strToAdd);
    }
    public void clearBTN(View view){
        display.setText("");
    }
    public void pointBTN(View view){
        String strToAdd=".";
        updateText(strToAdd);
    }
    public void paranBTN(View view){
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textlen = display.getText().length();
        for(int i=0;i< cursorPos; i++){
            if(display.getText().toString().substring(i,i+1).equals("(")){
                openPar+=1;

            }
            else if(display.getText().toString().substring(i,i+1).equals(")")){
                closedPar+=1;
            }
        }
        if((closedPar==openPar) || (display.getText().toString().substring(textlen-1,textlen).equals("("))){
            updateText("(");
            display.setSelection(cursorPos+1);
        }
        else if(closedPar<openPar && !(display.getText().toString().substring(textlen-1,textlen).equals("("))){
            updateText(")");
            display.setSelection(cursorPos+1);
        }
    }
    public void equalBTN(View view){
        String userExp = display.getText().toString();
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

    }
    public void addBTN(View view){
        String strToAdd="+";
        updateText(strToAdd);
    }
    public void subtractBTN(View view){
        String strToAdd="-";
        updateText(strToAdd);
    }
    public void divideBTN(View view){
        String strToAdd="/";
        updateText(strToAdd);
    }
    public void multiplyBTN(View view){
        String strToAdd="*";
        updateText(strToAdd);
    }
    public void plusMinBTN(View view){
        String strToAdd="+/-";
        updateText(strToAdd);
    }
    public void expoBTN(View view){
        String strToAdd="^";
        updateText(strToAdd);
    }
    public void backBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
             selection.replace(cursorPos-1,cursorPos,"");
             display.setText(selection);
             display.setSelection(cursorPos-1);
        }
    }
}
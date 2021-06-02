package com.example.sahilpatel_n01390758_android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    ArrayList<Double> tempfigure = new ArrayList<Double>();
    double tempfigure1;
    double memory1 = 0;
    boolean allowDots = true;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("Enter a Value".equals(display.getText().toString())){
                       display.setText("");
                }
            }
        });
    }
    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int positionCursor  = display.getSelectionStart();
        String leftStr = oldStr.substring(0, positionCursor);
        String rightStr = oldStr.substring(positionCursor);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(positionCursor+1);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(positionCursor+1);
        }
    }
    public void ZeroBtn(View view){
        updateText("0");
      }
    public void OneBtn(View view){
        updateText("1");
    }
    public void TwoBtn(View view){
        updateText("2");
    }
    public void ThreeBtn(View view){
        updateText("3");
    }
    public void FourBtn(View view){
        updateText("4");
    }
    public void FiveBtn(View view){
        updateText("5");
    }
    public void SixBtn(View view){
        updateText("6");
    }
    public void SevenBtn(View view){
        updateText("7");
    }
    public void EightBtn(View view){
        updateText("8");
    }
    public void piBtn(View view){
        String oldStr = display.getText().toString();
        int positionCursor  = display.getSelectionStart();
        String leftStr = oldStr.substring(0, positionCursor);
        String rightStr = oldStr.substring(positionCursor);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText("3.14");
            display.setSelection(positionCursor+4);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, "3.14", rightStr));
            display.setSelection(positionCursor+4);
        }

    }
    public void NineBtn(View view){
        updateText("9");
    }
    public void addBtn(View view){
        updateText("+");
    }
    public void minusBtn(View view){
        updateText("-");
    }
    public void divideBtn(View view){
        updateText("/");
    }
    public void multiplyBtn(View view){
        updateText("*");
    }

    public void percentageBtn(View view){
        updateText("%");
    }
    public void expoBtn(View view){
        updateText("^");
    }
    public void dotBtn(View view){

         if(allowDots == true) {
             updateText(".");
         }
        allowDots = false;
    }
    public void clearBtn(View view){
        display.setText("");
    }
    public void memoryPlus(View view){
        tempfigure.add(Double.parseDouble(display.getText().toString()));
        memory1=memory1+tempfigure.get(0);
        tempfigure1=0;
        tempfigure.removeAll(tempfigure);
        display.setText("0");
        if (memory1 >0) { display.setText("Memory saved");
        }
    }
    public void memoryMinus(View view){
        tempfigure.add(Double.parseDouble(display.getText().toString()));
        memory1=memory1 - tempfigure.get(0);
        tempfigure1=0;
        tempfigure.removeAll(tempfigure);
        display.setText("0");
        if (memory1 >0) { display.setText("Memory minused");
        }
    }

    public void memoryRecall(View view){
        display.setText(""+memory1);
    }

    public void memoryClear(View view){
        memory1 = 0;
    }
    public void equalBtn(View view){
        String userExp = display.getText().toString();
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }
}
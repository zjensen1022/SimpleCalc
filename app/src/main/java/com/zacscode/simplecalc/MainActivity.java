package com.zacscode.simplecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText equationEditText;
    Button exponentButton;
    Button calculateButton;
    TextView resultTextView;
    static boolean isExponent = false;
    static int[][] exps;
    static int equationLength = 0;
    static Button[] numberButtons = new Button[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equationEditText = (EditText) findViewById(R.id.equationEditText);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        exponentButton = (Button) findViewById(R.id.exponentButton);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        resultTextView.setText("");
        numberButtons[0] = (Button) findViewById(R.id.button0);
        numberButtons[1] = (Button) findViewById(R.id.button1);
        numberButtons[2] = (Button) findViewById(R.id.button2);
        numberButtons[3] = (Button) findViewById(R.id.button3);
        numberButtons[4] = (Button) findViewById(R.id.button4);
        numberButtons[5] = (Button) findViewById(R.id.button5);
        numberButtons[6] = (Button) findViewById(R.id.button6);
        numberButtons[7] = (Button) findViewById(R.id.button7);
        numberButtons[8] = (Button) findViewById(R.id.button8);
        numberButtons[9] = (Button) findViewById(R.id.button9);

        for(int i = 0; i < numberButtons.length; i++)
            assignListener(numberButtons[i], i+"", equationEditText);

        equationEditText.setOnKeyListener(
                new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if(i == KeyEvent.KEYCODE_ENTER)
                            calculate(equationEditText.getText().toString(), resultTextView);
                        else{
                            int temp = equationLength;

                            if(isExponent){
                                String text = equationEditText.getText().toString();
                                Log.v("tag","Registered as isExponent");
                                if(temp < text.length()){
                                    Log.v("tag","attmepting to change text to superscript");
                                    equationEditText.setText(setSuperText(text, temp, temp+1));
                                }
                                else if(temp > text.length()){
                                    Log.v("tag","changing isExponent to false");
                                    isExponent = false;
                                    resultTextView.setText("isExponent: "+isExponent );
                                }
                            }
                        }

                        equationLength = equationEditText.getText().length();
                        return false;
                    }
                }
        );

        exponentButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if(isExponent)
                            isExponent = false;
                        else
                            isExponent = true;
                        resultTextView.setText("isExponent: "+isExponent );
                    }
                }
        );

        calculateButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        calculate(equationEditText.getText().toString(), resultTextView);
                    }
                }
        );
    }

    public static void calculate(String equation, TextView resultTextView){
        resultTextView.setText(equation);
    }

    public static String setSuperText(String text, int start, int end){
        SpannableStringBuilder ssb = new SpannableStringBuilder(text);
        ssb.setSpan(new SuperscriptSpan(),start,end,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(new RelativeSizeSpan(0.75f),start,end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb.toString();

    }

    public static void assignListener(Button b, final String s, final EditText eet){
        b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        eet.setText(eet.getText().toString()+s);
                    }
                }
        );

    }
}

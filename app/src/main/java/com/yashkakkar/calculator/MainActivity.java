package com.yashkakkar.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private EditText numberOperation;
    private TextView result;
    private float tempResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReplaceFont.replaceDefaultFont(this,"DEFAULT","Quicksand-Regular.ttf");
        numberOperation = (EditText)findViewById(R.id.numberOperation);
        numberOperation.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        result = (TextView)findViewById(R.id.result);

        Button button0 = (Button)findViewById(R.id.btn0);
        Button button1 = (Button)findViewById(R.id.btn1);
        Button button2 = (Button)findViewById(R.id.btn2);
        Button button3 = (Button)findViewById(R.id.btn3);
        Button button4 = (Button)findViewById(R.id.btn4);
        Button button5 = (Button)findViewById(R.id.btn5);
        Button button6 = (Button)findViewById(R.id.btn6);
        Button button7 = (Button)findViewById(R.id.btn7);
        Button button8 = (Button)findViewById(R.id.btn8);
        Button button9 = (Button)findViewById(R.id.btn9);
        Button buttonClose = (Button)findViewById(R.id.close);
        Button buttonDecimal = (Button)findViewById(R.id.btnDecimal);
        Button buttonSigned = (Button)findViewById(R.id.btnSigned);
        // Operation buttons
        Button buttonDivide = (Button)findViewById(R.id.btnDivide);
        Button buttonMultiply = (Button)findViewById(R.id.btnMultiply);
        Button buttonPlus = (Button)findViewById(R.id.btnPlus);
        Button buttonMinus = (Button)findViewById(R.id.btnMinus);
        Button buttonPercent = (Button)findViewById(R.id.btnPercent);
        //other buttons
        Button buttonPower = (Button) findViewById(R.id.btnPower);
        Button buttonLeftBracket = (Button)findViewById(R.id.btnLeftBracket);
        Button buttonRightBracket = (Button)findViewById(R.id.btnRightBracket);
        Button buttonDelete = (Button)findViewById(R.id.btnDelete);
        Button buttonClear = (Button)findViewById(R.id.btnClear);
        Button buttonAC = (Button)findViewById(R.id.btnAc);
        Button buttonEqualTo = (Button)findViewById(R.id.equal_to);
        //Set Button Font style
        buttonClose.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        button0.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        button1.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        button2.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        button3.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        button4.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        button5.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        button6.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        button7.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        button8.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        button9.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        buttonDecimal.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        buttonSigned.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        buttonDivide.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        buttonMultiply.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        buttonPlus.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        buttonMinus.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        buttonPercent.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        buttonPower.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        buttonLeftBracket.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        buttonRightBracket.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        buttonDelete.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        buttonClear.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        buttonAC.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        buttonEqualTo.setTypeface(FontCache.getTypeface(MainActivity.this, "Quicksand-Regular.ttf"));
        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                numberOperation.append(b.getText().toString());
            }
        };

        button0.setOnClickListener(buttonListener);
        button1.setOnClickListener(buttonListener);
        button2.setOnClickListener(buttonListener);
        button3.setOnClickListener(buttonListener);
        button4.setOnClickListener(buttonListener);
        button5.setOnClickListener(buttonListener);
        button6.setOnClickListener(buttonListener);
        button7.setOnClickListener(buttonListener);
        button8.setOnClickListener(buttonListener);
        button9.setOnClickListener(buttonListener);

        // Close the application
        View.OnClickListener closeScreen = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        };
        buttonClose.setOnClickListener(closeScreen);
        // ALL Clear Button
        View.OnClickListener allClear = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b =(Button) view;
                numberOperation.setText("");
                result.setText("");
                Toast.makeText(MainActivity.this,R.string.cleared,Toast.LENGTH_SHORT).show();
            }
        };
        buttonAC.setOnClickListener(allClear);
        // Clear Result text button working
        View.OnClickListener clearText = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b =(Button) view;
                result.setText("");
                Toast.makeText(MainActivity.this,R.string.cleared,Toast.LENGTH_SHORT).show();
            }
        };
        buttonClear.setOnClickListener(clearText);
        // Del button delete one by one
        View.OnClickListener deleteText = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOperation.getText().toString().trim().length() > 0) {
                    String result = numberOperation.getText().toString().substring(0,numberOperation.getText().toString().length() - 1);
                    numberOperation.setText(result);
                    numberOperation.setSelection(result.length());
                }
            }
        };
        buttonDelete.setOnClickListener(deleteText);
        View.OnClickListener operationListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Button b = (Button) view;
               numberOperation.append(b.getText().toString());

            }
        };

        // Type only to apply operations on operand
        buttonDivide.setOnClickListener(operationListner);
        buttonMultiply.setOnClickListener(operationListner);
        buttonMinus.setOnClickListener(operationListner);
        buttonPlus.setOnClickListener(operationListner);
        buttonLeftBracket.setOnClickListener(operationListner);
        buttonRightBracket.setOnClickListener(operationListner);

        buttonDecimal.setOnClickListener(operationListner);
        buttonPercent.setOnClickListener(operationListner);
        buttonPower.setOnClickListener(operationListner);

    /* bracket first open then close, check for open close bracket
        buttonLeftBracket.setOnClickListener(bracketListner);
        buttonRightBracket.setOnClickListener(bracketListner);
*/
    // signed should be applied to current number & decimal should be only for one time
      //  buttonSigned.setOnClickListener(numberSignedListner);



        View.OnClickListener equalToListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // perform operation and send the result back to text view
                String expression = numberOperation.getText().toString();
               Expression e = new Expression(expression);
                if(Double.toString(e.calculate()) =="NaN"){
                    Toast.makeText(MainActivity.this,R.string.error_in_expression,Toast.LENGTH_SHORT).show();
                    result.setText("Error!");
                }else {
               result.setText(Double.toString(e.calculate()));
                }
            }
        };
    buttonEqualTo.setOnClickListener(equalToListener);

    }
}

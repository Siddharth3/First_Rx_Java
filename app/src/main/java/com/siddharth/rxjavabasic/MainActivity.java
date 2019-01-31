package com.siddharth.rxjavabasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;


public class MainActivity extends AppCompatActivity {

    EditText input;
    Button done_button;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.editText_input);
        done_button = findViewById(R.id.button_done);
        result = findViewById(R.id.textView_result);

        //Handling onclick
        RxView.clicks(done_button)
                .subscribe(aVoid -> result.setText(getResources().getText(R.string.handled_by_rx_java)));

        //Handling textwatcher functionality
        RxTextView.textChanges(input)
                .subscribe(charSequence -> result.setText(charSequence));

    }
}

package com.sort.redesapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class MainActivity extends AppCompatActivity{

    EditText edit1;
    EditText edit2;
    EditText edit3;
    EditText edit4;
    EditText mascara;

    TextView net;

    Pattern p = Pattern.compile("[0-9]{1,3}");
    CharSequence secuencia1 = "Inserte solo valores numericos";
    CharSequence secuencia_mascara = "Inserte una mascara de red valida";

    int digito1;
    int digito2;
    int digito3;
    int digito4;
    int numero_mascara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.primer);
        edit2 = findViewById(R.id.segundo);
        edit3 = findViewById(R.id.tercer);
        edit4 = findViewById(R.id.cuarto);

        net = findViewById(R.id.net_id);

        mascara=findViewById(R.id.mascara);

        edit1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Matcher m = p.matcher(edit1.getText());
                if(!(m.matches())){
                    Toast toast = Toast.makeText(getApplicationContext(), secuencia1, Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    digito1 = Integer.parseInt(edit1.getText().toString());
                }
                //if(!(edit1.getText().toString().matches(""))) {

            }
        });

        edit2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Matcher m = p.matcher(edit2.getText());
                if(!(m.matches())){
                    Toast toast = Toast.makeText(getApplicationContext(), secuencia1, Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    digito2 = Integer.parseInt(edit2.getText().toString());
                }
             }
        });

        edit3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Matcher m = p.matcher(edit3.getText());
                if(!(m.matches())){
                    Toast toast = Toast.makeText(getApplicationContext(), secuencia1, Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    digito3 = Integer.parseInt(edit3.getText().toString());
                }
              }
        });

        edit4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Matcher m = p.matcher(edit4.getText());
                if(!(m.matches())){
                    Toast toast = Toast.makeText(getApplicationContext(), secuencia1, Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    digito4 = Integer.parseInt(edit4.getText().toString());
                }
               }
        });


        mascara.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int numero = Integer.parseInt(mascara.getText().toString());
                if(!(numero%8==0)){
                    Toast toast = Toast.makeText(getApplicationContext(), secuencia_mascara, Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    numero_mascara = numero;
                }
            }
        });

        

    }

}

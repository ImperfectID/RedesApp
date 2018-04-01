package com.sort.redesapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class MainActivity extends AppCompatActivity {

    EditText edit1;
    EditText edit2;
    EditText edit3;
    EditText edit4;
    EditText mascara;

    TextView net;
    TextView broadcast;

    Pattern p = Pattern.compile("([0-9]|[1-8][0-9]|9[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])");
    Pattern n = Pattern.compile("(8|16|24|32)");
    CharSequence secuencia1 = "Inserte solo valores numericos dentro del rango";
    CharSequence secuencia_mascara = "Inserte una mascara de red valida";

    int digito1;
    int digito2;
    int digito3;
    int digito4;
    int numero_mascara;
    int cont = 0;
    int c3;
    int c2;
    int c1;
    int c4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.primer);
        edit2 = findViewById(R.id.segundo);
        edit3 = findViewById(R.id.tercer);
        edit4 = findViewById(R.id.cuarto);


        net = findViewById(R.id.net_id);
        broadcast = findViewById(R.id.broadcast_text);

        mascara = findViewById(R.id.mascara);

        c1=-1; c2=-1; c3=-1; c4=-1;

        numero_mascara=32;

        mascara.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Matcher m = n.matcher(mascara.getText());
                if (!(m.matches())) {
                    Toast toast = Toast.makeText(getApplicationContext(), secuencia_mascara, Toast.LENGTH_SHORT);
                    mascara.setTextColor(Color.parseColor("#F44336"));
                    toast.show();
                } else{
                    mascara.setTextColor(Color.parseColor("#81C784"));
                    int numero = Integer.parseInt(mascara.getText().toString());
                    numero_mascara=numero;
                    if ((numero_mascara % 8 == 0) && (numero_mascara > 0)) {
                        c1 = digito1 & 255;
                    } else {
                        c1 = 0;
                    }
                    if ((numero_mascara % 8 == 0) && (numero_mascara > 8)) {
                        c2 = digito2 & 255;
                    } else {
                        c2 = 0;
                    }
                    if ((numero_mascara % 8 == 0) && (numero_mascara > 16)) {
                        c3 = digito3 & 255;
                    } else {
                        c3 = 0;
                    }
                    if ((numero_mascara % 8 == 0) && (numero_mascara > 24)) {
                        c4 = digito4 & 255;
                    } else {
                        c4 = 0;
                    }

                    net.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);
                    broadcast.setText(c1 + " ." + c2 + " ." + c3 + " ." + 255);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        edit1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Matcher m = p.matcher(edit1.getText());
                if (!(m.matches())) {
                    Toast toast = Toast.makeText(getApplicationContext(), secuencia1, Toast.LENGTH_SHORT);
                    edit1.setTextColor(Color.parseColor("#F44336"));
                    toast.show();
                } else {
                    digito1 = Integer.parseInt(edit1.getText().toString());
                    edit1.setTextColor(Color.parseColor("#81C784"));

                        if ((numero_mascara % 8 == 0) && (numero_mascara > 0)) {
                            c1 = digito1 & 255;
                        } else {
                            c1 = 0;
                        }
                        if ((c1 != -1) && (c2 != -1) && (c3 != -1) && (c4 != -1)) {
                            net.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);
                            broadcast.setText(c1 + " ." + c2 + " ." + c3 + " ." + 255);
                        }
                    }
                }


            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        edit2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Matcher m = p.matcher(edit2.getText());
                if (!(m.matches())) {
                    Toast toast = Toast.makeText(getApplicationContext(), secuencia1, Toast.LENGTH_SHORT);
                    edit2.setTextColor(Color.parseColor("#F44336"));
                    toast.show();
                } else {
                    digito2 = Integer.parseInt(edit2.getText().toString());
                    edit2.setTextColor(Color.parseColor("#81C784"));
                    if ((numero_mascara % 8 == 0) && (numero_mascara > 8)) {
                            c2 = digito2 & 255;
                        } else {
                            c2 = 0;
                        }
                        if ((c1 != -1) && (c2 != -1) && (c3 != -1) && (c4 != -1)) {
                            net.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);
                            broadcast.setText(c1+" ."+c2+" ."+c3+" ."+255);
                        }
                    }
                }



            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        edit3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Matcher m = p.matcher(edit3.getText());
                if (!(m.matches())) {
                    Toast toast = Toast.makeText(getApplicationContext(), secuencia1, Toast.LENGTH_SHORT);
                    edit3.setTextColor(Color.parseColor("#F44336"));
                    toast.show();
                } else {
                    digito3 = Integer.parseInt(edit3.getText().toString());
                    edit3.setTextColor(Color.parseColor("#81C784"));
                        if ((numero_mascara % 8 == 0) && (numero_mascara > 16)) {
                            c3 = digito3 & 255;
                        } else {
                            c3 = 0;
                        }
                        if ((c1 != -1) && (c2 != -1) && (c3 != -1) && (c4 != -1)) {
                            net.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);
                            broadcast.setText(c1 + " ." + c2 + " ." + c3 + " ." + 255);
                        }
                    }
                }



            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        edit4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Matcher m = p.matcher(edit4.getText());
                if (!(m.matches())) {
                    Toast toast = Toast.makeText(getApplicationContext(), secuencia1, Toast.LENGTH_SHORT);
                    edit4.setTextColor(Color.parseColor("#F44336"));
                    toast.show();
                } else {
                    digito4 = Integer.parseInt(edit4.getText().toString());
                    edit4.setTextColor(Color.parseColor("#81C784"));
                        if ((numero_mascara % 8 == 0) && (numero_mascara > 24)) {
                            c4 = digito4 & 255;
                        } else {
                            c4 = 0;
                        }
                        if ((c1 != -1) && (c2 != -1) && (c3 != -1) && (c4 != -1)) {
                            net.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);
                            broadcast.setText(c1 + " ." + c2 + " ." + c3 + " ." + 255);
                        }
                    }

            }


            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

}





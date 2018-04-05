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

import java.util.Arrays;
import java.util.HashMap;
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
    TextView red_utilizable;
    TextView host_number;
    TextView red_number;

    Pattern p = Pattern.compile("([0-9]|[1-8][0-9]|9[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])");
    Pattern n = Pattern.compile("([0-9]|[12][0-9]|3[0-2])");
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
    int oct1;
    int oct2;
    int oct3;
    int oct4;
    int brod_1;
    int brod_2;
    int brod_3;
    int brod_4;

    String cadena2[];

    HashMap<Integer, String>  mascaras_red = new HashMap<Integer, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.primer);
        edit2 = findViewById(R.id.segundo);
        edit3 = findViewById(R.id.tercer);
        edit4 = findViewById(R.id.cuarto);

        mascaras_red.put(1, "128.0.0.0");
        mascaras_red.put(2, "192.0.0.0");
        mascaras_red.put(3, "224.0.0.0");
        mascaras_red.put(4, "240.0.0.0");
        mascaras_red.put(5, "248.0.0.0");
        mascaras_red.put(6, "252.0.0.0");
        mascaras_red.put(7, "254.0.0.0");
        mascaras_red.put(8, "255.0.0.0");
        mascaras_red.put(9, "255.128.0.0");
        mascaras_red.put(10, "255.192.0.0");
        mascaras_red.put(11, "255.224.0.0");
        mascaras_red.put(12, "255.240.0.0");
        mascaras_red.put(13, "255.248.0.0");
        mascaras_red.put(14, "255.252.0.0");
        mascaras_red.put(15, "255.254.0.0");
        mascaras_red.put(16, "255.255.0.0");
        mascaras_red.put(17, "255.255.128.0");
        mascaras_red.put(18, "255.255.192.0");
        mascaras_red.put(19, "255.255.224.0");
        mascaras_red.put(20, "255.255.240.0");
        mascaras_red.put(21, "255.255.248.0");
        mascaras_red.put(22, "255.255.252.0");
        mascaras_red.put(23, "255.255.254.0");
        mascaras_red.put(24, "255.255.255.0");
        mascaras_red.put(25, "255.255.255.128");
        mascaras_red.put(26, "255.255.255.192");
        mascaras_red.put(27, "255.255.255.224");
        mascaras_red.put(28, "255.255.255.240");
        mascaras_red.put(29, "255.255.255.248");
        mascaras_red.put(30, "255.255.255.252");
        mascaras_red.put(31, "255.255.255.254");
        mascaras_red.put(32, "255.255.255.255");

        net = findViewById(R.id.net_id);
        broadcast = findViewById(R.id.broadcast_text);
        red_utilizable = findViewById(R.id.cantidad_text);
        host_number = findViewById(R.id.host_text);
        red_number = findViewById(R.id.red_text);

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
                } else {
                    mascara.setTextColor(Color.parseColor("#81C784"));
                    int numero = Integer.parseInt(mascara.getText().toString());
                    int redVerificador = (int)Math.pow(2,32-numero)-2;
                    red_utilizable.setText(redVerificador+"");
                    String cadena = mascaras_red.get(numero).toString();
                    cadena2 = cadena.split("\\.");
                    oct1 = Integer.parseInt(cadena2[0]);
                    oct2 = Integer.parseInt(cadena2[1]);
                    oct3 = Integer.parseInt(cadena2[2]);
                    oct4 = Integer.parseInt(cadena2[3]);

                    red_number.setText(digito1+". "+digito2);
                    host_number.setText(digito3+" ."+digito4);

                    c1 = digito1 & oct1;
                    c2 = digito2 & oct2;
                    c3 = digito3 & oct3;
                    c4 = digito4 & oct4;
                    net.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);

                    brod_1 = ~oct1 & 0xff;
                    brod_2 = ~oct2 & 0xff;
                    brod_3 = ~oct3 & 0xff;
                    brod_4 = ~oct4 & 0xff;
                    System.out.println(brod_4);

                    c1 = digito1 | brod_1;
                    c2 = digito2 | brod_2;
                    c3 = digito3 | brod_3;
                    c4 = digito4 | brod_4;
                    broadcast.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);

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

                    if ((c1 != -1) && (c2 != -1) && (c3 != -1) && (c4 != -1)) {
                        c1 = digito1 & oct1;
                        c2 = digito2 & oct2;
                        c3 = digito3 & oct3;
                        c4 = digito4 & oct4;
                        net.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);

                        brod_1 = ~oct1 & 0xff;
                        brod_2 = ~oct2 & 0xff;
                        brod_3 = ~oct3 & 0xff;
                        brod_4 = ~oct4 & 0xff;
                        System.out.println(brod_4);

                        c1 = digito1 | brod_1;
                        c2 = digito2 | brod_2;
                        c3 = digito3 | brod_3;
                        c4 = digito4 | brod_4;
                        broadcast.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);
                        red_number.setText(digito1+". "+digito2);
                        host_number.setText(digito3+" ."+digito4);
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
                    if ((c1 != -1) && (c2 != -1) && (c3 != -1) && (c4 != -1)) {
                        c1 = digito1 & oct1;
                        c2 = digito2 & oct2;
                        c3 = digito3 & oct3;
                        c4 = digito4 & oct4;
                        net.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);

                        brod_1 = ~oct1 & 0xff;
                        brod_2 = ~oct2 & 0xff;
                        brod_3 = ~oct3 & 0xff;
                        brod_4 = ~oct4 & 0xff;
                        System.out.println(brod_4);

                        c1 = digito1 | brod_1;
                        c2 = digito2 | brod_2;
                        c3 = digito3 | brod_3;
                        c4 = digito4 | brod_4;
                        broadcast.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);
                        red_number.setText(digito1+". "+digito2);
                        host_number.setText(digito3+" ."+digito4);
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
                    if ((c1 != -1) && (c2 != -1) && (c3 != -1) && (c4 != -1)) {
                        c1 = digito1 & oct1;
                        c2 = digito2 & oct2;
                        c3 = digito3 & oct3;
                        c4 = digito4 & oct4;
                        net.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);

                        brod_1 = ~oct1 & 0xff;
                        brod_2 = ~oct2 & 0xff;
                        brod_3 = ~oct3 & 0xff;
                        brod_4 = ~oct4 & 0xff;
                        System.out.println(brod_4);

                        c1 = digito1 | brod_1;
                        c2 = digito2 | brod_2;
                        c3 = digito3 | brod_3;
                        c4 = digito4 | brod_4;
                        broadcast.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);
                        red_number.setText(digito1+". "+digito2);
                        host_number.setText(digito3+" ."+digito4);
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
                    if ((c1 != -1) && (c2 != -1) && (c3 != -1) && (c4 != -1)) {
                        c1 = digito1 & oct1;
                        c2 = digito2 & oct2;
                        c3 = digito3 & oct3;
                        c4 = digito4 & oct4;
                        net.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);

                        brod_1 = ~oct1 & 0xff;
                        brod_2 = ~oct2 & 0xff;
                        brod_3 = ~oct3 & 0xff;
                        brod_4 = ~oct4 & 0xff;
                        System.out.println(brod_4);

                        c1 = digito1 | brod_1;
                        c2 = digito2 | brod_2;
                        c3 = digito3 | brod_3;
                        c4 = digito4 | brod_4;
                        broadcast.setText(c1 + " ." + c2 + " ." + c3 + " ." + c4);
                        red_number.setText(digito1+". "+digito2);
                        host_number.setText(digito3+" ."+digito4);
                        }
                    }

            }


            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

}





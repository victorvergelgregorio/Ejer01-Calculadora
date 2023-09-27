package com.example.ejer01_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView texto;
    private Button b1, b2, b3, b4, bsumar, brestar, bcalcular, bclear;
    private int resultado = 0;
    ArrayList<Button> botones = new ArrayList<>();
    private String text="";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.tw_calculadora);

        View.OnClickListener escuchadorBoton=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= text+((Button)v).getText().toString();
                texto.setText(text);
            }

        };




        /*b2.setOnClickListener(escuchadorBoton);
        b4.setOnClickListener(escuchadorBoton);
        b3.setOnClickListener(escuchadorBoton);*/
        for (int i = 1; i <= 4; i++) {
            int id=getResources().getIdentifier("b_" + i, "id", getPackageName());
            Button boton = (Button) findViewById(id);
            botones.add(boton);
            boton.setOnClickListener(escuchadorBoton);
        }
       /* b1 = findViewById(R.id.b_1);
        b2 = findViewById(R.id.b_2);
        b3 = findViewById(R.id.b_3);
        b4 = findViewById(R.id.b_4);*/
        bsumar = findViewById(R.id.b_suma);
        brestar = findViewById(R.id.b_resta);
        bcalcular = findViewById(R.id.b_igual);
        bclear = findViewById(R.id.b_clear);



        bsumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= text+"+";
                texto.setText(text);
            }
        });

        brestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text= text+"-";
                texto.setText(text);
            }
        });

        bcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char sumaoresta=text.charAt(1);
                char primerCaracter = text.charAt(0);
                char tercerCaracter = text.charAt(2);
                int primerNumero=0;
                int segundoNumero=0;
                if (texto.length() == 3) {

                    // Convertir los caracteres en números
                     primerNumero = Character.getNumericValue(primerCaracter);
                    segundoNumero = Character.getNumericValue(tercerCaracter);}
                else{texto.setText("error");}
                if (sumaoresta == '+'){
                    resultado=primerNumero+segundoNumero;
                }else{
                    resultado=primerNumero-segundoNumero;
                }

                text=String.valueOf(resultado);
                texto.setText(text);
            }
        });

        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text="";
                texto.setText(text);
            }
        });

        
    }
    }




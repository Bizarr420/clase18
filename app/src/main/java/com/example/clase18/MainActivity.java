package com.example.clase18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private TextView txtResultado;
    private EditText etPalabra;
    private Button btnInvertir,btnMensaje;

    private String palabra;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        btnInvertir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                obtenerInformacion();
                invertirPalabra();
            }
        });
    }
    private void inicializarVistas()
    {
        txtResultado = findViewById(R.id.txtResultado);
        etPalabra = findViewById(R.id.etPalabra);
        btnInvertir = findViewById(R.id.btnInvertir);
        btnMensaje = findViewById(R.id.btnMensaje);
    }
    private void obtenerInformacion()
    {
        palabra = etPalabra.getText().toString();
    }
    private void invertirPalabra()
    {
        String invertido="";

        //palabra.charAt(0);
        for (int i = palabra.length() -1; i >=0 ; i--)
        {
            invertido = invertido + palabra.charAt(i);
        }
        txtResultado.setText(invertido);
    }
}
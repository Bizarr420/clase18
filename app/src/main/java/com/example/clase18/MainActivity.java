package com.example.clase18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtResultado;
    private EditText etPalabra;
    private Button btnInvertir, btnMensaje, btnContVocales;

    private String palabra;
    private String invertido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        btnInvertir.setOnClickListener(new View.OnClickListener() {
            //este clic solo es reconocido por el boton que lo esta implementando este onclick solo existe para btnInvertir
            @Override
            public void onClick(View view) {
                obtenerInformacion();
                invertirPalabra();
            }
        });
        //lambda functions
        /*btnMensaje.setOnClickListener(view -> {
            obtenerInformacion();
            invertirPalabra();
        });*/
        btnMensaje.setOnClickListener(view -> mostrarMensaje());
        btnContVocales.setOnClickListener(view -> {
            obtenerInformacion();
            contarVocales();
        });
    }

    private void inicializarVistas() {
        txtResultado = findViewById(R.id.txtResultado);
        etPalabra = findViewById(R.id.etPalabra);
        btnInvertir = findViewById(R.id.btnInvertir);
        btnMensaje = findViewById(R.id.btnMensaje);
        btnContVocales = findViewById(R.id.btnContVocales);
    }

    private void obtenerInformacion() {
        palabra = etPalabra.getText().toString().toLowerCase();
    }

    private void invertirPalabra() {
        String invertido = "";

        //palabra.charAt(0);
        for (int i = palabra.length() - 1; i >= 0; i--) {
            invertido = invertido + palabra.charAt(i);
        }
        txtResultado.setText(invertido);

    }

    private String evaluarPalabra() {
        String mensaje = "No es Palindromo";
        if (palabra.equals(invertido)) {
            mensaje = "Es palindromo";
        }
        return mensaje;
    }

    private void mostrarMensaje() {
        Toast.makeText(this, evaluarPalabra(), Toast.LENGTH_LONG).show();
    }

    private void contarVocales()
    {
        int contador=0;
        for(int x=0;x<palabra.length();x++) {
            if ((palabra.charAt(x)=='a') || (palabra.charAt(x)=='e') || (palabra.charAt(x)=='i') || (palabra.charAt(x)=='o') || (palabra.charAt(x)=='u')){
                contador++;
            }
        }
        txtResultado.setText(contador);
    }
}
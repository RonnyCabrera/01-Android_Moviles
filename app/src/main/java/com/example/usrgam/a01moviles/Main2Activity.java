package com.example.usrgam.a01moviles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import modelo.Persona;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button botonMostrarMensaje = (Button) findViewById(R.id.botonMensaje);

        botonMostrarMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mensaje = Toast.makeText(getApplicationContext(), getIntent().getExtras().getString("idTexto").toString(), Toast.LENGTH_LONG);
                mensaje.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                mensaje.show();
            }
        });


        Persona per = (Persona) getIntent().getExtras().getSerializable("idPersona");
        ((TextView)findViewById(R.id.nombre)).setText(per.getNombre());
        ((TextView)findViewById(R.id.apellido)).setText(per.getApellido());
        ((TextView)findViewById(R.id.correo)).setText(per.getCorreo());
        ((TextView)findViewById(R.id.cedula)).setText(per.getCedula());
    }
}

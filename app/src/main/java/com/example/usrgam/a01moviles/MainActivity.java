package com.example.usrgam.a01moviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import modelo.Persona;

public class MainActivity extends AppCompatActivity {
    ListView listaP;
    ArrayAdapter<Persona> adaptador;
    Persona [] datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaP = (ListView) findViewById(R.id.listaPersonas);
        cargarLista();
        adaptador = new ArrayAdapter<Persona>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, datos);
        listaP.setAdapter(adaptador);



        Button botonMostrarMensaje = (Button) findViewById(R.id.botonMensaje);
        //Button botonAbrirPantallaDos = (Button) findViewById(R.id.botonPantallaDos);
        final EditText textEscribirAqui = (EditText) findViewById(R.id.escribirAqui);
        textEscribirAqui.getText();

        botonMostrarMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mensaje = Toast.makeText(getApplicationContext(), textEscribirAqui.getText().toString(), Toast.LENGTH_LONG);
                mensaje.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                mensaje.show();
            }
        });

        listaP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                //Toast.makeText(getApplicationContext(), datos[i].toString(), Toast.LENGTH_LONG);
                Intent intento = new Intent(getApplicationContext(), Main2Activity.class);
                intento.putExtra("idPersona", datos[i]);
                startActivity(intento);
            }
        });
    }

    public void abrirPantallaDos(View v) {
        Intent intento = new Intent(getApplicationContext(), Main2Activity.class);
        //intento.putExtra("idTexto", textEscribirAqui.getText().toString());
        intento.putExtra("idPersona", new Persona("Ronny", "Cabrera", "ronny.cabrera@epn.edu.ec", "1723029665"));
        startActivity(intento);
    }

    private void cargarLista() {
        datos = new Persona[]{new Persona("Ronny", "Cabrera", "ronny.cabrera@epn.edu.ec", "1723029665"),
                new Persona("Ronny1", "Cabrera1", "ronny.cabrera@epn.edu.ec1", "17230296651")};
    }
}

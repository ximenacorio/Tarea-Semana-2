package com.ximena.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre,telefono,email,descripcion;
    Button siguiente;
    DatePicker fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.etnombre);
        fecha = findViewById(R.id.dpcalendario);
        telefono = findViewById(R.id.ettelefono);
        email = findViewById(R.id.etemail);
        descripcion = findViewById(R.id.etdescrip);
        siguiente =findViewById(R.id.btnregistrarse);
//recibo con los mismos nombre que envio, para cuando le de al boton editar me conserve
//los mismos datos que ingrese.
        nombre.setText(getIntent().getStringExtra("etnombre"));
        telefono.setText(getIntent().getStringExtra("ettel"));
        email.setText(getIntent().getStringExtra("etemail"));
        descripcion.setText(getIntent().getStringExtra("etdescrip"));

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nombre.getText().toString().isEmpty()&&!telefono.getText().toString().isEmpty()&&!email.getText().toString().isEmpty())
                {
                    Intent registrado = new Intent(MainActivity.this, Confirmacion  .class);
                    registrado.putExtra("etnombre",nombre.getText().toString());
//                  se le suma uno al mes, dato que estos empiezan en 0
                    registrado.putExtra("etfecha",String.valueOf(fecha.getMonth()+1)+'-'+(fecha.getDayOfMonth())+'-'+(fecha.getYear()));
                    registrado.putExtra("ettel",telefono.getText().toString());
                    registrado.putExtra("etemail",email.getText().toString());
                    registrado.putExtra("etdescrip",descripcion.getText().toString());
                    startActivity(registrado);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Debe ingresar todos los datos",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
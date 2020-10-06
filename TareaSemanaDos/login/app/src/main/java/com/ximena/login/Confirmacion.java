package com.ximena.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {

    TextView nombre, telefono, email, descripcion;
    Button editar;
    TextView fecha;

    Intent intentreg = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        nombre = findViewById(R.id.tvnombre);
        fecha = findViewById(R.id.tvfecha);
        telefono = findViewById(R.id.tvtelefono);
        email = findViewById(R.id.tvemail);
        descripcion = findViewById(R.id.tvdescrip);
        editar = findViewById(R.id.btneditar);

        nombre.setText(getIntent().getStringExtra("etnombre"));
        fecha.setText(getIntent().getStringExtra("etfecha"));
        telefono.setText(getIntent().getStringExtra("ettel"));
        email.setText(getIntent().getStringExtra("etemail"));
        descripcion.setText(getIntent().getStringExtra("etdescrip"));

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentreg = new Intent(Confirmacion.this, MainActivity.class);
                retenerdatos();
                startActivity(intentreg);

            }
        });

    }

    public void retenerdatos()
    {
        intentreg.putExtra("etnombre",nombre.getText().toString());
        intentreg.putExtra("ettel",telefono.getText().toString());
        intentreg.putExtra("etemail",email.getText().toString());
        intentreg.putExtra("etdescrip",descripcion.getText().toString());
    }
}
package com.example.tareapreprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pantallainicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallainicio);
    }

    public void IrAIngresarTarea(View view)
    {
        Intent activityIngresarTarea = new Intent(this, Ingresartarea.class);
        startActivity(activityIngresarTarea);
    }

    public void IrACambiarEstado(View view)
    {
        Intent activityCambiarEstado = new Intent(this, Cambiarestadotarea.class);
        startActivity(activityCambiarEstado);
    }

    public void IrAEditarTarea(View view)
    {
        Intent activityEditarTarea = new Intent(this, Editartarea.class);
        startActivity(activityEditarTarea);
    }

    public void IrAEliminarTarea(View view)
    {
        Intent activityEliminarTarea = new Intent(this, Eliminartarea.class);
        startActivity(activityEliminarTarea);
    }

    public void IrAVerTarea(View view)
    {
        Intent activityVerTarea = new Intent(this, Vertarea.class);
        startActivity(activityVerTarea);
    }

    public void IrALogin(View view)
    {
        Intent activityIrALogin = new Intent(this, MainActivity.class);
        startActivity(activityIrALogin);
    }

}
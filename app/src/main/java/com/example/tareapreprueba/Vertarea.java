package com.example.tareapreprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Vertarea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertarea);
    }

    public void VolverACrudIndex(View view)
    {
        Intent activityCrudIndex = new Intent(this, Pantallainicio.class);
        startActivity(activityCrudIndex);
    }

}
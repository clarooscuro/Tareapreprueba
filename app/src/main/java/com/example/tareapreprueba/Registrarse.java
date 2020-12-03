package com.example.tareapreprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrarse extends AppCompatActivity implements View.OnClickListener {
    //EditText editText_registrarsecorreo, editText_registrarsepassword, editText_registrarseID;
EditText id,em,pas;
Button reg,can;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        em=(EditText)findViewById(R.id.editText_registrarsecorreo);
        pas=(EditText)findViewById(R.id.editText_registrarsepassword);
        reg=(Button)findViewById(R.id.button_registrarse2);
        can=(Button)findViewById(R.id.button_registrarsevolver);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao=new daoUsuario(this);

        /*editText_registrarsecorreo = findViewById(R.id.editText_registrarsecorreo);
        editText_registrarsepassword = findViewById(R.id.editText_registrarsepassword);
        editText_registrarseID = findViewById(R.id.editText_registrarseID);*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_registrarse2:
                Usuario u=new Usuario();
                u.setEmail(em.getText().toString());
                u.setPassword(pas.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(this,"Los campos están vacios",Toast.LENGTH_LONG).show();
                } else if (dao.InsertarUsuario(u)) {
                    Toast.makeText(this,"Registro exitoso",Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(Registrarse.this,MainActivity.class);
                    startActivity(i2);
                    finish();
                } else {
                    Toast.makeText(this,"Usuario ya registrado",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.button_registrarsevolver:
                Intent i=new Intent(Registrarse.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }

}
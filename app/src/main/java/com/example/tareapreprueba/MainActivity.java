package com.example.tareapreprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String correo = "admin@mail.com";
    String clave = "clave";
    EditText email, pass;
    Button login, registrarse;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText)findViewById(R.id.editText_ingresaremail);
        pass=(EditText)findViewById(R.id.editText_ingresarpassword);
        login=(Button)findViewById(R.id.button_iniciarsesion);
        registrarse=(Button)findViewById(R.id.button_registrarse);
        dao=new daoUsuario(this);

        login.setOnClickListener(this);
        registrarse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_iniciarsesion:
                String em=email.getText().toString();
                String pas=pass.getText().toString();
                if(em.equals("")&&pas.equals("")){
                    Toast.makeText(this,"Los campos están vacios",Toast.LENGTH_LONG).show();
                } else if(dao.login(em,pas)==1) {
                    Usuario ux=dao.getUsuario(em,pas);
                    Toast.makeText(this,"Bienvenido a la app", Toast.LENGTH_LONG).show();
                    Intent i2= new Intent(MainActivity.this,Pantallainicio.class);
                    i2.putExtra("Id",ux.getId());
                    startActivity(i2);
                } else if (em.equals(correo)&&pas.equals(clave)){
                    Toast.makeText(this, "Bienvenido administrador", Toast.LENGTH_LONG).show();
                    Intent i3=new Intent(MainActivity.this,Indexadmin.class);
                    startActivity(i3);
            } else {
                    Toast.makeText(this, "Usuario y/o contraseña incorrecta", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.button_registrarse:
                Intent i=new Intent(MainActivity.this,Registrarse.class);
                startActivity(i);
                break;
        }

    }

    /*public void IrACrudIndex (View view)
    {
        Intent activityindexcrud = new Intent(this, Pantallainicio.class);

        if (correo.equals(editText_ingresaremail.getText().toString()) && clave.equals(editText_ingresarpassword.getText().toString())) {
            startActivity(activityindexcrud);
            Toast.makeText(this, "Bienvenido al home", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
        }
    }

    public void IrARegistrarse (View view){
        Intent activityregistrar = new Intent(this, Registrarse.class);
        startActivity(activityregistrar);
    }*/

}


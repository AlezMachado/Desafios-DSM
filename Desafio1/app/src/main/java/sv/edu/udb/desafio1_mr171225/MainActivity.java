package sv.edu.udb.desafio1_mr171225;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.udb.desafio1_mr171225.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user, pass;
    Button btn_entrar, btn_registrar;
    Usuario1 dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText) findViewById(R.id.id_usuario);
        pass=(EditText) findViewById(R.id.id_contra);
        btn_entrar=(Button) findViewById(R.id.btn_entrar);
        btn_registrar=(Button) findViewById(R.id.btn_registrar);

        btn_entrar.setOnClickListener(this);
        btn_registrar.setOnClickListener(this);
        dao=new Usuario1 (this);
    }

    @Override
    public void onClick (View v){
        switch (v.getId()){
            case R.id.btn_entrar:
                String u=user.getText().toString();
                String p=pass.getText().toString();
                if (u.equals("")&&p.equals("")){
                    Toast.makeText(this, "ERROR: Campos Vacios",Toast.LENGTH_LONG).show();
                } else if (dao.login(u,p)==1){
                    Usuario ux=dao.getUsuario(u,p);
                    Toast.makeText(this, "Datos Correctos", Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(MainActivity.this, Menu.class);
                    startActivity(i2);
                    finish();
                } else{
                    Toast.makeText(this, "Usuario y/o Contraseña Incorrectos",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btn_registrar:
                Intent i=new Intent(MainActivity.this, Registro_Usuario.class);
                startActivity(i);
                break;
        }
    }
}
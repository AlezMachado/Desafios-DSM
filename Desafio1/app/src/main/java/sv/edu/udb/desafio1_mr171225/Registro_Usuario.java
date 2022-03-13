package sv.edu.udb.desafio1_mr171225;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro_Usuario extends AppCompatActivity implements View.OnClickListener {
    EditText us, pas, nom, ap;
    Button reg, can;
    Usuario1 usu1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        us=(EditText) findViewById(R.id.Reguser);
        pas=(EditText) findViewById(R.id.RegPass);
        nom=(EditText) findViewById(R.id.RegNom);
        ap=(EditText) findViewById(R.id.RegApe);
        reg= (Button) findViewById(R.id.btnRegistrar);
        can= (Button) findViewById(R.id.btnCancelar);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        usu1=new Usuario1(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegistrar:
                Usuario u=new Usuario();
                u.setUsuario(us.getText().toString());
                u.setContraseña(pas.getText().toString());
                u.setNombre(nom.getText().toString());
                u.setApellidos(ap.getText().toString());
                if (!u.isNull()){
                    Toast.makeText(this, "ERROR: Campos Vacios", Toast.LENGTH_LONG).show();
                } else if (usu1.insertarUsuario(u)) {
                    Toast.makeText(this, "Registro Exitoso!!!", Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(Registro_Usuario.this, MainActivity.class);
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this, "Usuario ya Registrado!!!", Toast.LENGTH_LONG).show();

                }

                break;
            case R.id.btnCancelar:
                Intent i=new Intent(Registro_Usuario.this, MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}
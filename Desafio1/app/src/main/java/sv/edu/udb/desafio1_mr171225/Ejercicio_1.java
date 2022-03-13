package sv.edu.udb.desafio1_mr171225;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ejercicio_1 extends AppCompatActivity implements View.OnClickListener {
     Button bt_calcular;
     EditText id_a, id_b, id_c;
     TextView id_x1, id_x2, id_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        bt_calcular = (Button) findViewById(R.id.btn_calcular);
        id_a = (EditText) findViewById(R.id.id_a);
        id_b = (EditText) findViewById(R.id.id_b);
        id_c = (EditText) findViewById(R.id.id_c);
        id_x1 = (TextView) findViewById(R.id.id_x1);
        id_x2 = (TextView) findViewById(R.id.id_x2);
        id_res = (TextView) findViewById(R.id.id_res);
        bt_calcular.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {

        double a = Double.parseDouble(id_a.getText().toString());
        double b = Double.parseDouble(id_b.getText().toString());
        double c = Double.parseDouble(id_c.getText().toString());

        double x1 = (-b + (Math.sqrt(Math.pow(b, 2) - (4 * a * c)))) / 2 * a;
        double x2 = (-b - (Math.sqrt(Math.pow(b, 2) - (4 * a * c)))) / 2 * a;
        double D = Math.pow(b, 2) - (4 * a * c);

        id_x1.setText(x1 + "");
        id_x2.setText(x2 + "");

        if (D >= 0) {
            id_res.setText("La ecuación tiene solución con Números Reales");
        } else {
            id_res.setText("La ecuación no tiene solución con Números Reales");

        }
    }
}

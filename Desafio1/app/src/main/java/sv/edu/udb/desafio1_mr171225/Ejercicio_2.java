package sv.edu.udb.desafio1_mr171225;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Ejercicio_2 extends AppCompatActivity {
    private TextView id_resulta, id_descuen, id_ISSS, id_AFP, id_RENTA, id_salarioLiquido;
    private EditText id_nombre, id_horas;
    private RadioButton id_gerente, id_asistente, id_secretaria, id_otrosCargos;

    DecimalFormat currency = new DecimalFormat("$###,###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
        id_nombre = findViewById(R.id.nombre);
        id_horas = findViewById(R.id.id_horas);

        id_resulta = findViewById(R.id.id_resulta);
        id_salarioLiquido = findViewById(R.id.id_salarioLiquido);
        id_descuen = findViewById(R.id.id_descuen);
        id_ISSS = findViewById(R.id.id_ISSS);
        id_AFP = findViewById(R.id.id_AFP);
        id_RENTA = findViewById(R.id.id_RENTA);
        id_gerente = findViewById(R.id.id_gerente);
        id_asistente = findViewById(R.id.id_asistente);
        id_secretaria = findViewById(R.id.id_secretaria);
        id_otrosCargos = findViewById(R.id.id_otrosCargos);

    }

    public void Calcular (View in){
        if (id_nombre.getText().toString().trim().isEmpty() || id_nombre.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Ingrese los datos Solicitados", Toast.LENGTH_SHORT).show();
        } else {
            String nombres = id_nombre.getText().toString();
            int horas = Integer.parseInt(id_horas.getText().toString());

            double pago;
            if (horas < 160){
                pago = (horas) * 9.75;
            } else {
                pago= horas * 11.50;
            }

            double bonos, pagoIncremento, pagoFinal, descISSS, descAFP, descRENTA, totalDesc;
            if (id_gerente.isChecked()){
                bonos= 0.10;
            } else if (id_asistente.isChecked()){
                bonos = 0.05;
            } else if (id_secretaria.isChecked()){
                bonos = 0.03;
            } else if (id_otrosCargos.isChecked()){
                bonos = 0.02;
            }else {
                bonos = 0;
            }
            pagoIncremento= pago + pago * bonos;
            descISSS = (pagoIncremento * 0.0525);
            descAFP= (pagoIncremento*0.0688);
            descRENTA = (pagoIncremento * 0.10);
            totalDesc = descISSS + descAFP + descRENTA;
            pagoFinal= pagoIncremento - totalDesc;


            String id_resultado = "El sueldo base más bono de:  " + nombres + " es:" + currency.format(pagoIncremento);
            id_resulta.setText(id_resultado);

            String id_isss = "El descuento del ISSS es:  " + currency.format(descISSS);
            id_ISSS.setText(id_isss);

            String id_afp = "El descuento de la AFP es: " + currency.format(descAFP);
            id_AFP.setText(id_afp);

            String id_renta = "El descuento de la RENTA es:  " + currency.format(descRENTA);
            id_RENTA.setText(id_renta);

            String id_liquido = "El salario liquido final menos los descuentos es de: " + currency.format(pagoFinal);
            id_salarioLiquido.setText(id_liquido);

        }
    }
}
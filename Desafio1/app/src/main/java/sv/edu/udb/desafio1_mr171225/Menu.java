package sv.edu.udb.desafio1_mr171225;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
private Button btn_ejer1, btn_ejer2, btn_ejer3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickFrame(View v){
        Intent llamar = new Intent(Menu.this , Ejercicio_1.class);
        startActivity(llamar);
    }

    public void onClickEjer2(View v){
        Intent llamar = new Intent(Menu.this , Ejercicio_2.class);
        startActivity(llamar);
    }
}
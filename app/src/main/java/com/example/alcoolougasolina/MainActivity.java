package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool    = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina  = findViewById(R.id.editPrecoGasolina);
        textResultado      = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if (camposValidados) {
            double valorAlcool = Double.parseDouble(precoAlcool);
            double valorGasolina = Double.parseDouble(precoGasolina);

            if((valorAlcool / valorGasolina) >= 0.7){
                textResultado.setText("Melhor utilizar Gasolina!");
            }else {
                textResultado.setText("Melhor utilizar Àlcool!");
            }
        }else {
            textResultado.setText("Preencha os preços primeiro!");
        }

    }

    public boolean validarCampos(String pAlcool, String pGasolina){
         Boolean camposValidados = true;

         if(pAlcool == null || pAlcool.equals("")){
             camposValidados = false;
         } else if (pGasolina == null || pGasolina.equals("")) {
             camposValidados = false;
         }

         return camposValidados;
    }
}
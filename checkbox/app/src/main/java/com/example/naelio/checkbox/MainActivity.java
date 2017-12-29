package com.example.naelio.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxCao, checkBoxGato, checkBoxPapagaio;
    private Button buttonMostrar;
    private TextView textViewMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMostrar = findViewById(R.id.buttonMostrarID);
        textViewMostrar = findViewById(R.id.textViewResultadoID);

        checkBoxCao = findViewById(R.id.checkBoxCaoID);
        checkBoxGato = findViewById(R.id.checkBoxGatoID);
        checkBoxPapagaio = findViewById(R.id.checkBoxPapagaioID);

        buttonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String selecionados = "";

                selecionados += "Item: " + checkBoxCao.getText() + ": " + checkBoxCao.isChecked() +"\n";
                selecionados += "Item: " + checkBoxGato.getText() + ": " + checkBoxGato.isChecked() +"\n";
                selecionados += "Item: " + checkBoxPapagaio.getText() + ": " + checkBoxPapagaio.isChecked() +"\n";

                textViewMostrar.setText(selecionados);

            }
        });
    }
}

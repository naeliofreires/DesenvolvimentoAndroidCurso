package com.naelio.idade_de_cachorro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResultado;
    private EditText editTextIdadeCachorro;
    private Button buttonDescobrirIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textViewResultado = (TextView) findViewById(R.id.textViewResultado);
        this.editTextIdadeCachorro = (EditText) findViewById(R.id.editTextIdadeCachorro);
        this.buttonDescobrirIdade = (Button) findViewById(R.id.buttonDescobrirIdade);

        buttonDescobrirIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idadeCachorro = editTextIdadeCachorro.getText().toString();

                if(idadeCachorro.isEmpty()){
                    textViewResultado.setText("Idade vazia!");
                }else{
                    int valorDigitado = Integer.parseInt(idadeCachorro);
                    int resultadoFinal = 7 * valorDigitado;
                    textViewResultado.setText("Idade do cachorro em anos humanos é " + resultadoFinal + " anos.");
                    editTextIdadeCachorro.setText("");
                }
            }
        });

    }
}

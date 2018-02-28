package com.example.naelio.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button buttonSalvar;
    private EditText editTextFrase;
    private TextView textViewExibicao;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buttonSalvar     = findViewById(R.id.buttonSalvar);
        this.editTextFrase    = findViewById(R.id.editTextFrase);
        this.textViewExibicao = findViewById(R.id.textViewMensagem);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * O zero indica que o arquivo só pode ser lido nesta aplicação
                 */
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                /**
                 * Indicando que o arquivo pode ser editado
                 */
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(editTextFrase.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Por favor preencha o campo nome!", Toast.LENGTH_SHORT);
                }else{
                    editor.putString("nome",editTextFrase.getText().toString());
                    editor.commit();

                    textViewExibicao.setText(editTextFrase.getText().toString());
                }

            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if(sharedPreferences.contains("nome")){
            String nomeUsuario = sharedPreferences.getString("nome","usuário não definido");
            textViewExibicao.setText("Olá," + nomeUsuario);
        }else{
            textViewExibicao.setText("Olá, usuario não definido");
        }
    }
}

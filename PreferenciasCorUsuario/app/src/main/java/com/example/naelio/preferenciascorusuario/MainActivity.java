package com.example.naelio.preferenciascorusuario;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonSelecionado;
    private Button buttonSalvar;
    private RelativeLayout layout;

    private static final String ARQUIVO_PREFERENCIA = "aquivo_preferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.layout = findViewById(R.id.layoutID);
        this.radioGroup = findViewById(R.id.radioGroup);
        this.buttonSalvar = findViewById(R.id.buttonSalvar);

        this.buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int idRadioButtonSelecionado = radioGroup.getCheckedRadioButtonId();

                if(idRadioButtonSelecionado > 0){
                    radioButtonSelecionado = findViewById(idRadioButtonSelecionado);

                    SharedPreferences sharedPreferences= getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    String corEscolhida = radioButtonSelecionado.getText().toString();
                    editor.putString("cor_escolhida", corEscolhida);
                    editor.commit();

                    setColorBackground(corEscolhida);
                }
            }
        });

        SharedPreferences sharedPreferences= getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if(sharedPreferences.contains("cor_escolhida")){
            String corRecuperada = sharedPreferences.getString("cor_escolhida","Laranja");
            setColorBackground(corRecuperada);
        }
    }

    private void setColorBackground(String cor){

        if(cor.equals("Azul")){
            this.layout.setBackgroundColor(Color.parseColor("#495b7c"));
        }else if(cor.equals("Laranja")){
            this.layout.setBackgroundColor(Color.parseColor("#ffce26"));
        }else if(cor.equals("Verde")){
            this.layout.setBackgroundColor(Color.parseColor("#add727"));
        }
    }
}

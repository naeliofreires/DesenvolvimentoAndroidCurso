package com.example.naelio.cara_ou_coroa;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DetalheActivity extends AppCompatActivity {

    private ImageView moeda;
    private ImageView botaoVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        this.moeda = findViewById(R.id.imagemMoeda);
        this.botaoVoltar = findViewById(R.id.buttonVoltar);

        this.botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetalheActivity.this, MainActivity.class ));
            }
        });

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String opcaoEscolhida = bundle.getString("numeroSorteado");

            if(opcaoEscolhida.equals("cara")){
                moeda.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_cara));
            }else{
                moeda.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_coroa));
            }
        }
    }
}

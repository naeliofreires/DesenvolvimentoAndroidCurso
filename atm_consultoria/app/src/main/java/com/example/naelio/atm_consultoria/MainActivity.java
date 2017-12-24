package com.example.naelio.atm_consultoria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView botaoEmpresa;
    private ImageView botaoServicos;
    private ImageView botaoContato;
    private ImageView botaoClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.botaoEmpresa = findViewById(R.id.imageEmpresa);
        this.botaoClientes = findViewById(R.id.imageClientes);
        this.botaoContato = findViewById(R.id.imageContato);
        this.botaoServicos = findViewById(R.id.imageServico);


        this.botaoEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EmpresaActivity.class));
            }
        });

        this.botaoServicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ServicosActivity.class));
            }
        });

        this.botaoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ContatoActivity.class));
            }
        });

        this.botaoClientes.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MainActivity.this, ClientesActivity.class));
           }
        });

    }
}

package com.example.naelio.cara_ou_coroa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private ImageView button;
    private String[] opcao = {"cara", "coroa"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button = findViewById(R.id.buttonJogar);

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();

                int numero = random.nextInt(2);

                Intent intent = new Intent(MainActivity.this, DetalheActivity.class);

                intent.putExtra("numeroSorteado", opcao[numero]);

                startActivity(intent);
            }
        });


    }
}

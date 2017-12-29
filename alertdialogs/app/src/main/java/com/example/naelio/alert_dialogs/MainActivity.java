package com.example.naelio.alert_dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botaoDialog;
    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.botaoDialog = findViewById(R.id.buttonDialog);

        this.botaoDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog = new AlertDialog.Builder(MainActivity.this);

                alertDialog.setTitle("Titulo do Dialog!");

                alertDialog.setMessage("Mensagem do Dialog!");

                alertDialog.setCancelable(false); // ao clicar no lado de fora, o alert n fecha
                alertDialog.setIcon(android.R.drawable.ic_input_add);

                alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Você escolheu NÃO!", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Você escolheu SIM!", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.create();
                alertDialog.show();
            }
        });
    }
}

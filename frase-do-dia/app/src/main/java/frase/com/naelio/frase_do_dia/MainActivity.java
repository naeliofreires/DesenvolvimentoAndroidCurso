package frase.com.naelio.frase_do_dia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private TextView textoFrase;
    private Button buttonFrase;

    private String[] frases = {
            "Estou cansado de ser o que você quer que eu seja...",

            "Você quer apontar o dedo\n" + "Mas não há ninguém para culpar!",

            "Tudo que eu precisava\n" + "Era a única coisa que eu não podia encontra",

            "O tempo não mais vai curar esta ferida",

            "Quero me curar, eu quero sentir\n" + "O que achei que nunca fosse real."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textoFrase = (TextView) findViewById(R.id.frase);
        this.buttonFrase = (Button) findViewById(R.id.buttonGerarFrase);

        buttonFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();

                int numero = random.nextInt(frases.length);

                textoFrase.setText(frases[numero]);
            }
        });

    }
}

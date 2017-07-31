package example.naelio.adivinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonJogar;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buttonJogar = (Button) findViewById(R.id.buttonJogar);
        this.textResultado = (TextView) findViewById(R.id.textResultado);

        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random randomico = new Random();
                int numero = randomico.nextInt(10);
                textResultado.setText("Numero sorteado é " + numero);
            }
        });

    }
}

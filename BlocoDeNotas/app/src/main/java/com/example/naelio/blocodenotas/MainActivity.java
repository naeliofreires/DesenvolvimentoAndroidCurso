package com.example.naelio.blocodenotas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {


    private ImageView imageViewSalvar;
    private EditText editTextConteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.imageViewSalvar = findViewById(R.id.imageViewSalvar);
        this.editTextConteudo = findViewById(R.id.editTextConteudo);

        imageViewSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textoDigitado = editTextConteudo.getText().toString();

                saveInFile(textoDigitado);

                Toast.makeText(MainActivity.this,"Salvo com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * load file
         */
        if(loadFile() != null)
            editTextConteudo.setText(loadFile());

    }

    private void saveInFile(String texto){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("anotacao.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(texto);
            outputStreamWriter.close();

        }catch (IOException ex){
            Log.v("MainActivity", ex.toString());
        }
    }

    private String loadFile(){

        String resultado = "";

        try {
            /**
             * Open file
             */
            InputStream arquivo = openFileInput("anotacao.txt");
            if(arquivo != null){
                /**
                 * load the  file
                 */
                InputStreamReader inputStreamReader = new InputStreamReader(arquivo);
                /**
                 * Make buffer of the file
                 */
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                /**
                 * Retrieve texts from file
                 */
                String lineFile = "";
                while ((lineFile = bufferedReader.readLine()) != null){
                    resultado += lineFile;
                }

                arquivo.close();
            }
        }catch (IOException ex){
            Log.v("MainActivity", ex.toString());
        }

        return resultado;
    }
}

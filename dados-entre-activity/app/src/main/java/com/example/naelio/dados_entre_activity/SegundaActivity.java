package com.example.naelio.dados_entre_activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SegundaActivity extends Activity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        this.text = findViewById(R.id.textID);

        Bundle bundle = getIntent().getExtras();


        if(bundle != null){
            String nome = bundle.getString("nome");
            text.setText(nome);
        }
    }
}

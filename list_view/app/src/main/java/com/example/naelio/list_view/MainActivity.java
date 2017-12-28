package com.example.naelio.list_view;

import android.app.Activity;
import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listView;
    private String[] itens = {
            "Angra dos Reis", "Caldas Novas", "Campos do Jordao", "Planalto Ayrton Senna", "José Walter", "Fortaleza", "Barcelona"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = findViewById(R.id.listViewID);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        this.listView.setAdapter(adapter);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valor_clicado = listView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), valor_clicado, Toast.LENGTH_SHORT).show();
            }
        });

    }
}

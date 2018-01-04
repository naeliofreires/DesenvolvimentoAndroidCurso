package com.example.naelio.radiobuttons;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonEscolhido;
    private Button buttonEscolher;
    private TextView textViewEscolhido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup =  findViewById(R.id.RadionGroupID);
        buttonEscolher = findViewById(R.id.buttonEscolherID);
        textViewEscolhido = findViewById(R.id.textViewShowID);

        buttonEscolher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();
                if(idRadioButtonEscolhido  > 0){
                    radioButtonEscolhido = findViewById(idRadioButtonEscolhido);
                    textViewEscolhido.setText(radioButtonEscolhido.getText());
                }
            }
        });
    }
}

package com.example.naelio.qualserievocegostamais_seekbar;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends Activity {

    private SeekBar seekBar;
    private ImageView imagemExibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        imagemExibicao = findViewById(R.id.ImagemExibicaoID);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if(progress == 1){
                    imagemExibicao.setImageResource(R.drawable.pouco);
                }else if(progress == 2){
                    imagemExibicao.setImageResource(R.drawable.medio);
                }else if(progress == 3){
                    imagemExibicao.setImageResource(R.drawable.muito);
                }else if(progress == 4){
                    imagemExibicao.setImageResource(R.drawable.susto);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}

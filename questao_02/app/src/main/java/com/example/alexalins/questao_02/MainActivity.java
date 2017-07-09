package com.example.alexalins.questao_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText adulto;
    private EditText crianca;
    private Button btnCalcular;
    //para imprimir resultado
    private TextView bolo;
    private TextView doce;
    private TextView salgado;
    private TextView refri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adulto = (EditText)findViewById(R.id.editText);
        crianca = (EditText)findViewById(R.id.editText2);
        btnCalcular = (Button)findViewById(R.id.button);
        bolo = (TextView)findViewById(R.id.textView5);
        doce = (TextView)findViewById(R.id.textView7);
        salgado = (TextView)findViewById(R.id.textView9);
        refri = (TextView)findViewById(R.id.textView11);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //variaveis para calcular resultado
                double totalBolo = 0;
                double totalDoce = 0;
                double totalSalgado = 0;
                double totalRefri = 0;

                //calculando resultado 
                totalBolo = ( Double.parseDouble(adulto.getText().toString()) * 0.6) + (Double.parseDouble(crianca.getText().toString()) * 0.4);
                totalDoce = ( Double.parseDouble(adulto.getText().toString()) * 8.0) + (Double.parseDouble(crianca.getText().toString()) * 6.0);
                totalSalgado = ( Double.parseDouble(adulto.getText().toString()) * 6.0) + (Double.parseDouble(crianca.getText().toString()) * 4.0);
                totalRefri = ( Double.parseDouble(adulto.getText().toString()) * 0.6) + (Double.parseDouble(crianca.getText().toString()) * 0.5);

                //setando no textview para imprimir na tela
                bolo.setText(""+totalBolo);
                doce.setText(""+totalDoce);
                salgado.setText(""+totalSalgado);
                refri.setText(""+totalRefri);
            }
        });
    }
}

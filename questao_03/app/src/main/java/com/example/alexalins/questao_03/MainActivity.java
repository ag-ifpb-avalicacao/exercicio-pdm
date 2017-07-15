package com.example.alexalins.questao_03;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton button = (ImageButton) findViewById(R.id.imageButton);
        final TextView logradouro = (TextView) findViewById(R.id.logradouro);
        final TextView bairro = (TextView) findViewById(R.id.bairro);
        final TextView municipioUf = (TextView) findViewById(R.id.municipioUf);
        final EditText cep = (EditText) findViewById(R.id.editText);

        //setando valores vazio
        logradouro.setText(" ");
        bairro.setText(" ");
        municipioUf.setText(" ");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //criando thead
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        RecuperarDadosPeloCEP recuperarDadosPeloCEP = new RecuperarDadosPeloCEP();
                        final JSONObject jsonObject = recuperarDadosPeloCEP.recuperarDados(cep.getText().toString());//criando um jsonObjeto passando o outro

                        runOnUiThread(new Runnable() {
                              @Override
                              public void run() {
                                  try {
                                      //setando na tela
                                      logradouro.setText(jsonObject.getString("logradouro"));
                                      bairro.setText(jsonObject.getString("bairro"));
                                      municipioUf.setText(jsonObject.getString("localidade") + "-" + jsonObject.getString("uf"));
                                  } catch (JSONException e) {
                                      e.printStackTrace();
                                  }
                              }
                          });
                    }
                }).start();
            }
        });

    }
}

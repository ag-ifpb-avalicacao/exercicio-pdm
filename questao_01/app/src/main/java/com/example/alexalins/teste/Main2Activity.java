package com.example.alexalins.teste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView txtNome;
    private TextView txtCurso;
    private ImageButton btnLimpar;
    private ImageButton btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnLimpar = (ImageButton)findViewById(R.id.imageButton);
        btnSair = (ImageButton)findViewById(R.id.imageButton2);

        Intent intent = getIntent();
        String nome = (String)intent.getSerializableExtra("nome");
        String curso = (String)intent.getSerializableExtra("curso");

        txtNome = (TextView) findViewById(R.id.textView);
        txtNome.setText(nome);
        txtCurso = (TextView) findViewById(R.id.textView2);
        txtCurso.setText(curso);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNome.setText(" ");
                txtCurso.setText(" ");
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

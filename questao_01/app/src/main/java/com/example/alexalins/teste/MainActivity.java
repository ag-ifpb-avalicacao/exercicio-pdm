package com.example.alexalins.teste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText texto;
    private ListView listView;
    private String curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        final ArrayList<String> cursos = preecherDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cursos);
        listView.setAdapter(arrayAdapter);

        texto = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.button);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                curso = cursos.get(i).toString();
            }
        });

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("nome", texto.getText().toString());
                intent.putExtra("curso", curso);
                startActivity(intent);
            }
        });
    }

    private ArrayList<String> preecherDados() {
        ArrayList<String> dados = new ArrayList<>();
        dados.add("ADS");
        dados.add("AI");
        dados.add("Civil");

        return dados;
    }
}

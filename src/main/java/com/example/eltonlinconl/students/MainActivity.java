package com.example.eltonlinconl.students;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> listaAlunos = new ArrayList<>();
    private String[] alunos = {"Elton", "Maria", "Lurdes", "Julia", "Joana", "José", "Lucas"};
    private String nome = "Nome : ";
    private Button btnAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0;  i < alunos.length ; i++){
            listaAlunos.add(alunos[i]);
        }


        ListView listaDeAlunos = (ListView) findViewById(R.id.lista);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,   listaAlunos
        );

        listaDeAlunos.setAdapter(adapter);

        listaDeAlunos.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener(){
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                contextMenu.add(Menu.NONE, 1, Menu.NONE, " Ligar para o aluno" );
                contextMenu.add(Menu.NONE, 2, Menu.NONE, " Mandar SMS para o aluno" );
                contextMenu.add(Menu.NONE, 3, Menu.NONE, " Ver localização no mapa" );
                contextMenu.add(Menu.NONE, 4, Menu.NONE, " Acessar site do aluno" );
            }
        });

        //Parte do botão
        btnAluno = (Button) findViewById(R.id.buttonAluno);

        btnAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CadastroAlunos.class));
            }
        });


    }


    public void setListaAlunos(String n){
        listaAlunos.add(n);
    }

    public int getListaAlunos(){
       return listaAlunos.size();
    }
}

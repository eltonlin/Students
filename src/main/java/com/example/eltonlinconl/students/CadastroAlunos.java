package com.example.eltonlinconl.students;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroAlunos extends AppCompatActivity {

    String aluno;

    MainActivity main = new MainActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_alunos);

        EditText nomeAluno = (EditText) findViewById(R.id.edtNome);
        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        aluno = String.valueOf(nomeAluno.getText());



        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.setListaAlunos(aluno);
                startActivity(new Intent(CadastroAlunos.this, MainActivity.class));
                Toast.makeText(CadastroAlunos.this, "Quantidade" + main.getListaAlunos(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}

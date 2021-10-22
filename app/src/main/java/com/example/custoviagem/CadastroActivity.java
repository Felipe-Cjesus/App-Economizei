package com.example.custoviagem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.custoviagem.database.dao.UsuarioDAO;
import com.example.custoviagem.database.model.UsuarioModel;

public class CadastroActivity extends AppCompatActivity {

    private EditText cadastroUsuario, cadastroSenha;
    private Button btnConfirmarCadastro, btnVoltar;
    private UsuarioDAO daoCadastro;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Instancia o banco de dados.
        daoCadastro = new UsuarioDAO(CadastroActivity.this);

        // Cria os componentes.
        cadastroUsuario = findViewById(R.id.cadastroUsuario);
        cadastroSenha = findViewById(R.id.cadastroSenha);

        // Faz o SELECT e entra no aplicativo.
        btnConfirmarCadastro = findViewById(R.id.btnConfirmarCadastro);
        btnConfirmarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UsuarioModel model = new UsuarioModel();
                model.setUsuario(cadastroUsuario.getText().toString());
                model.setSenha(cadastroSenha.getText().toString());

                if (daoCadastro.Insert(model) != -1) {
                    Toast.makeText(CadastroActivity.this, "Usuário Cadastrado!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(CadastroActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(CadastroActivity.this, "Ocorreu um erro!", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CadastroActivity.this, LoginActivity.class));
            }
        });
    }
}

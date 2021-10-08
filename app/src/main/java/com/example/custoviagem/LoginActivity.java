package com.example.custoviagem;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.custoviagem.database.dao.UsuarioDAO;
import com.example.custoviagem.database.model.UsuarioModel;

public class LoginActivity extends AppCompatActivity {

    private EditText editUsuario, editSenha;
    private Button btnLogin, btnCadastrar;
    private UsuarioDAO dao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Instancia o banco de dados.
        dao = new UsuarioDAO(LoginActivity.this);

        // Criação os componentes.
        editUsuario = findViewById(R.id.editUsuario);
        editSenha = findViewById(R.id.editSenha);

        // Faz o SELECT e entra no aplicativo.
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UsuarioModel model = dao.Select(editUsuario.getText().toString(), editSenha.getText().toString());
                if (model != null) {
                    Toast.makeText(LoginActivity.this, "Login efetuado com sucesso!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this, CustosActivity.class));
                }
                else {
                    Toast.makeText(LoginActivity.this, "Usuário Não Encontrado!", Toast.LENGTH_LONG).show();
                }

            }
        });

        // Abre tela para Gravar um novo usuario.
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginActivity.this, CadastroActivity.class));

            }
        });

    }
}

package com.example.custoviagem;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.custoviagem.database.dao.UsuarioDAO;
import com.example.custoviagem.database.model.UsuarioModel;
import com.example.custoviagem.util.Shared;

public class LoginActivity extends AppCompatActivity {

    private EditText editUsuario, editSenha;
    private Button btnLogin, btnCadastrar;
    private UsuarioDAO dao;
    private CheckBox check_login;
    private Shared shared;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Instacia o Shared
        shared = new Shared(LoginActivity.this);

        // Instancia o banco de dados.
        dao = new UsuarioDAO(LoginActivity.this);

        // Criação os componentes.
        editUsuario = findViewById(R.id.editUsuario);
        editSenha = findViewById(R.id.editSenha);

        check_login = (CheckBox) findViewById(R.id.check_login);

        // Faz o SELECT e entra no aplicativo.
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_login.isChecked()){
                    shared.put(Shared.COLUNA_USUARIO, editUsuario.getText().toString());
                    shared.put(Shared.COLUNA_SENHA, editSenha.getText().toString());
                } else {
                    shared.remove(Shared.COLUNA_USUARIO);
                    shared.remove(Shared.COLUNA_SENHA);
                }

                UsuarioModel model = dao.Select(editUsuario.getText().toString(), editSenha.getText().toString());
                if (model != null) {
                    Toast.makeText(LoginActivity.this, "Login efetuado com sucesso!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this, Lista_Destinos_Activity.class));
                }
                else {
                    Toast.makeText(LoginActivity.this, "Usuário ou senha incorreto! Tente novamente!", Toast.LENGTH_LONG).show();
                }
            }
        });

        editUsuario.setText(shared.getString(Shared.COLUNA_USUARIO));
        editSenha.setText(shared.getString(Shared.COLUNA_SENHA));

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

package com.example.custoviagem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.custoviagem.database.dao.UsuarioDAO;
import com.example.custoviagem.database.model.UsuarioModel;

public class CadastroActivity extends AppCompatActivity {

    private EditText cadastroUsuario, cadastroSenha, confirmarSenha;
    private Button btnConfirmarCadastro;
    private TextView txtVoltar;
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
        confirmarSenha = findViewById(R.id.confirmarSenha);

        // Faz o SELECT e entra no aplicativo.
        btnConfirmarCadastro = findViewById(R.id.btnConfirmarCadastro);
        btnConfirmarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Verifica se os campos estão vazios
                if(cadastroUsuario.getText().toString().equals("")){
                    Toast.makeText(CadastroActivity.this, "Campo Usuário é Obrigatório, Tente novamente!", Toast.LENGTH_LONG).show();
                }
                else if(cadastroSenha.getText().toString().equals("")){
                    Toast.makeText(CadastroActivity.this, "Campo senha é Obrigatório, Tente novamente!", Toast.LENGTH_LONG).show();
                }
                else if(confirmarSenha.getText().toString().equals("")){
                    Toast.makeText(CadastroActivity.this, "Campo confirmação de senha é Obrigatório, Tente novamente!", Toast.LENGTH_LONG).show();
                }

                //Verifica se o campo senha é diferente do campo confirmação de senha
                else if(cadastroSenha.getText().toString() != confirmarSenha.getText().toString()){
                    Toast.makeText(CadastroActivity.this, "Senhas informadas não conferem, Tente Novamente!", Toast.LENGTH_LONG).show();
                }

                //Caso valide verficações pressegue com o insert do usuario no BD
                else{
                    UsuarioModel model = new UsuarioModel();
                    model.setUsuario(cadastroUsuario.getText().toString());
                    model.setSenha(cadastroSenha.getText().toString());

                    // Valida erro ao fazer o INSERT
                    if (daoCadastro.Insert(model) != -1) {
                        Toast.makeText(CadastroActivity.this, "Usuário Cadastrado!", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(CadastroActivity.this, LoginActivity.class));
                    } else {
                        Toast.makeText(CadastroActivity.this, "Ocorreu um erro!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        txtVoltar = findViewById(R.id.txtVoltar);
        txtVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CadastroActivity.this, LoginActivity.class));
            }
        });
    }
}

package com.example.custoviagem.database.model;

public class UsuarioModel {

    public static final String
    TABELA_NOME = "tb_usuario";

    public static final String
    COLUNA_ID = "_id",
    COLUNA_USUARIO = "usuario",
    COLUNA_SENHA = "senha";

    public static final String
        CREATE_TABLE = "create table "+TABELA_NOME
                            +"("
                            + COLUNA_ID + " integer primary key autoincrement, "
                            + COLUNA_USUARIO + " text not null, "
                            + COLUNA_SENHA + " text not null "
                            +");";

    public static final String
    DROP_TABLE = "drop table if exists "+TABELA_NOME;

    /*=========================================================

    ATRIBUTOS DE MANIPULAÇÃO DO USUÁRIO

    ===========================================================*/

    private long id;
    private String usuario;
    private String senha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}

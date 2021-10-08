package com.example.custoviagem.database.model;

public class CustoViagemModel {


    public static final String
            TABELA_NOME = "tb_custoviagem";

    public static final String
            COLUNA_ID = "_id",
            COLUNA_TOTAL_VIAJANTE = "totalViajante",
            COLUNA_DURACAO = "duracaoViagem",
            COLUNA_VLRTOTAL = "custoTotalViagem",
            COLUNA_VLRPESSOA = "custoTotalPessoa";

    public static final String
            CREATE_TABLE = "create table "+TABELA_NOME
            +"("
            + COLUNA_ID + " integer primary key autoincrement, "
            + COLUNA_TOTAL_VIAJANTE + " text not null, "
            + COLUNA_DURACAO + " text not null "
            + COLUNA_VLRTOTAL + " text not null "
            + COLUNA_VLRPESSOA + " text not null "
            +");";

    public static final String
            DROP_TABLE = "drop table if exists "+TABELA_NOME;

    /*=========================================================

    ATRIBUTOS DE MANIPULAÇÃO DO USUÁRIO

    ===========================================================*/

    private long id;
    private String totalViajante;
    private String duracaoViagem;
    private String custoTotalViagem;
    private String custoTotalPessoa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTotalViajante() {
        return totalViajante;
    }

    public void setTotalViajante(String totalViajante) {
        this.totalViajante = totalViajante;
    }

    public String getDuracaoViagem() {
        return duracaoViagem;
    }

    public void setDuracaoViagem(String duracaoViagem) {
        this.duracaoViagem = duracaoViagem;
    }

    public String getCustoTotalViagem() {
        return custoTotalViagem;
    }

    public void setCustoTotalViagem(String custoTotalViagem) {
        this.custoTotalViagem = custoTotalViagem;
    }

    public String getCustoTotalPessoa() {
        return custoTotalPessoa;
    }

    public void setCustoTotalPessoa(String totalPessoa) {
        this.custoTotalPessoa = totalPessoa;
    }
}

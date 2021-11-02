package com.example.custoviagem.database.model;

public class CustoViagemModel {


    public static final String
            TABELA_NOME = "tb_custoviagem";

    public static final String
            COLUNA_ID = "_id",
            COLUNA_TOTAL_VIAJANTE = "totalViajante",
            COLUNA_DURACAO = "duracaoViagem",
            COLUNA_VLRTOTAL = "custoTotalViagem",
            COLUNA_VLRPESSOA = "custoTotalPessoa",
            COLUNA_ORIGEM = "origem",
            COLUNA_DESTINO = "destino";

    public static final String
            CREATE_TABLE = "create table "+TABELA_NOME
            +"("
            + COLUNA_ID + " integer primary key autoincrement, "
            + COLUNA_TOTAL_VIAJANTE + " text not null, "
            + COLUNA_DURACAO + " text not null, "
            + COLUNA_VLRTOTAL + " text not null, "
            + COLUNA_VLRPESSOA + " text not null, "
            + COLUNA_ORIGEM + " text not null, "
            + COLUNA_DESTINO + " text not null "
            +");";

    public static final String
            DROP_TABLE = "drop table if exists "+TABELA_NOME;

    /*=========================================================

    ATRIBUTOS DE MANIPULAÇÃO DO USUÁRIO

    ===========================================================*/

    private Long id;
    private String totalViajante;
    private String duracaoViagem;
    private String custoTotalViagem;
    private String custoTotalPessoa;
    private String origem;
    private String destino;

//    public CustoViagemModel(final String custoTotalViagem,final String destino) {
//        this.custoTotalViagem = custoTotalViagem;
//        this.destino = destino;
//    }

//    public CustoViagemModel(){}



    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String toString(){
        return getId() + " - Destino: " + getDestino();
    }
}

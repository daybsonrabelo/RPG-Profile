package br.com.prymos.rpgprofile.models;

import java.util.Date;

/**
 * Created by daybson on 31/05/2016.
 */
public class Perfil_PER {
    private long PER_CODIGO_PERFIL;
    private String PER_NOME;
    private String PER_JOGADOR;
    private String PER_CRONICA;
    private String PER_NATUREZA;
    private String PER_COMPORTAMENTO;
    private String PER_CLA;
    private String PER_GERACAO;
    private String PER_REFUGIO;
    private String PER_CONCEITO;
    private Date PER_DATA_CADASTRO;
    private int PER_PHOTO;

    public long getPER_CODIGO_PERFIL() {
        return PER_CODIGO_PERFIL;
    }

    public void setPER_CODIGO_PERFIL(long PER_CODIGO_PERFIL) {
        this.PER_CODIGO_PERFIL = PER_CODIGO_PERFIL;
    }

    public String getPER_NOME() {
        return PER_NOME;
    }

    public void setPER_NOME(String PER_NOME) {
        this.PER_NOME = PER_NOME;
    }

    public String getPER_JOGADOR() {
        return PER_JOGADOR;
    }

    public void setPER_JOGADOR(String PER_JOGADOR) {
        this.PER_JOGADOR = PER_JOGADOR;
    }

    public String getPER_CRONICA() {
        return PER_CRONICA;
    }

    public void setPER_CRONICA(String PER_CRONICA) {
        this.PER_CRONICA = PER_CRONICA;
    }

    public String getPER_NATUREZA() {
        return PER_NATUREZA;
    }

    public void setPER_NATUREZA(String PER_NATUREZA) {
        this.PER_NATUREZA = PER_NATUREZA;
    }

    public String getPER_COMPORTAMENTO() {
        return PER_COMPORTAMENTO;
    }

    public void setPER_COMPORTAMENTO(String PER_COMPORTAMENTO) {
        this.PER_COMPORTAMENTO = PER_COMPORTAMENTO;
    }

    public String getPER_CLA() {
        return PER_CLA;
    }

    public void setPER_CLA(String PER_CLA) {
        this.PER_CLA = PER_CLA;
    }

    public String getPER_GERACAO() {
        return PER_GERACAO;
    }

    public void setPER_GERACAO(String PER_GERACAO) {
        this.PER_GERACAO = PER_GERACAO;
    }

    public String getPER_REFUGIO() {
        return PER_REFUGIO;
    }

    public void setPER_REFUGIO(String PER_REFUGIO) {
        this.PER_REFUGIO = PER_REFUGIO;
    }

    public String getPER_CONCEITO() {
        return PER_CONCEITO;
    }

    public void setPER_CONCEITO(String PER_CONCEITO) {
        this.PER_CONCEITO = PER_CONCEITO;
    }

    public Date getPER_DATA_CADASTRO() {
        return PER_DATA_CADASTRO;
    }

    public void setPER_DATA_CADASTRO(Date PER_DATA_CADASTRO) {
        this.PER_DATA_CADASTRO = PER_DATA_CADASTRO;
    }

    public int getPER_PHOTO() {
        return PER_PHOTO;
    }

    public void setPER_PHOTO(int PER_PHOTO) {
        this.PER_PHOTO = PER_PHOTO;
    }

    @Override
    public String toString() {
        return "Perfil_PER{" +
                "PER_CODIGO_PERFIL=" + PER_CODIGO_PERFIL +
                ", PER_NOME='" + PER_NOME + '\'' +
                ", PER_JOGADOR='" + PER_JOGADOR + '\'' +
                ", PER_CRONICA='" + PER_CRONICA + '\'' +
                ", PER_NATUREZA='" + PER_NATUREZA + '\'' +
                ", PER_COMPORTAMENTO='" + PER_COMPORTAMENTO + '\'' +
                ", PER_CLA='" + PER_CLA + '\'' +
                ", PER_GERACAO='" + PER_GERACAO + '\'' +
                ", PER_REFUGIO='" + PER_REFUGIO + '\'' +
                ", PER_CONCEITO='" + PER_CONCEITO + '\'' +
                ", PER_DATA_CADASTRO=" + PER_DATA_CADASTRO +
                ", PER_PHOTO=" + PER_PHOTO +
                '}';
    }
}

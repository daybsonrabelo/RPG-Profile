package br.com.prymos.rpgprofile.dao;

import android.provider.BaseColumns;

/**
 * Created by daybson on 19/08/2016.
 */
public class PerfilTable implements BaseColumns {
    public static final String NAME = "Perfil_PER";
    public static final String PER_CODIGO_PERFIL = "PER_CODIGO_PERFIL";
    public static final String PER_NOME = "PER_NOME";
    public static final String PER_JOGADOR = "PER_JOGADOR";
    public static final String PER_CRONICA = "PER_CRONICA";
    public static final String PER_NATUREZA = "PER_NATUREZA";
    public static final String PER_COMPORTAMENTO = "PER_COMPORTAMENTO";
    public static final String PER_CLA = "PER_CLA";
    public static final String PER_GERACAO = "PER_GERACAO";
    public static final String PER_REFUGIO = "PER_REFUGIO";
    public static final String PER_CONCEITO = "PER_CONCEITO";
    public static final String PER_DATA_CADASTRO = "PER_DATA_CADASTRO";
    public static final String PER_PHOTO = "PER_PHOTO";

    public static String[] colunas = new String[] {
            PER_CODIGO_PERFIL,
            PER_NOME,
            PER_JOGADOR,
            PER_CRONICA,
            PER_NATUREZA,
            PER_COMPORTAMENTO,
            PER_CLA,
            PER_GERACAO,
            PER_REFUGIO,
            PER_CONCEITO,
            PER_DATA_CADASTRO,
            PER_PHOTO
    };

    public static final String CREATE = "CREATE TABLE " + NAME +
            " (PER_CODIGO_PERFIL INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            "PER_NOME TEXT NOT NULL, PER_JOGADOR TEXT NOT NULL, " +
            "PER_CRONICA TEXT NOT NULL, PER_NATUREZA TEXT NOT NULL, " +
            "PER_COMPORTAMENTO TEXT NOT NULL, PER_CLA TEXT NOT NULL, " +
            "PER_GERACAO TEXT NOT NULL, PER_REFUGIO TEXT, PER_CONCEITO TEXT, " +
            "PER_DATA_CADASTRO DATETIME NOT NULL, PER_PHOTO INTEGER); ";

    public static final String DROP = "DROP TABLE IF EXISTS " + NAME;
}

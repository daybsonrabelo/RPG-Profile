package br.com.prymos.rpgprofile.dao;

import android.provider.BaseColumns;

/**
 * Created by daybson on 23/08/2016.
 */
public class AtributosTable implements BaseColumns {
    public static final String NAME = "Atributos_ATR";
    public static final String ATR_CODIGO_ATRIBUTO = "ATR_CODIGO_ATRIBUTO";
    public static final String ATR_FORCA = "ATR_FORCA";
    public static final String ATR_DESTREZA = "ATR_DESTREZA";
    public static final String ATR_VIGOR = "ATR_VIGOR";
    public static final String ATR_CARISMA = "ATR_CARISMA";
    public static final String ATR_MANIPULACAO = "ATR_MANIPULACAO";
    public static final String ATR_APARENCIA = "ATR_APARENCIA";
    public static final String ATR_PERCEPCAO = "ATR_PERCEPCAO";
    public static final String ATR_INTELIGENCIA = "ATR_INTELIGENCIA";
    public static final String ATR_RACIOCINIO = "ATR_RACIOCINIO";
    public static final String PER_CODIGO_PERFIL = "PER_CODIGO_PERFIL";

    public static String[] colunas = new String[] {
            ATR_CODIGO_ATRIBUTO,
            ATR_FORCA,
            ATR_DESTREZA,
            ATR_VIGOR,
            ATR_CARISMA,
            ATR_MANIPULACAO,
            ATR_APARENCIA,
            ATR_PERCEPCAO,
            ATR_INTELIGENCIA,
            ATR_RACIOCINIO,
            PER_CODIGO_PERFIL
    };

    public static final String CREATE = "CREATE TABLE " + NAME +
            " (ATR_CODIGO_ATRIBUTO INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            "ATR_FORCA INTEGER, ATR_DESTREZA INTEGER, ATR_VIGOR INTEGER, " +
            "ATR_CARISMA INTEGER, ATR_MANIPULACAO INTEGER, ATR_APARENCIA INTEGER, " +
            "ATR_PERCEPCAO INTEGER, ATR_INTELIGENCIA INTEGER, ATR_RACIOCINIO INTEGER, " +
            "PER_CODIGO_PERFIL INTEGER NOT NULL); ";

    public static final String DROP = "DROP TABLE IF EXISTS " + NAME;
}

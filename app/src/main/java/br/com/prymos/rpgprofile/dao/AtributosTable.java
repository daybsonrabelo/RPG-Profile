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

    public static final String CREATE = String.format(
            "CREATE TABLE %1$s (" +
                    "%2$S INTEGER PRYMARY KEY AUTO_INCREMENT NOT NULL, " +
                    "%3$S INTEGER, " +
                    "%4$S INTEGER, " +
                    "%5$S INTEGER, " +
                    "%6$S INTEGER, " +
                    "%7$S INTEGER, " +
                    "%8$S INTEGER, " +
                    "%9$S INTEGER, " +
                    "%10$S INTEGER, " +
                    "%11$S INTEGER, " +
                    "%12$S INTEGER) ",
            NAME,
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
    );

    public static final String DROP = String.format("DROP TABLE %1$s", NAME);
}

package br.com.prymos.rpgprofile.dao;

import android.provider.BaseColumns;

/**
 * Created by daybson on 02/09/2016.
 */
public class ConfiguracoesTable implements BaseColumns {
    public static final String NAME = "Configuracoes_CON";
    public static final String CON_CODIGO_CONFIGURACAO = "CON_CODIGO_CONFIGURACAO";
    public static final String CON_QTDE_PTS_ATR = "CON_QTDE_PTS_ATR";
    public static final String CON_QTDE_PTS_HAB = "CON_QTDE_PTS_HAB";
    public static final String CON_QTDE_PTS_VAN = "CON_QTDE_PTS_VAN";
    public static final String CON_QTDE_PTS_BNS = "CON_QTDE_PTS_BNS";
    public static final String PER_CODIGO_PERFIL = "PER_CODIGO_PERFIL";

    public static String[] colunas = new String[] {
            CON_CODIGO_CONFIGURACAO,
            CON_QTDE_PTS_ATR,
            CON_QTDE_PTS_HAB,
            CON_QTDE_PTS_VAN,
            CON_QTDE_PTS_BNS,
            PER_CODIGO_PERFIL
    };

    public static final String CREATE = "CREATE TABLE " + NAME +
            " (CON_CODIGO_CONFIGURACAO INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            "CON_QTDE_PTS_ATR INTEGER NOT NULL, CON_QTDE_PTS_HAB INTEGER NOT NULL, " +
            "CON_QTDE_PTS_VAN INTEGER NOT NULL, CON_QTDE_PTS_BNS INTEGER NOT NULL, " +
            "PER_CODIGO_PERFIL INTEGER NOT NULL); ";

    public static final String DROP = "DROP TABLE IF EXISTS " + NAME;
}

package br.com.prymos.rpgprofile.repository;

import android.content.Context;

import br.com.prymos.rpgprofile.dao.SQLiteHelper;

/**
 * Created by daybson on 01/06/2016.
 */
public class RepositorioPerfilScript extends RepositorioPerfil {
    private static final String TABELA = "Perfil_PER";
    private static final String SCRIPT_DATABASE_DELETE = "DROP TABLE IF EXISTS " + TABELA;
    private static final String[] SCRIPT_DATABASE_CREATE = new String[] {
            "CREATE TABLE " + TABELA + " (PER_CODIGO_PERFIL INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "PER_NOME TEXT NOT NULL, PER_JOGADOR TEXT NOT NULL, " +
                    "PER_CRONICA TEXT NOT NULL, PER_NATUREZA TEXT NOT NULL, " +
                    "PER_COMPORTAMENTO TEXT NOT NULL, PER_CLA TEXT NOT NULL, " +
                    "PER_GERACAO TEXT NOT NULL, PER_REFUGIO TEXT, PER_CONCEITO TEXT, "+
                    "PER_DATA_CADASTRO DATETIME NOT NULL, PER_PHOTO INTEGER);"
    };

    private static final String NOME_BANCO = "rpg_profile";
    private static final int VERSAO_BANCO = 1;
    public SQLiteHelper dbHelper;

    public RepositorioPerfilScript(Context context) {
        dbHelper = new SQLiteHelper(context, RepositorioPerfilScript.VERSAO_BANCO,
                RepositorioPerfilScript.SCRIPT_DATABASE_CREATE,
                RepositorioPerfilScript.SCRIPT_DATABASE_DELETE);
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public void fechar() {
        super.fechar();
        if (dbHelper != null) {
            dbHelper.close();
        }
    }
}

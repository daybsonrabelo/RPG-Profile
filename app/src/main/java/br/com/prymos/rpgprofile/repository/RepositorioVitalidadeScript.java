package br.com.prymos.rpgprofile.repository;

import android.content.Context;

import br.com.prymos.rpgprofile.dao.SQLiteHelper;

/**
 * Created by daybson on 01/06/2016.
 */
public class RepositorioVitalidadeScript extends RepositorioVitalidade {
    private static final String TABELA = "Vitalidade_VIT";
    private static final String SCRIPT_DATABASE_DELETE = "DROP TABLE IF EXISTS " + TABELA;
    private static final String[] SCRIPT_DATABASE_CREATE = new String[] {
            "CREATE TABLE " + TABELA + " (VIT_CODIGO_VITALIDADE INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "VIT_DESCRICAO TEXT NOT NULL, VIT_REDUTOR INTEGER NOT NULL);",
            "INSERT INTO " + TABELA + "(VIT_DESCRICAO, VIT_REDUTOR) " +
                    "VALUES (Escoriado, 0);",
            "INSERT INTO " + TABELA + "(VIT_DESCRICAO, VIT_REDUTOR) " +
                    "VALUES (Machucado, 1);",
            "INSERT INTO " + TABELA + "(VIT_DESCRICAO, VIT_REDUTOR) " +
                    "VALUES (Ferido, 1);",
            "INSERT INTO " + TABELA + "(VIT_DESCRICAO, VIT_REDUTOR) " +
                    "VALUES (Ferido Gravemente, 2);",
            "INSERT INTO " + TABELA + "(VIT_DESCRICAO, VIT_REDUTOR) " +
                    "VALUES (Espancado, 2);",
            "INSERT INTO " + TABELA + "(VIT_DESCRICAO, VIT_REDUTOR) " +
                    "VALUES (Aleijado, 5);",
            "INSERT INTO " + TABELA + "(VIT_DESCRICAO, VIT_REDUTOR) " +
                    "VALUES (Incapacitado, 0);",
    };

    private static final int VERSAO_BANCO = 1;
    public SQLiteHelper dbHelper;

    public RepositorioVitalidadeScript(Context context) {
        dbHelper = new SQLiteHelper(context);
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
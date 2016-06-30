package br.com.prymos.rpgprofile.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.prymos.rpgprofile.dao.SQLiteHelper;

/**
 * Created by daybson on 01/06/2016.
 */
public class RepositorioVitalidade {
    private static final String CATEGORIA = "RepositorioVitalidade";
    protected SQLiteDatabase db;

    public RepositorioVitalidade(Context context) {
        db = context.openOrCreateDatabase(SQLiteHelper.NOME_BANCO, Context.MODE_PRIVATE, null);
    }

    protected RepositorioVitalidade() {

    }

    public void fechar() {
        if (db != null) {
            db.close();
        }
    }
}

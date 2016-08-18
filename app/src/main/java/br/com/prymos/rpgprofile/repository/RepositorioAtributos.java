package br.com.prymos.rpgprofile.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.prymos.rpgprofile.dao.SQLiteHelper;

/**
 * Created by daybson on 18/08/2016.
 */
public class RepositorioAtributos {
    private static final String CATEGORIA = "RepositorioAtributos";
    protected SQLiteDatabase db;

    public RepositorioAtributos(Context context) {
        db = context.openOrCreateDatabase(SQLiteHelper.NOME_BANCO, Context.MODE_PRIVATE, null);
    }

    protected RepositorioAtributos() {

    }

    public void fechar() {
        if (db != null) {
            db.close();
        }
    }
}

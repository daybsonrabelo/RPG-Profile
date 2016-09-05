package br.com.prymos.rpgprofile.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

/**
 * Created by daybson on 31/05/2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "rpg_profile";
    private static final int DATABASE_VERSION = 1;
    private static final String CATEGORIA = "SQLiteHelper";

    /***
     * Cria uma instância de SQLiteHelper
     *
     * @param context
     */
    public SQLiteHelper(Context context) {
        super(context, NOME_BANCO, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(CATEGORIA, "Criando as tabelas na base de dados");
        db.execSQL(PerfilTable.CREATE);
        db.execSQL(AtributosTable.CREATE);
        db.execSQL(HabilidadesTable.CREATE);
        db.execSQL(ConfiguracoesTable.CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > oldVersion) {
            Log.w(CATEGORIA, "Atualizando base de dados da versão " + oldVersion + " para " +
                    newVersion + ". Todos os registros serão deletados.");
            db.execSQL(PerfilTable.DROP);
            db.execSQL(AtributosTable.DROP);
            db.execSQL(HabilidadesTable.DROP);
            db.execSQL(ConfiguracoesTable.DROP);
            onCreate(db);
        }
    }
}

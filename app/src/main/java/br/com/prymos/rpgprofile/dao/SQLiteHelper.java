package br.com.prymos.rpgprofile.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by daybson on 31/05/2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "rpg_profile";
    private static final String CATEGORIA = "SQLiteHelper";
    private String[] scriptSQLCreate;
    private String scriptSQLDelete;

    /***
     * Cria uma instância de SQLiteHelper
     *
     * @param context
     * @param versaoBanco versão do bando de dados(se for diferente é para atualizar)
     * @param scriptSQLCreate SQL para criar a tabela
     * @param scriptSQLDelete SQL para apagar a tabela
     */
    public SQLiteHelper(Context context, int versaoBanco, String[] scriptSQLCreate,
                        String scriptSQLDelete) {
        super(context, NOME_BANCO, null, versaoBanco);
        this.scriptSQLCreate = scriptSQLCreate;
        this.scriptSQLDelete = scriptSQLDelete;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(CATEGORIA, "Criando a tabela na base de dados");
        int qtdeScripts = scriptSQLCreate.length;
        for (int i = 0; i < qtdeScripts; i++) {
            String sql = scriptSQLCreate[i];
            Log.i(CATEGORIA, sql);
            db.execSQL(sql);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(CATEGORIA, "Atualizando da versão " + oldVersion + " para " +
                newVersion + ". Todos os registros serão deletados.");
        Log.i(CATEGORIA, scriptSQLDelete);
        db.execSQL(scriptSQLDelete);
        onCreate(db);
    }
}

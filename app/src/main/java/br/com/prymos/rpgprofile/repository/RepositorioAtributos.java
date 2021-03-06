package br.com.prymos.rpgprofile.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.prymos.rpgprofile.dao.AtributosTable;
import br.com.prymos.rpgprofile.dao.SQLiteHelper;
import br.com.prymos.rpgprofile.models.Atributos_ATR;

/**
 * Created by daybson on 18/08/2016.
 */
public class RepositorioAtributos {
    private static final String CATEGORIA = "RepositorioAtributos";
    private static final String NOME_TABELA = "Atributos_ATR";
    protected SQLiteDatabase db;
    private SQLiteHelper dbHelper;

    public RepositorioAtributos(Context context) {
        dbHelper = new SQLiteHelper(context);
        db = context.openOrCreateDatabase(SQLiteHelper.NOME_BANCO, Context.MODE_PRIVATE, null);
        db = dbHelper.getWritableDatabase();
    }

    protected RepositorioAtributos() {

    }

    public long salvar(Atributos_ATR atr) {
        long codigo_atributo = atr.getATR_CODIGO_ATRIBUTO();
        if (codigo_atributo != 0) {
            atualizar(atr);
        } else {
            codigo_atributo = inserir(atr);
        }
        return codigo_atributo;
    }

    private long inserir(Atributos_ATR atr) {
        ContentValues values = getContentValues(atr);

        long codigo_atributo = inserir(values);
        return codigo_atributo;
    }

    private long inserir(ContentValues values) {
        long codigo_atributo = db.insert(NOME_TABELA, "", values);
        return codigo_atributo;
    }

    private int atualizar(Atributos_ATR atr) {
        ContentValues values = getContentValues(atr);

        String codigo_atributo = String.valueOf(atr.getATR_CODIGO_ATRIBUTO());
        String where = "ATR_CODIGO_ATRIBUTO = ?";
        String[] whereArgs = new String[] {codigo_atributo};
        int count = atualizar(values, where, whereArgs);
        return count;
    }

    private int atualizar(ContentValues values, String where, String[] whereArgs) {
        int count = db.update(NOME_TABELA, values, where, whereArgs);
        Log.i(CATEGORIA, "Atualizou [" + count + "] registros");
        return count;
    }

    public Atributos_ATR buscarAtributoPorPerfil(long idPerfil){
        Cursor c = db.query(true, NOME_TABELA, AtributosTable.colunas,
                AtributosTable.PER_CODIGO_PERFIL+ "=" + idPerfil, null, null, null, null, null);
        if (c.getCount() > 0) {
            c.moveToFirst();

            int idxCodigo = c.getColumnIndex(AtributosTable.ATR_CODIGO_ATRIBUTO);
            int idxForca = c.getColumnIndex(AtributosTable.ATR_FORCA);
            int idxDestreza = c.getColumnIndex(AtributosTable.ATR_DESTREZA);
            int idxVigor = c.getColumnIndex(AtributosTable.ATR_VIGOR);
            int idxCarisma = c.getColumnIndex(AtributosTable.ATR_CARISMA);
            int idxManipulacao = c.getColumnIndex(AtributosTable.ATR_MANIPULACAO);
            int idxAparencia = c.getColumnIndex(AtributosTable.ATR_APARENCIA);
            int idxPercepcao = c.getColumnIndex(AtributosTable.ATR_PERCEPCAO);
            int idxInteligencia = c.getColumnIndex(AtributosTable.ATR_INTELIGENCIA);
            int idxRaciocinio = c.getColumnIndex(AtributosTable.ATR_RACIOCINIO);
            int idxCodigoPerfil = c.getColumnIndex(AtributosTable.PER_CODIGO_PERFIL);

            Atributos_ATR atr = new Atributos_ATR();

            atr.setATR_CODIGO_ATRIBUTO(c.getLong(idxCodigo));
            atr.setATR_FORCA(c.getInt(idxForca));
            atr.setATR_DESTREZA(c.getInt(idxDestreza));
            atr.setATR_VIGOR(c.getInt(idxVigor));
            atr.setATR_CARISMA(c.getInt(idxCarisma));
            atr.setATR_MANIPULACAO(c.getInt(idxManipulacao));
            atr.setATR_APARENCIA(c.getInt(idxAparencia));
            atr.setATR_PERCEPCAO(c.getInt(idxPercepcao));
            atr.setATR_INTELIGENCIA(c.getInt(idxInteligencia));
            atr.setATR_RACIOCINIO(c.getInt(idxRaciocinio));
            atr.setPER_CODIGO_PERFIL(c.getLong(idxCodigoPerfil));

            return atr;
        }
        return null;
    }

    private ContentValues getContentValues(Atributos_ATR atr){
        ContentValues values = new ContentValues();

        values.put(AtributosTable.ATR_FORCA, atr.getATR_FORCA());
        values.put(AtributosTable.ATR_DESTREZA, atr.getATR_DESTREZA());
        values.put(AtributosTable.ATR_VIGOR, atr.getATR_VIGOR());
        values.put(AtributosTable.ATR_CARISMA, atr.getATR_CARISMA());
        values.put(AtributosTable.ATR_MANIPULACAO, atr.getATR_MANIPULACAO());
        values.put(AtributosTable.ATR_APARENCIA, atr.getATR_APARENCIA());
        values.put(AtributosTable.ATR_PERCEPCAO, atr.getATR_PERCEPCAO());
        values.put(AtributosTable.ATR_INTELIGENCIA, atr.getATR_INTELIGENCIA());
        values.put(AtributosTable.ATR_RACIOCINIO, atr.getATR_RACIOCINIO());
        values.put(AtributosTable.PER_CODIGO_PERFIL, atr.getPER_CODIGO_PERFIL());

        return values;
    }

    private Cursor getCursor() {
        try {
            return db.query(NOME_TABELA, AtributosTable.colunas, null, null, null, null, null, null);
        } catch (SQLException e) {
            Log.e(CATEGORIA, "Erro ao buscar os atributos: " + e.toString());
            return null;
        }
    }

    public void fechar() {
        if (db != null) {
            db.close();
        }
        if (dbHelper != null) {
            dbHelper.close();
        }
    }
}

package br.com.prymos.rpgprofile.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.prymos.rpgprofile.dao.PerfilTable;
import br.com.prymos.rpgprofile.dao.SQLiteHelper;
import br.com.prymos.rpgprofile.models.Perfil_PER;

/**
 * Created by daybson on 01/06/2016.
 */
public class RepositorioPerfil {
    private static final String CATEGORIA = "RepositorioPerfil";
    private static final String NOME_TABELA = "Perfil_PER";
    protected SQLiteDatabase db;
    private SQLiteHelper dbHelper;

    public RepositorioPerfil(Context context) {
        dbHelper = new SQLiteHelper(context);
        db = context.openOrCreateDatabase(SQLiteHelper.NOME_BANCO, Context.MODE_PRIVATE, null);
        db = dbHelper.getWritableDatabase();
    }

    protected RepositorioPerfil() {

    }

    public long salvar(Perfil_PER perfil) {
        long codigo_perfil = perfil.getPER_CODIGO_PERFIL();
        if (codigo_perfil != 0) {
            atualizar(perfil);
        } else {
            codigo_perfil = inserir(perfil);
        }
        return codigo_perfil;
    }

    private long inserir(Perfil_PER perfil) {
        ContentValues values = getContentValues(perfil);

        long codigo_perfil = inserir(values);
        return codigo_perfil;
    }

    private long inserir(ContentValues values) {
        long codigo_perfil = db.insert(NOME_TABELA, "", values);
        return codigo_perfil;
    }

    private int atualizar(Perfil_PER perfil) {
        ContentValues values = getContentValues(perfil);

        String codigo_perfil = String.valueOf(perfil.getPER_CODIGO_PERFIL());
        String where = "PER_CODIGO_PERFIL = ?";
        String[] whereArgs = new String[] {codigo_perfil};
        int count = atualizar(values, where, whereArgs);
        return count;
    }

    private int atualizar(ContentValues values, String where, String[] whereArgs) {
        int count = db.update(NOME_TABELA, values, where, whereArgs);
        Log.i(CATEGORIA, "Atualizou [" + count + "] registros");
        return count;
    }

    public int deletar(long codigo_perfil) {
        String _codigo_perfil = String.valueOf(codigo_perfil);
        String where = "PER_CODIGO_PERFIL = ?";
        String[] whereArgs = new String[] {_codigo_perfil};
        int count = deletar(where, whereArgs);
        return count;
    }

    private int deletar(String where, String[] whereArgs) {
        int count = db.delete(NOME_TABELA, where, whereArgs);
        Log.i(CATEGORIA, "Deletou [" + count + "] registros.");
        return count;
    }

    private ContentValues getContentValues(Perfil_PER perfil) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dataCadastro = sdf.format(perfil.getPER_DATA_CADASTRO());

        ContentValues values = new ContentValues();
        values.put(PerfilTable.PER_NOME, perfil.getPER_NOME());
        values.put(PerfilTable.PER_JOGADOR, perfil.getPER_JOGADOR());
        values.put(PerfilTable.PER_CRONICA, perfil.getPER_CRONICA());
        values.put(PerfilTable.PER_NATUREZA, perfil.getPER_NATUREZA());
        values.put(PerfilTable.PER_COMPORTAMENTO, perfil.getPER_COMPORTAMENTO());
        values.put(PerfilTable.PER_CLA, perfil.getPER_CLA());
        values.put(PerfilTable.PER_GERACAO, perfil.getPER_GERACAO());
        values.put(PerfilTable.PER_REFUGIO, perfil.getPER_REFUGIO());
        values.put(PerfilTable.PER_CONCEITO, perfil.getPER_CONCEITO());
        values.put(PerfilTable.PER_DATA_CADASTRO, dataCadastro);
        values.put(PerfilTable.PER_PHOTO, perfil.getPER_PHOTO());

        return values;
    }

    private Cursor getCursor() {
        try {
            return db.query(NOME_TABELA, PerfilTable.colunas, null, null, null, null, null, null);
        } catch (SQLException e) {
            Log.e(CATEGORIA, "Erro ao buscar os perfis: " + e.toString());
            return null;
        }
    }

    public ArrayList<Perfil_PER> listarPerfis() {
        Cursor c = getCursor();
        ArrayList<Perfil_PER> perfis = new ArrayList<Perfil_PER>();
        if (c.moveToFirst()) {
            int idxCodigo = c.getColumnIndex(PerfilTable.PER_CODIGO_PERFIL);
            int idxNome = c.getColumnIndex(PerfilTable.PER_NOME);
            int idxJogador = c.getColumnIndex(PerfilTable.PER_JOGADOR);
            int idxCronica = c.getColumnIndex(PerfilTable.PER_CRONICA);
            int idxNatureza = c.getColumnIndex(PerfilTable.PER_NATUREZA);
            int idxComportamento = c.getColumnIndex(PerfilTable.PER_COMPORTAMENTO);
            int idxCla = c.getColumnIndex(PerfilTable.PER_CLA);
            int idxGeracao = c.getColumnIndex(PerfilTable.PER_GERACAO);
            int idxRefugio = c.getColumnIndex(PerfilTable.PER_REFUGIO);
            int idxConceito = c.getColumnIndex(PerfilTable.PER_CONCEITO);
            int idxDataCadastro = c.getColumnIndex(PerfilTable.PER_DATA_CADASTRO);
            int idxPhoto = c.getColumnIndex(PerfilTable.PER_PHOTO);

            do {
                Perfil_PER perfil = new Perfil_PER();
                perfis.add(perfil);

                perfil.setPER_CODIGO_PERFIL(c.getLong(idxCodigo));
                perfil.setPER_NOME(c.getString(idxNome));
                perfil.setPER_JOGADOR(c.getString(idxJogador));
                perfil.setPER_CRONICA(c.getString(idxCronica));
                perfil.setPER_NATUREZA(c.getString(idxNatureza));
                perfil.setPER_COMPORTAMENTO(c.getString(idxComportamento));
                perfil.setPER_CLA(c.getString(idxCla));
                perfil.setPER_GERACAO(c.getString(idxGeracao));
                perfil.setPER_REFUGIO(c.getString(idxRefugio));
                perfil.setPER_CONCEITO(c.getString(idxConceito));
                perfil.setPER_DATA_CADASTRO(new Date(c.getLong(idxDataCadastro)));
                perfil.setPER_PHOTO(c.getInt(idxPhoto));

            } while (c.moveToNext());
        }
        return perfis;
    }

    public Perfil_PER buscarPerfil(long id) {
        Cursor c = db.query(true, NOME_TABELA, PerfilTable.colunas, PerfilTable.PER_CODIGO_PERFIL + "=" + id, null, null, null, null, null);
        if (c.getCount() > 0) {
            c.moveToFirst();

            int idxCodigo = c.getColumnIndex(PerfilTable.PER_CODIGO_PERFIL);
            int idxNome = c.getColumnIndex(PerfilTable.PER_NOME);
            int idxJogador = c.getColumnIndex(PerfilTable.PER_JOGADOR);
            int idxCronica = c.getColumnIndex(PerfilTable.PER_CRONICA);
            int idxNatureza = c.getColumnIndex(PerfilTable.PER_NATUREZA);
            int idxComportamento = c.getColumnIndex(PerfilTable.PER_COMPORTAMENTO);
            int idxCla = c.getColumnIndex(PerfilTable.PER_CLA);
            int idxGeracao = c.getColumnIndex(PerfilTable.PER_GERACAO);
            int idxRefugio = c.getColumnIndex(PerfilTable.PER_REFUGIO);
            int idxConceito = c.getColumnIndex(PerfilTable.PER_CONCEITO);
            int idxDataCadastro = c.getColumnIndex(PerfilTable.PER_DATA_CADASTRO);
            int idxPhoto = c.getColumnIndex(PerfilTable.PER_PHOTO);

            Perfil_PER perfil = new Perfil_PER();

            perfil.setPER_CODIGO_PERFIL(c.getLong(idxCodigo));
            perfil.setPER_NOME(c.getString(idxNome));
            perfil.setPER_JOGADOR(c.getString(idxJogador));
            perfil.setPER_CRONICA(c.getString(idxCronica));
            perfil.setPER_NATUREZA(c.getString(idxNatureza));
            perfil.setPER_COMPORTAMENTO(c.getString(idxComportamento));
            perfil.setPER_CLA(c.getString(idxCla));
            perfil.setPER_GERACAO(c.getString(idxGeracao));
            perfil.setPER_REFUGIO(c.getString(idxRefugio));
            perfil.setPER_CONCEITO(c.getString(idxConceito));
            perfil.setPER_DATA_CADASTRO(new Date(c.getLong(idxDataCadastro)));
            perfil.setPER_PHOTO(c.getInt(idxPhoto));

            return perfil;
        }
        return null;
    }

    public long buscarUltimoCodigoPerfil() {
        Cursor c = db.rawQuery("SELECT Max(PER_CODIGO_PERFIL) FROM Perfil_PER", null);
        long max = 0;
        if (c != null) {
            c.moveToFirst();
            max = c.getLong(0);
        }
        return max;
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

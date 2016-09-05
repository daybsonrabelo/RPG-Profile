package br.com.prymos.rpgprofile.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.prymos.rpgprofile.dao.ConfiguracoesTable;
import br.com.prymos.rpgprofile.dao.SQLiteHelper;
import br.com.prymos.rpgprofile.models.Configuracoes_CON;

/**
 * Created by daybson on 02/09/2016.
 */
public class RepositorioConfiguracoes {
    private static final String CATEGORIA = "RepositorioConfigs";
    private static final String NOME_TABELA = "Configuracoes_CON";
    protected SQLiteDatabase db;
    private SQLiteHelper dbHelper;

    public RepositorioConfiguracoes(Context context) {
        dbHelper = new SQLiteHelper(context);
        db = context.openOrCreateDatabase(SQLiteHelper.NOME_BANCO, Context.MODE_PRIVATE, null);
        db = dbHelper.getWritableDatabase();
    }

    public RepositorioConfiguracoes() {
    }

    public long salvar(Configuracoes_CON con) {
        long codigo_configuracao = con.getCON_CODIGO_CONFIGURACAO();
        if (codigo_configuracao != 0) {
            atualizar(con);
        } else {
            codigo_configuracao = inserir(con);
        }
        return codigo_configuracao;
    }

    private long inserir(Configuracoes_CON con) {
        ContentValues values = getContentValues(con);

        long codigo_configuracao = inserir(values);
        return codigo_configuracao;
    }

    private long inserir(ContentValues values) {
        long codigo_configuracao = db.insert(NOME_TABELA, "", values);
        return codigo_configuracao;
    }

    private int atualizar(Configuracoes_CON con) {
        ContentValues values = getContentValues(con);

        String codigo_configuracao = String.valueOf(con.getCON_CODIGO_CONFIGURACAO());
        String where = "CON_CODIGO_CONFIGURACAO = ?";
        String[] whereArgs = new String[] {codigo_configuracao};
        int count = atualizar(values, where, whereArgs);
        return count;
    }

    private int atualizar(ContentValues values, String where, String[] whereArgs) {
        int count = db.update(NOME_TABELA, values, where, whereArgs);
        Log.i(CATEGORIA, "Atualizou [" + count + "] registros");
        return count;
    }

    public Configuracoes_CON buscarConfiguracoesPorPerfil(long idPerfil) {
        Cursor c = db.query(true, NOME_TABELA, ConfiguracoesTable.colunas,
                ConfiguracoesTable.PER_CODIGO_PERFIL+ "=" + idPerfil, null, null, null, null, null);
        if (c.getCount() > 0) {
            c.moveToFirst();

            int idxCodigo = c.getColumnIndex(ConfiguracoesTable.CON_CODIGO_CONFIGURACAO);
            int idxPtsAtr = c.getColumnIndex(ConfiguracoesTable.CON_QTDE_PTS_ATR);
            int idxPtsHab = c.getColumnIndex(ConfiguracoesTable.CON_QTDE_PTS_HAB);
            int idxPtsVan = c.getColumnIndex(ConfiguracoesTable.CON_QTDE_PTS_VAN);
            int idxPtsBns = c.getColumnIndex(ConfiguracoesTable.CON_QTDE_PTS_BNS);
            int idxCodigoPerfil = c.getColumnIndex(ConfiguracoesTable.PER_CODIGO_PERFIL);

            Configuracoes_CON con = new Configuracoes_CON();

            con.setCON_CODIGO_CONFIGURACAO(c.getLong(idxCodigo));
            con.setCON_PTS_ATR(c.getInt(idxPtsAtr));
            con.setCON_PTS_HAB(c.getInt(idxPtsHab));
            con.setCON_PTS_VAN(c.getInt(idxPtsVan));
            con.setCON_PTS_BNS(c.getInt(idxPtsBns));
            con.setPER_CODIGO_PERFIL(c.getLong(idxCodigoPerfil));

            return con;
        }
        return null;
    }

    private ContentValues getContentValues(Configuracoes_CON con) {
        ContentValues values = new ContentValues();

        values.put(ConfiguracoesTable.CON_QTDE_PTS_ATR, con.getCON_PTS_ATR());
        values.put(ConfiguracoesTable.CON_QTDE_PTS_HAB, con.getCON_PTS_HAB());
        values.put(ConfiguracoesTable.CON_QTDE_PTS_VAN, con.getCON_PTS_VAN());
        values.put(ConfiguracoesTable.CON_QTDE_PTS_BNS, con.getCON_PTS_BNS());
        values.put(ConfiguracoesTable.PER_CODIGO_PERFIL, con.getPER_CODIGO_PERFIL());

        return values;
    }

    private Cursor getCursor() {
        try {
            return db.query(NOME_TABELA, ConfiguracoesTable.colunas, null, null, null, null, null, null);
        } catch (SQLException e) {
            Log.e(CATEGORIA, "Erro ao buscar as configurações: " + e.toString());
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

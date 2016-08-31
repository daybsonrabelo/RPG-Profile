package br.com.prymos.rpgprofile.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.prymos.rpgprofile.dao.AtributosTable;
import br.com.prymos.rpgprofile.dao.HabilidadesTable;
import br.com.prymos.rpgprofile.dao.SQLiteHelper;
import br.com.prymos.rpgprofile.models.Habilidades_HAB;

/**
 * Created by daybson on 30/08/2016.
 */
public class RepositorioHabilidades {
    private static final String CATEGORIA = "RepositorioHabilidades";
    private static final String NOME_TABELA = "Habilidades_HAB";
    protected SQLiteDatabase db;
    private SQLiteHelper dbHelper;

    public RepositorioHabilidades(Context context) {
        dbHelper = new SQLiteHelper(context);
        db = context.openOrCreateDatabase(SQLiteHelper.NOME_BANCO, Context.MODE_PRIVATE, null);
        db = dbHelper.getWritableDatabase();
    }

    public RepositorioHabilidades() {
    }

    public long salvar(Habilidades_HAB hab) {
        long codigo_habilidade = hab.getHAB_CODIGO_HABILIDADE();
        if (codigo_habilidade != 0) {
            atualizar(hab);
        } else {
            codigo_habilidade = inserir(hab);
        }
        return codigo_habilidade;
    }

    private long inserir(Habilidades_HAB hab) {
        ContentValues values = getContentValues(hab);

        long codigo_habilidade = inserir(values);
        return codigo_habilidade;
    }

    private long inserir(ContentValues values) {
        long codigo_habilidade = db.insert(NOME_TABELA, "", values);
        return codigo_habilidade;
    }

    private int atualizar(Habilidades_HAB hab) {
        ContentValues values = getContentValues(hab);

        String codigo_habilidade = String.valueOf(hab.getHAB_CODIGO_HABILIDADE());
        String where = "HAB_CODIGO_HABILIDADE = ?";
        String[] whereArgs = new String[] {codigo_habilidade};
        int count = atualizar(values, where, whereArgs);
        return count;
    }

    private int atualizar(ContentValues values, String where, String[] whereArgs) {
        int count = db.update(NOME_TABELA, values, where, whereArgs);
        Log.i(CATEGORIA, "Atualizou [" + count + "] registros.");
        return count;
    }

    public Habilidades_HAB buscarHabilidadesPorPerfil(long idPerfil) {
        Cursor c = db.query(true, NOME_TABELA, HabilidadesTable.colunas,
                HabilidadesTable.PER_CODIGO_PERFIL + "=" + idPerfil, null, null, null, null, null);
        if (c.getCount() > 0) {
            c.moveToFirst();

            int idxCodigo = c.getColumnIndex(HabilidadesTable.HAB_CODIGO_HABILIDADE);
            int idxProntidao = c.getColumnIndex(HabilidadesTable.HAB_PRONTIDAO);
            int idxEsportes = c.getColumnIndex(HabilidadesTable.HAB_ESPORTES);
            int idxBriga = c.getColumnIndex(HabilidadesTable.HAB_BRIGA);
            int idxEsquiva = c.getColumnIndex(HabilidadesTable.HAB_ESQUIVA);
            int idxEmpatia = c.getColumnIndex(HabilidadesTable.HAB_EMPATIA);
            int idxExpressao = c.getColumnIndex(HabilidadesTable.HAB_EXPRESSAO);
            int idxIntimidacao = c.getColumnIndex(HabilidadesTable.HAB_INTIMIDACAO);
            int idxLideranca = c.getColumnIndex(HabilidadesTable.HAB_LIDERANCA);
            int idxManha = c.getColumnIndex(HabilidadesTable.HAB_MANHA);
            int idxLabia = c.getColumnIndex(HabilidadesTable.HAB_LABIA);
            int idxEmpatiaAnimais = c.getColumnIndex(HabilidadesTable.HAB_EMPATIA_ANIMAIS);
            int idxOficios = c.getColumnIndex(HabilidadesTable.HAB_OFICIOS);
            int idxConducao = c.getColumnIndex(HabilidadesTable.HAB_CONDUCAO);
            int idxEtiqueta = c.getColumnIndex(HabilidadesTable.HAB_ETIQUETA);
            int idxArmasFogo = c.getColumnIndex(HabilidadesTable.HAB_ARMAS_FOGO);
            int idxArmasBranca = c.getColumnIndex(HabilidadesTable.HAB_ARMAS_BRANCA);
            int idxPerformance = c.getColumnIndex(HabilidadesTable.HAB_PERFORMANCE);
            int idxSeguranca = c.getColumnIndex(HabilidadesTable.HAB_SEGURANCA);
            int idxFurtividade = c.getColumnIndex(HabilidadesTable.HAB_FURTIVIDADE);
            int idxSobrevivencia = c.getColumnIndex(HabilidadesTable.HAB_SOBREVIVENCIA);
            int idxAcademicos = c.getColumnIndex(HabilidadesTable.HAB_ACADEMICOS);
            int idxComputador = c.getColumnIndex(HabilidadesTable.HAB_COMPUTADOR);
            int idxFinancas = c.getColumnIndex(HabilidadesTable.HAB_FINANCAS);
            int idxInvestigacao = c.getColumnIndex(HabilidadesTable.HAB_INVESTIGACAO);
            int idxDireito = c.getColumnIndex(HabilidadesTable.HAB_DIREITO);
            int idxLinguistica = c.getColumnIndex(HabilidadesTable.HAB_LINGUISTICA);
            int idxMedicina = c.getColumnIndex(HabilidadesTable.HAB_MEDICINA);
            int idxOcultismo = c.getColumnIndex(HabilidadesTable.HAB_OCULTISMO);
            int idxPolitica = c.getColumnIndex(HabilidadesTable.HAB_POLITICA);
            int idxCiencia = c.getColumnIndex(HabilidadesTable.HAB_CIENCIA);
            int idxCodigoPerfil = c.getColumnIndex(HabilidadesTable.PER_CODIGO_PERFIL);

            Habilidades_HAB hab = new Habilidades_HAB();

            hab.setHAB_CODIGO_HABILIDADE(c.getLong(idxCodigo));
            hab.setHAB_PRONTIDAO(c.getInt(idxProntidao));
            hab.setHAB_ESPORTES(c.getInt(idxEsportes));
            hab.setHAB_BRIGA(c.getInt(idxBriga));
            hab.setHAB_ESQUIVA(c.getInt(idxEsquiva));
            hab.setHAB_EMPATIA(c.getInt(idxEmpatia));
            hab.setHAB_EXPRESSAO(c.getInt(idxExpressao));
            hab.setHAB_INTIMIDACAO(c.getInt(idxIntimidacao));
            hab.setHAB_LIDERANCA(c.getInt(idxLideranca));
            hab.setHAB_MANHA(c.getInt(idxManha));
            hab.setHAB_LABIA(c.getInt(idxLabia));
            hab.setHAB_EMPATIA_ANIMAIS(c.getInt(idxEmpatiaAnimais));
            hab.setHAB_OFICIOS(c.getInt(idxOficios));
            hab.setHAB_CONDUCAO(c.getInt(idxConducao));
            hab.setHAB_ETIQUETA(c.getInt(idxEtiqueta));
            hab.setHAB_ARMAS_FOGO(c.getInt(idxArmasFogo));
            hab.setHAB_ARMAS_BRANCA(c.getInt(idxArmasBranca));
            hab.setHAB_PERFORMANCE(c.getInt(idxPerformance));
            hab.setHAB_SEGURANCA(c.getInt(idxSeguranca));
            hab.setHAB_FURTIVIDADE(c.getInt(idxFurtividade));
            hab.setHAB_SOBREVIVENCIA(c.getInt(idxSobrevivencia));
            hab.setHAB_ACADEMICOS(c.getInt(idxAcademicos));
            hab.setHAB_COMPUTADOR(c.getInt(idxComputador));
            hab.setHAB_FINANCAS(c.getInt(idxFinancas));
            hab.setHAB_INVESTIGACAO(c.getInt(idxInvestigacao));
            hab.setHAB_DIREITO(c.getInt(idxDireito));
            hab.setHAB_LINGUISTICA(c.getInt(idxLinguistica));
            hab.setHAB_MEDICINA(c.getInt(idxMedicina));
            hab.setHAB_OCULTISMO(c.getInt(idxOcultismo));
            hab.setHAB_POLITICA(c.getInt(idxPolitica));
            hab.setHAB_CIENCIA(c.getInt(idxCiencia));
            hab.setPER_CODIGO_PERFIL(c.getLong(idxCodigoPerfil));

            return hab;
        }
        return null;
    }

    private ContentValues getContentValues(Habilidades_HAB hab) {
        ContentValues values = new ContentValues();

        values.put(HabilidadesTable.HAB_PRONTIDAO, hab.getHAB_PRONTIDAO());
        values.put(HabilidadesTable.HAB_ESPORTES, hab.getHAB_ESPORTES());
        values.put(HabilidadesTable.HAB_BRIGA, hab.getHAB_BRIGA());
        values.put(HabilidadesTable.HAB_ESQUIVA, hab.getHAB_ESQUIVA());
        values.put(HabilidadesTable.HAB_EMPATIA, hab.getHAB_EMPATIA());
        values.put(HabilidadesTable.HAB_EXPRESSAO, hab.getHAB_EXPRESSAO());
        values.put(HabilidadesTable.HAB_INTIMIDACAO, hab.getHAB_INTIMIDACAO());
        values.put(HabilidadesTable.HAB_LIDERANCA, hab.getHAB_LIDERANCA());
        values.put(HabilidadesTable.HAB_MANHA, hab.getHAB_MANHA());
        values.put(HabilidadesTable.HAB_LABIA, hab.getHAB_LABIA());
        values.put(HabilidadesTable.HAB_EMPATIA_ANIMAIS, hab.getHAB_EMPATIA_ANIMAIS());
        values.put(HabilidadesTable.HAB_OFICIOS, hab.getHAB_OFICIOS());
        values.put(HabilidadesTable.HAB_CONDUCAO, hab.getHAB_CONDUCAO());
        values.put(HabilidadesTable.HAB_ETIQUETA, hab.getHAB_ETIQUETA());
        values.put(HabilidadesTable.HAB_ARMAS_FOGO, hab.getHAB_ARMAS_FOGO());
        values.put(HabilidadesTable.HAB_ARMAS_BRANCA, hab.getHAB_ARMAS_BRANCA());
        values.put(HabilidadesTable.HAB_PERFORMANCE, hab.getHAB_PERFORMANCE());
        values.put(HabilidadesTable.HAB_SEGURANCA, hab.getHAB_SEGURANCA());
        values.put(HabilidadesTable.HAB_FURTIVIDADE, hab.getHAB_FURTIVIDADE());
        values.put(HabilidadesTable.HAB_SOBREVIVENCIA, hab.getHAB_SOBREVIVENCIA());
        values.put(HabilidadesTable.HAB_ACADEMICOS, hab.getHAB_ACADEMICOS());
        values.put(HabilidadesTable.HAB_COMPUTADOR, hab.getHAB_COMPUTADOR());
        values.put(HabilidadesTable.HAB_FINANCAS, hab.getHAB_FINANCAS());
        values.put(HabilidadesTable.HAB_INVESTIGACAO, hab.getHAB_INVESTIGACAO());
        values.put(HabilidadesTable.HAB_DIREITO, hab.getHAB_DIREITO());
        values.put(HabilidadesTable.HAB_LINGUISTICA, hab.getHAB_LINGUISTICA());
        values.put(HabilidadesTable.HAB_MEDICINA, hab.getHAB_MEDICINA());
        values.put(HabilidadesTable.HAB_OCULTISMO, hab.getHAB_OCULTISMO());
        values.put(HabilidadesTable.HAB_POLITICA, hab.getHAB_POLITICA());
        values.put(HabilidadesTable.HAB_CIENCIA, hab.getHAB_CIENCIA());
        values.put(HabilidadesTable.PER_CODIGO_PERFIL, hab.getPER_CODIGO_PERFIL());

        return values;
    }

    private Cursor getCursor() {
        try {
            return db.query(NOME_TABELA, AtributosTable.colunas, null, null, null, null, null, null);
        } catch (SQLException e) {
            Log.e(CATEGORIA, "Erro ao buscar as habilidades: " + e.toString());
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

package br.com.prymos.rpgprofile.dao;

import android.provider.BaseColumns;

/**
 * Created by daybson on 30/08/2016.
 */
public class HabilidadesTable implements BaseColumns {
    public static final String NAME = "Habilidades_HAB";
    public static final String HAB_CODIGO_HABILIDADE = "HAB_CODIGO_HABILIDADE";
    public static final String HAB_PRONTIDAO = "HAB_PRONTIDAO";
    public static final String HAB_ESPORTES = "HAB_ESPORTES";
    public static final String HAB_BRIGA = "HAB_BRIGA";
    public static final String HAB_ESQUIVA = "HAB_ESQUIVA";
    public static final String HAB_EMPATIA = "HAB_EMPATIA";
    public static final String HAB_EXPRESSAO = "HAB_EXPRESSAO";
    public static final String HAB_INTIMIDACAO = "HAB_INTIMIDACAO";
    public static final String HAB_LIDERANCA = "HAB_LIDERANCA";
    public static final String HAB_MANHA = "HAB_MANHA";
    public static final String HAB_LABIA = "HAB_LABIA";
    public static final String HAB_EMPATIA_ANIMAIS = "HAB_EMPATIA_ANIMAIS";
    public static final String HAB_OFICIOS = "HAB_OFICIOS";
    public static final String HAB_CONDUCAO = "HAB_CONDUCAO";
    public static final String HAB_ETIQUETA = "HAB_ETIQUETA";
    public static final String HAB_ARMAS_FOGO = "HAB_ARMAS_FOGO";
    public static final String HAB_ARMAS_BRANCA = "HAB_ARMAS_BRANCA";
    public static final String HAB_PERFORMANCE = "HAB_PERFORMANCE";
    public static final String HAB_SEGURANCA = "HAB_SEGURANCA";
    public static final String HAB_FURTIVIDADE = "HAB_FURTIVIDADE";
    public static final String HAB_SOBREVIVENCIA = "HAB_SOBREVIVENCIA";
    public static final String HAB_ACADEMICOS = "HAB_ACADEMICOS";
    public static final String HAB_COMPUTADOR = "HAB_COMPUTADOR";
    public static final String HAB_FINANCAS = "HAB_FINANCAS";
    public static final String HAB_INVESTIGACAO = "HAB_INVESTIGACAO";
    public static final String HAB_DIREITO = "HAB_DIREITO";
    public static final String HAB_LINGUISTICA = "HAB_LINGUISTICA";
    public static final String HAB_MEDICINA = "HAB_MEDICINA";
    public static final String HAB_OCULTISMO = "HAB_OCULTISMO";
    public static final String HAB_POLITICA = "HAB_POLITICA";
    public static final String HAB_CIENCIA = "HAB_CIENCIA";
    public static final String PER_CODIGO_PERFIL = "PER_CODIGO_PERFIL";

    public static String[] colunas = new String[] {
            HAB_CODIGO_HABILIDADE,
            HAB_PRONTIDAO,
            HAB_ESPORTES,
            HAB_BRIGA,
            HAB_ESQUIVA,
            HAB_EMPATIA,
            HAB_EXPRESSAO,
            HAB_INTIMIDACAO,
            HAB_LIDERANCA,
            HAB_MANHA,
            HAB_LABIA,
            HAB_EMPATIA_ANIMAIS,
            HAB_OFICIOS,
            HAB_CONDUCAO,
            HAB_ETIQUETA,
            HAB_ARMAS_FOGO,
            HAB_ARMAS_BRANCA,
            HAB_PERFORMANCE,
            HAB_SEGURANCA,
            HAB_FURTIVIDADE,
            HAB_SOBREVIVENCIA,
            HAB_ACADEMICOS,
            HAB_COMPUTADOR,
            HAB_FINANCAS,
            HAB_INVESTIGACAO,
            HAB_DIREITO,
            HAB_LINGUISTICA,
            HAB_MEDICINA,
            HAB_OCULTISMO,
            HAB_POLITICA,
            HAB_CIENCIA,
            PER_CODIGO_PERFIL
    };

    public static final String CREATE = "CREATE TABLE " + NAME +
            " (HAB_CODIGO_HABILIDADE INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            "HAB_PRONTIDAO INTEGER, HAB_ESPORTES INTEGER, HAB_BRIGA INTEGER, " +
            "HAB_ESQUIVA INTEGER, HAB_EMPATIA INTEGER, HAB_EXPRESSAO INTEGER, " +
            "HAB_INTIMIDACAO INTEGER, HAB_LIDERANCA INTEGER, HAB_MANHA INTEGER, " +
            "HAB_LABIA INTEGER, HAB_EMPATIA_ANIMAIS INTEGER, HAB_OFICIOS INTEGER, " +
            "HAB_CONDUCAO INTEGER, HAB_ETIQUETA INTEGER, HAB_ARMAS_FOGO INTEGER, " +
            "HAB_ARMAS_BRANCA INTEGER, HAB_PERFORMANCE INTEGER, HAB_SEGURANCA INTEGER, " +
            "HAB_FURTIVIDADE INTEGER, HAB_SOBREVIVENCIA INTEGER, HAB_ACADEMICOS INTEGER, " +
            "HAB_COMPUTADOR INTEGER, HAB_FINANCAS INTEGER, HAB_INVESTIGACAO INTEGER, " +
            "HAB_DIREITO INTEGER, HAB_LINGUISTICA INTEGER, HAB_MEDICINA INTEGER, " +
            "HAB_OCULTISMO INTEGER, HAB_POLITICA INTEGER, HAB_CIENCIA INTEGER, " +
            "PER_CODIGO_PERFIL INTEGER NOT NULL); ";

    public static final String DROP = "DROP TABLE IF EXISTS " + NAME;
}

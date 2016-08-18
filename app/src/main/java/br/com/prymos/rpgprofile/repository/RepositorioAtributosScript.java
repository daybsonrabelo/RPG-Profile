package br.com.prymos.rpgprofile.repository;

/**
 * Created by daybson on 18/08/2016.
 */
public class RepositorioAtributosScript extends  RepositorioAtributos {
    private static final String TABELA = "Atributos_ATR";
    private static final String SCRIPT_DATABASE_DELETE = "DROP TABLE IF EXISTS " + TABELA;
}

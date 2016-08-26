package br.com.prymos.rpgprofile.models;

import android.provider.BaseColumns;

/**
 * Created by daybson on 15/06/2016.
 */
public class Atributos_ATR {
    public static String[] colunas = new String[] {Atributos.ATR_CODIGO_ATRIBUTO,
            Atributos.ATR_FORCA, Atributos.ATR_DESTREZA, Atributos.ATR_VIGOR, Atributos.ATR_CARISMA,
            Atributos.ATR_MANIPULACAO, Atributos.ATR_APARENCIA, Atributos.ATR_PERCEPCAO,
            Atributos.ATR_INTELIGENCIA, Atributos.ATR_RACIOCINIO, Atributos.PER_CODIGO_PERFIL};

    private long PER_CODIGO_PERFIL;
    private long ATR_CODIGO_ATRIBUTO;
    private int ATR_FORCA;
    private int ATR_DESTREZA;
    private int ATR_VIGOR;
    private int ATR_CARISMA;
    private int ATR_MANIPULACAO;
    private int ATR_APARENCIA;
    private int ATR_PERCEPCAO;
    private int ATR_INTELIGENCIA;
    private int ATR_RACIOCINIO;

    public long getPER_CODIGO_PERFIL() {
        return PER_CODIGO_PERFIL;
    }

    public void setPER_CODIGO_PERFIL(long PER_CODIGO_PERFIL) {
        this.PER_CODIGO_PERFIL = PER_CODIGO_PERFIL;
    }

    public long getATR_CODIGO_ATRIBUTO() {
        return ATR_CODIGO_ATRIBUTO;
    }

    public void setATR_CODIGO_ATRIBUTO(long ATR_CODIGO_ATRIBUTO) {
        this.ATR_CODIGO_ATRIBUTO = ATR_CODIGO_ATRIBUTO;
    }

    public int getATR_FORCA() {
        return ATR_FORCA;
    }

    public void setATR_FORCA(int ATR_FORCA) {
        this.ATR_FORCA = ATR_FORCA;
    }

    public int getATR_DESTREZA() {
        return ATR_DESTREZA;
    }

    public void setATR_DESTREZA(int ATR_DESTREZA) {
        this.ATR_DESTREZA = ATR_DESTREZA;
    }

    public int getATR_VIGOR() {
        return ATR_VIGOR;
    }

    public void setATR_VIGOR(int ATR_VIGOR) {
        this.ATR_VIGOR = ATR_VIGOR;
    }

    public int getATR_CARISMA() {
        return ATR_CARISMA;
    }

    public void setATR_CARISMA(int ATR_CARISMA) {
        this.ATR_CARISMA = ATR_CARISMA;
    }

    public int getATR_MANIPULACAO() {
        return ATR_MANIPULACAO;
    }

    public void setATR_MANIPULACAO(int ATR_MANIPULACAO) {
        this.ATR_MANIPULACAO = ATR_MANIPULACAO;
    }

    public int getATR_APARENCIA() {
        return ATR_APARENCIA;
    }

    public void setATR_APARENCIA(int ATR_APARENCIA) {
        this.ATR_APARENCIA = ATR_APARENCIA;
    }

    public int getATR_PERCEPCAO() {
        return ATR_PERCEPCAO;
    }

    public void setATR_PERCEPCAO(int ATR_PERCEPCAO) {
        this.ATR_PERCEPCAO = ATR_PERCEPCAO;
    }

    public int getATR_INTELIGENCIA() {
        return ATR_INTELIGENCIA;
    }

    public void setATR_INTELIGENCIA(int ATR_INTELIGENCIA) {
        this.ATR_INTELIGENCIA = ATR_INTELIGENCIA;
    }

    public int getATR_RACIOCINIO() {
        return ATR_RACIOCINIO;
    }

    public void setATR_RACIOCINIO(int ATR_RACIOCINIO) {
        this.ATR_RACIOCINIO = ATR_RACIOCINIO;
    }

    public static final class Atributos implements BaseColumns {
        private Atributos() {
        }

        public static final String DEFAULT_SORT_ORDER = "ATR_CODIGO_ATRIBUTO ASC";
        public static final String ATR_CODIGO_ATRIBUTO = "ATR_CODIGO_ATRIBUTO";
        public static final String ATR_FORCA = "ATR_FORCA";
        public static final String ATR_DESTREZA = "ATR_DESTREZA";
        public static final String ATR_VIGOR = "ATR_VIGOR";
        public static final String ATR_CARISMA = "ATR_CARISMA";
        public static final String ATR_MANIPULACAO = "ATR_MANIPULACAO";
        public static final String ATR_APARENCIA = "ATR_APARENCIA";
        public static final String ATR_PERCEPCAO = "ATR_PERCEPCAO";
        public static final String ATR_INTELIGENCIA = "ATR_INTELIGENCIA";
        public static final String ATR_RACIOCINIO = "ATR_RACIOCINIO";
        public static final String PER_CODIGO_PERFIL = "PER_CODIGO_PERFIL";
    }

    @Override
    public String toString() {
        return "Atributos_ATR{" +
                "PER_CODIGO_PERFIL=" + PER_CODIGO_PERFIL +
                ", ATR_CODIGO_ATRIBUTO=" + ATR_CODIGO_ATRIBUTO +
                ", ATR_FORCA=" + ATR_FORCA +
                ", ATR_DESTREZA=" + ATR_DESTREZA +
                ", ATR_VIGOR=" + ATR_VIGOR +
                ", ATR_CARISMA=" + ATR_CARISMA +
                ", ATR_MANIPULACAO=" + ATR_MANIPULACAO +
                ", ATR_APARENCIA=" + ATR_APARENCIA +
                ", ATR_PERCEPCAO=" + ATR_PERCEPCAO +
                ", ATR_INTELIGENCIA=" + ATR_INTELIGENCIA +
                ", ATR_RACIOCINIO=" + ATR_RACIOCINIO +
                '}';
    }
}

package br.com.prymos.rpgprofile.models;

/**
 * Created by daybson on 02/09/2016.
 */
public class Configuracoes_CON {
    private long PER_CODIGO_PERFIL;
    private long CON_CODIGO_CONFIGURACAO;
    private int CON_PTS_ATR;
    private int CON_PTS_HAB;
    private int CON_PTS_VAN;
    private int CON_PTS_BNS;

    public long getPER_CODIGO_PERFIL() {
        return PER_CODIGO_PERFIL;
    }

    public void setPER_CODIGO_PERFIL(long PER_CODIGO_PERFIL) {
        this.PER_CODIGO_PERFIL = PER_CODIGO_PERFIL;
    }

    public long getCON_CODIGO_CONFIGURACAO() {
        return CON_CODIGO_CONFIGURACAO;
    }

    public void setCON_CODIGO_CONFIGURACAO(long CON_CODIGO_CONFIGURACAO) {
        this.CON_CODIGO_CONFIGURACAO = CON_CODIGO_CONFIGURACAO;
    }

    public int getCON_PTS_ATR() {
        return CON_PTS_ATR;
    }

    public void setCON_PTS_ATR(int CON_PTS_ATR) {
        this.CON_PTS_ATR = CON_PTS_ATR;
    }

    public int getCON_PTS_HAB() {
        return CON_PTS_HAB;
    }

    public void setCON_PTS_HAB(int CON_PTS_HAB) {
        this.CON_PTS_HAB = CON_PTS_HAB;
    }

    public int getCON_PTS_VAN() {
        return CON_PTS_VAN;
    }

    public void setCON_PTS_VAN(int CON_PTS_VAN) {
        this.CON_PTS_VAN = CON_PTS_VAN;
    }

    public int getCON_PTS_BNS() {
        return CON_PTS_BNS;
    }

    public void setCON_PTS_BNS(int CON_PTS_BNS) {
        this.CON_PTS_BNS = CON_PTS_BNS;
    }

    @Override
    public String toString() {
        return "Configuracoes_CON{" +
                "PER_CODIGO_PERFIL=" + PER_CODIGO_PERFIL +
                ", CON_CODIGO_CONFIGURACAO=" + CON_CODIGO_CONFIGURACAO +
                ", CON_PTS_ATR=" + CON_PTS_ATR +
                ", CON_PTS_HAB=" + CON_PTS_HAB +
                ", CON_PTS_VAN=" + CON_PTS_VAN +
                ", CON_PTS_BNS=" + CON_PTS_BNS +
                '}';
    }
}

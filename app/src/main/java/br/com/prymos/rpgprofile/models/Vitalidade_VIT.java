package br.com.prymos.rpgprofile.models;

/**
 * Created by daybson on 30/05/2016.
 */
public class Vitalidade_VIT {
    //public static String[] colunas = new String[] {  }

    private long VIT_CODIGO_VITALIDADE;
    private String VIT_DESCRICAO;
    private int VIT_REDUTOR;

    public long getVIT_CODIGO_VITALIDADE() {
        return VIT_CODIGO_VITALIDADE;
    }

    public void setVIT_CODIGO_VITALIDADE(long VIT_CODIGO_VITALIDADE) {
        this.VIT_CODIGO_VITALIDADE = VIT_CODIGO_VITALIDADE;
    }

    public String getVIT_DESCRICAO() {
        return VIT_DESCRICAO;
    }

    public void setVIT_DESCRICAO(String VIT_DESCRICAO) {
        this.VIT_DESCRICAO = VIT_DESCRICAO;
    }

    public int getVIT_REDUTOR() {
        return VIT_REDUTOR;
    }

    public void setVIT_REDUTOR(int VIT_REDUTOR) {
        this.VIT_REDUTOR = VIT_REDUTOR;
    }

    @Override
    public String toString() {
        return "Vitalidade_VIT{" +
                "VIT_CODIGO_VITALIDADE=" + VIT_CODIGO_VITALIDADE +
                ", VIT_DESCRICAO='" + VIT_DESCRICAO + '\'' +
                ", VIT_REDUTOR=" + VIT_REDUTOR +
                '}';
    }
}

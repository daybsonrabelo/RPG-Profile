package br.com.prymos.rpgprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.prymos.rpgprofile.models.Configuracoes_CON;
import br.com.prymos.rpgprofile.repository.RepositorioConfiguracoes;

public class ConfiguracoesActivity extends AppCompatActivity {

    private Configuracoes_CON con;
    private Button btnGravar;
    private EditText txtATR, txtHAB, txtVAN, txtBNS;
    private long codigo_perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        Bundle extras = getIntent().getExtras();
        codigo_perfil = extras.getLong("codigo_perfil");

        final RepositorioConfiguracoes repositorioConfiguracoes = new RepositorioConfiguracoes(this);
        con = repositorioConfiguracoes.buscarConfiguracoesPorPerfil(codigo_perfil);

        if (con != null) {
            txtATR = (EditText) findViewById(R.id.txtPtsAtr);
            txtHAB = (EditText) findViewById(R.id.txtPtsHab);
            txtVAN = (EditText) findViewById(R.id.txtPtsVan);
            txtBNS = (EditText) findViewById(R.id.txtPtsBns);

            txtATR.setText(String.valueOf(con.getCON_PTS_ATR()));
            txtHAB.setText(String.valueOf(con.getCON_PTS_HAB()));
            txtVAN.setText(String.valueOf(con.getCON_PTS_VAN()));
            txtBNS.setText(String.valueOf(con.getCON_PTS_BNS()));
        }

        btnGravar = (Button) findViewById(R.id.btnGravarConfiguracoes);
        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(con == null) {
                    con = new Configuracoes_CON();
                    con.setPER_CODIGO_PERFIL(codigo_perfil);
                }

                con.setCON_PTS_ATR(Integer.parseInt(txtATR.getText().toString()));
                con.setCON_PTS_HAB(Integer.parseInt(txtHAB.getText().toString()));
                con.setCON_PTS_VAN(Integer.parseInt(txtVAN.getText().toString()));
                con.setCON_PTS_BNS(Integer.parseInt(txtBNS.getText().toString()));

                RepositorioConfiguracoes repositorioConfiguracoes1 = new RepositorioConfiguracoes(getBaseContext());
                repositorioConfiguracoes.salvar(con);
            }
        });
    }
}

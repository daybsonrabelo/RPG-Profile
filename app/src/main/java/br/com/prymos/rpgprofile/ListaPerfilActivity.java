package br.com.prymos.rpgprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;

import br.com.prymos.rpgprofile.adapters.PerfilAdapter;
import br.com.prymos.rpgprofile.models.Perfil_PER;
import br.com.prymos.rpgprofile.repository.RepositorioPerfilScript;

public class ListaPerfilActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private ArrayList<Perfil_PER> listaPerfil;
    private PerfilAdapter perfilAdapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_perfil);

        mToolbar = (Toolbar) findViewById(R.id.tb_main);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    private void populaPerfis() {
        listaPerfil = new ArrayList<Perfil_PER>();
        Perfil_PER perfil = new Perfil_PER();
        perfil.setPER_NOME("Nome 1");
        perfil.setPER_JOGADOR("Jogador 1");
        perfil.setPER_PHOTO(R.drawable.icon_01);
        listaPerfil.add(perfil);

        perfil = new Perfil_PER();
        perfil.setPER_NOME("Nome 2");
        perfil.setPER_JOGADOR("Jogador 2");
        perfil.setPER_PHOTO(R.drawable.icon_02);
        listaPerfil.add(perfil);

        perfil = new Perfil_PER();
        perfil.setPER_NOME("Nome 3");
        perfil.setPER_JOGADOR("Jogador 3");
        perfil.setPER_PHOTO(R.drawable.icon_03);
        listaPerfil.add(perfil);

        perfil = new Perfil_PER();
        perfil.setPER_NOME("Nome 4");
        perfil.setPER_JOGADOR("Jogador 4");
        perfil.setPER_PHOTO(R.drawable.icon_04);
        listaPerfil.add(perfil);

        perfil = new Perfil_PER();
        perfil.setPER_NOME("Nome 5");
        perfil.setPER_JOGADOR("Jogador 5");
        perfil.setPER_PHOTO(R.drawable.icon_05);
        listaPerfil.add(perfil);

        perfil = new Perfil_PER();
        perfil.setPER_NOME("Nome 6");
        perfil.setPER_JOGADOR("Jogador 6");
        perfil.setPER_PHOTO(R.drawable.icon_06);
        listaPerfil.add(perfil);

        perfil = new Perfil_PER();
        perfil.setPER_NOME("Nome 7");
        perfil.setPER_JOGADOR("Jogador 7");
        perfil.setPER_PHOTO(R.drawable.icon_07);
        listaPerfil.add(perfil);

        perfil = new Perfil_PER();
        perfil.setPER_NOME("Nome 8");
        perfil.setPER_JOGADOR("Jogador 8");
        perfil.setPER_PHOTO(R.drawable.icon_08);
        listaPerfil.add(perfil);

        perfil = new Perfil_PER();
        perfil.setPER_NOME("Nome 9");
        perfil.setPER_JOGADOR("Jogador 9");
        perfil.setPER_PHOTO(R.drawable.icon_09);
        listaPerfil.add(perfil);

        perfil = new Perfil_PER();
        perfil.setPER_NOME("Nome 10");
        perfil.setPER_JOGADOR("Jogador 10");
        perfil.setPER_PHOTO(R.drawable.icon_10);
        listaPerfil.add(perfil);
    }

    private static final int ACT_CADASTRO = 1;
    private static final int RST_ATUALIZAR_SALVAR = 1;
    private static final int RST_ATUALIZAR_APAGAR = 2;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Intent it = new Intent(this, PerfilActivity.class);
                startActivity(it);
                break;
        }
    }

   @Override
    protected void onResume() {
        super.onResume();

        atualizarLista();
    }

    public void atualizarLista() {
        RepositorioPerfilScript repositorioPerfilScript = new RepositorioPerfilScript(this);
        listaPerfil = repositorioPerfilScript.listarPerfis();

        perfilAdapter = new PerfilAdapter(this, listaPerfil);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setAdapter(perfilAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
    }
}

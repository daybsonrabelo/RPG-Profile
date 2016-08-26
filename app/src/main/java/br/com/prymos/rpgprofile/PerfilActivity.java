package br.com.prymos.rpgprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.prymos.rpgprofile.adapters.SpinnerIconePerfilAdapter;
import br.com.prymos.rpgprofile.extras.ValidateUtil;
import br.com.prymos.rpgprofile.models.Icones;
import br.com.prymos.rpgprofile.models.Perfil_PER;
import br.com.prymos.rpgprofile.repository.RepositorioPerfil;
import me.drakeet.materialdialog.MaterialDialog;

public class PerfilActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    ArrayList<Icones> listaIcones;

    private EditText Nome;
    private EditText Jogador;
    private EditText Cronica;
    private EditText Natureza;
    private EditText Comportamento;
    private EditText Cla;
    private EditText Geracao;
    private EditText Refugio;
    private EditText Conceito;
    ImageView imageView;
    int selecionado;

    Spinner spinner;

    private long codigo;
    private boolean inicio;

    private MaterialDialog materialDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        inicio = false;

        FloatingActionMenu fab = (FloatingActionMenu) findViewById(R.id.fab);
        fab.showMenuButton(true);
        fab.setClosedOnTouchOutside(true);

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaIcones = new ArrayList<>();
        listaIcones.add(new Icones(R.drawable.icon_01));
        listaIcones.add(new Icones(R.drawable.icon_02));
        listaIcones.add(new Icones(R.drawable.icon_03));
        listaIcones.add(new Icones(R.drawable.icon_04));
        listaIcones.add(new Icones(R.drawable.icon_05));
        listaIcones.add(new Icones(R.drawable.icon_06));
        listaIcones.add(new Icones(R.drawable.icon_07));
        listaIcones.add(new Icones(R.drawable.icon_08));
        listaIcones.add(new Icones(R.drawable.icon_09));
        listaIcones.add(new Icones(R.drawable.icon_10));

        spinner = (Spinner) findViewById(R.id.spImage);
        SpinnerIconePerfilAdapter spinnerIconePerfilAdapter = new SpinnerIconePerfilAdapter(this, R.layout.spinner_icone_perfil, listaIcones);
        spinner.setAdapter(spinnerIconePerfilAdapter);
        spinner.setOnItemSelectedListener(this);

        ValidateUtil vu = new ValidateUtil();

        Nome = (EditText) findViewById(R.id.edNome);
        Jogador = (EditText) findViewById(R.id.edJogador);
        Cronica = (EditText) findViewById(R.id.edCronica);
        Natureza = (EditText) findViewById(R.id.edNatureza);
        Comportamento = (EditText) findViewById(R.id.edComportamento);
        Cla = (EditText) findViewById(R.id.edCla);
        Geracao = (EditText) findViewById(R.id.edGeracao);
        Refugio = (EditText) findViewById(R.id.edRefugio);
        Conceito = (EditText) findViewById(R.id.edConceito);

        Nome.addTextChangedListener(vu);
        Jogador.addTextChangedListener(vu);
        Cronica.addTextChangedListener(vu);
        Natureza.addTextChangedListener(vu);
        Comportamento.addTextChangedListener(vu);
        Cla.addTextChangedListener(vu);

        imageView = (ImageView) findViewById(R.id.imageView);

        Intent it = getIntent();
        if (it != null) {
            inicio = true;
            Bundle params = it.getExtras();
            if (params != null) {
                codigo = params.getLong("codigo_perfil");
                String msg = "Codigo: " + codigo;
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                preencheCampos();
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //spinner.setIn
        if (!inicio) {
            imageView.setImageResource(listaIcones.get(position).getImageId());
            selecionado = position;
        }
        inicio = false;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        String aux = "";

        switch( v.getId() ){
            case R.id.fab1:
                salvarPerfil();
                //TODO: Deve encaminhar para ficha
                break;
            case R.id.fab2:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Apagar Perfil");
                builder.setMessage("Deseja cancelar o perfil?");
                builder.setCancelable(true);
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        apagarPerfil();
                    }
                });

                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Não faz nada.
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }
    }

    private void salvarPerfil() {
        Perfil_PER perfil;
        RepositorioPerfil repositorioPerfil = new RepositorioPerfil(this);

        //TODO: Ajustar pois quando atualiza não está pegando os dados do formulário(não atualiza nada).
        if (codigo == 0) {
            perfil = new Perfil_PER();

            perfil.setPER_NOME(((EditText) findViewById(R.id.edNome)).getText().toString());
            perfil.setPER_JOGADOR(((EditText) findViewById(R.id.edJogador)).getText().toString());
            perfil.setPER_CRONICA(((EditText) findViewById(R.id.edCronica)).getText().toString());
            perfil.setPER_NATUREZA(((EditText) findViewById(R.id.edNatureza)).getText().toString());
            perfil.setPER_COMPORTAMENTO(((EditText) findViewById(R.id.edComportamento)).getText().toString());
            perfil.setPER_CLA(((EditText) findViewById(R.id.edCla)).getText().toString());
            perfil.setPER_GERACAO(((EditText) findViewById(R.id.edGeracao)).getText().toString());
            perfil.setPER_REFUGIO(((EditText) findViewById(R.id.edRefugio)).getText().toString());
            perfil.setPER_CONCEITO(((EditText) findViewById(R.id.edConceito)).getText().toString());
            perfil.setPER_DATA_CADASTRO(Calendar.getInstance().getTime());

            perfil.setPER_PHOTO(listaIcones.get(selecionado).getImageId());
        } else {
            perfil = repositorioPerfil.buscarPerfil(codigo);
        }

        if (validateFields(perfil)) {
            repositorioPerfil.salvar(perfil);
            Intent it = new Intent(this, FichaActivity.class);
            long maxCodigoPerfil = repositorioPerfil.buscarUltimoCodigoPerfil();

            it.putExtra("codigo_perfil", maxCodigoPerfil);
            startActivity(it);
            finish();
        }
    }

    private void apagarPerfil() {
        RepositorioPerfil repositorioPerfilScript = new RepositorioPerfil(this);
        repositorioPerfilScript.deletar(codigo);
        //TODO: Verificar como voltar para a tela de listagem usando o setResult e atualizar os dados.
        finish();
    }

    private boolean validateFields(Perfil_PER perfil) {
        if (TextUtils.isEmpty(perfil.getPER_NOME())) {
            Nome.requestFocus();
            Nome.setError("Nome é obrigatório!");
            //Nome.setError(resources.getString(R.string.login_user_required)); - Precisa criar no arquivo de Strings
            return false;
        } else if (!(perfil.getPER_NOME().length() > 3)) {
            Nome.requestFocus();
            Nome.setError("Nome deve ter mais que 3 letras!");
            //Nome.setError(resources.getString(R.string.login_user_required)); - Precisa criar no arquivo de Strings
            return false;
        } else if (TextUtils.isEmpty(perfil.getPER_JOGADOR())) {
            Jogador.requestFocus();
            Jogador.setError("Jogador é obrigatório!");
            //Jogador.setError(resources.getString(R.string.login_user_required)); - Precisa criar no arquivo de Strings
            return false;
        } else if (!(perfil.getPER_JOGADOR().length() > 3)) {
            Jogador.requestFocus();
            Jogador.setError("Jogador deve ter mais que 3 letras!");
            //Jogador.setError(resources.getString(R.string.login_user_required)); - Precisa criar no arquivo de Strings
            return false;
        } else if (TextUtils.isEmpty(perfil.getPER_CRONICA())) {
            Cronica.requestFocus();
            Cronica.setError("Crônica é obrigatório!");
            //Jogador.setError(resources.getString(R.string.login_user_required)); - Precisa criar no arquivo de Strings
            return false;
        } else if (!(perfil.getPER_CRONICA().length() > 3)) {
            Cronica.requestFocus();
            Cronica.setError("Crônica deve ter mais que 3 letras!");
            //Jogador.setError(resources.getString(R.string.login_user_required)); - Precisa criar no arquivo de Strings
            return false;
        } else if (TextUtils.isEmpty(perfil.getPER_NATUREZA())) {
            Natureza.requestFocus();
            Natureza.setError("Natureza é obrigatório!");
            //Jogador.setError(resources.getString(R.string.login_user_required)); - Precisa criar no arquivo de Strings
            return false;
        } else if (!(perfil.getPER_NATUREZA().length() > 3)) {
            Natureza.requestFocus();
            Natureza.setError("Natureza deve ter mais que 3 letras!");
            //Jogador.setError(resources.getString(R.string.login_user_required)); - Precisa criar no arquivo de Strings
            return false;
        } else if (TextUtils.isEmpty(perfil.getPER_COMPORTAMENTO())) {
            Comportamento.requestFocus();
            Comportamento.setError("Comportamento é obrigatório!");
            //Jogador.setError(resources.getString(R.string.login_user_required)); - Precisa criar no arquivo de Strings
            return false;
        } else if (!(perfil.getPER_COMPORTAMENTO().length() > 3)) {
            Comportamento.requestFocus();
            Comportamento.setError("Comportamento deve ter mais que 3 letras!");
            //Jogador.setError(resources.getString(R.string.login_user_required)); - Precisa criar no arquivo de Strings
            return false;
        } else if (TextUtils.isEmpty(perfil.getPER_CLA())) {
            Cla.requestFocus();
            Cla.setError("Clã é obrigatório!");
            //Jogador.setError(resources.getString(R.string.login_user_required)); - Precisa criar no arquivo de Strings
            return false;
        } else if (!(perfil.getPER_CLA().length() > 3)) {
            Cla.requestFocus();
            Cla.setError("Clã deve ter mais que 3 letras!");
            //Jogador.setError(resources.getString(R.string.login_user_required)); - Precisa criar no arquivo de Strings
            return false;
        } else if (TextUtils.isEmpty(perfil.getPER_GERACAO())) {
            Geracao.requestFocus();
            Geracao.setError("Geração é obrigatório!");
            //Jogador.setError(resources.getString(R.string.login_user_required)); - Precisa criar no arquivo de Strings
            return false;
        } else if (!(perfil.getPER_GERACAO().length() > 3)) {
            Geracao.requestFocus();
            Geracao.setError("Geração deve ter mais que 3 letras!");
            //Jogador.setError(resources.getString(R.string.login_user_required)); - Precisa criar no arquivo de Strings
            return false;
        }

        return true;
    }

    private void preencheCampos() {
        RepositorioPerfil repositorioPerfil = new RepositorioPerfil(this);
        Perfil_PER perfil = repositorioPerfil.buscarPerfil(codigo);

        if (perfil != null) {
            //Nome
            Nome.setText(perfil.getPER_NOME());
            //Jogador
            Jogador.setText(perfil.getPER_JOGADOR());
            //Cronica
            Cronica.setText(perfil.getPER_CRONICA());
            //Natureza
            Natureza.setText(perfil.getPER_NATUREZA());
            //Comportamento
            Comportamento.setText(perfil.getPER_COMPORTAMENTO());
            //Cla
            Cla.setText(perfil.getPER_CLA());
            //Geracao
            Geracao.setText(perfil.getPER_GERACAO());
            //Refugio
            Refugio.setText(perfil.getPER_REFUGIO());
            //Conceito
            Conceito.setText(perfil.getPER_CONCEITO());
            //Photo -  imageView.setImageResource(listaIcones.get(position).getImageId());
            imageView.setImageResource(perfil.getPER_PHOTO());
        }

    }

}

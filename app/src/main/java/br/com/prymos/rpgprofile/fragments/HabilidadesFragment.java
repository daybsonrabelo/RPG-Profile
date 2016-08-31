package br.com.prymos.rpgprofile.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import br.com.prymos.rpgprofile.R;
import br.com.prymos.rpgprofile.models.Habilidades_HAB;
import br.com.prymos.rpgprofile.repository.RepositorioHabilidades;

/**
 * Created by daybson on 14/06/2016.
 */
public class HabilidadesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_CODIGO_PERFIL = "codigoperfil";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private long mCodigoPerfil;
    private RepositorioHabilidades repositorioHabilidades;

    public HabilidadesFragment() {

    }

    public static HabilidadesFragment newInstance(String param1, String param2, long codPerfil) {
        HabilidadesFragment fragment = new HabilidadesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putLong(ARG_CODIGO_PERFIL, codPerfil);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mCodigoPerfil = getArguments().getLong(ARG_CODIGO_PERFIL);
            repositorioHabilidades = new RepositorioHabilidades(getContext());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_habilidades, container, false);

        carregarHabilidades(view);

        Button btnSalvarAtributos = (Button) view.findViewById(R.id.btnSalvarHabilidades);
        btnSalvarAtributos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                salvarHabilidades(getView());
                Toast.makeText(getContext(), "Dados salvos.", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void carregarHabilidades(View view) {
        Habilidades_HAB hab = repositorioHabilidades.buscarHabilidadesPorPerfil(mCodigoPerfil);

        if (hab != null) {
            setIdxRadioGroup(view, R.id.rgProntidao, hab.getHAB_PRONTIDAO());
            setIdxRadioGroup(view, R.id.rgEsportes, hab.getHAB_ESPORTES());
            setIdxRadioGroup(view, R.id.rgBriga, hab.getHAB_BRIGA());
            setIdxRadioGroup(view, R.id.rgEsquiva, hab.getHAB_ESQUIVA());
            setIdxRadioGroup(view, R.id.rgEmpatia, hab.getHAB_EMPATIA());
            setIdxRadioGroup(view, R.id.rgExpressao, hab.getHAB_EXPRESSAO());
            setIdxRadioGroup(view, R.id.rgIntimidacao, hab.getHAB_INTIMIDACAO());
            setIdxRadioGroup(view, R.id.rgLideranca, hab.getHAB_LIDERANCA());
            setIdxRadioGroup(view, R.id.rgManha, hab.getHAB_MANHA());
            setIdxRadioGroup(view, R.id.rgLabia, hab.getHAB_LABIA());
            setIdxRadioGroup(view, R.id.rgEmpatiaAnimal, hab.getHAB_EMPATIA_ANIMAIS());
            setIdxRadioGroup(view, R.id.rgOficios, hab.getHAB_OFICIOS());
            setIdxRadioGroup(view, R.id.rgConducao, hab.getHAB_CONDUCAO());
            setIdxRadioGroup(view, R.id.rgEtiqueta, hab.getHAB_ETIQUETA());
            setIdxRadioGroup(view, R.id.rgArmasFogo, hab.getHAB_ARMAS_FOGO());
            setIdxRadioGroup(view, R.id.rgArmasBrancas, hab.getHAB_ARMAS_BRANCA());
            setIdxRadioGroup(view, R.id.rgPerformance, hab.getHAB_PERFORMANCE());
            setIdxRadioGroup(view, R.id.rgSeguranca, hab.getHAB_SEGURANCA());
            setIdxRadioGroup(view, R.id.rgFurtividade, hab.getHAB_FURTIVIDADE());
            setIdxRadioGroup(view, R.id.rgSobrevivencia, hab.getHAB_SOBREVIVENCIA());
            setIdxRadioGroup(view, R.id.rgAcademicos, hab.getHAB_ACADEMICOS());
            setIdxRadioGroup(view, R.id.rgComputador, hab.getHAB_COMPUTADOR());
            setIdxRadioGroup(view, R.id.rgFinancas, hab.getHAB_FINANCAS());
            setIdxRadioGroup(view, R.id.rgInvestigacao, hab.getHAB_INVESTIGACAO());
            setIdxRadioGroup(view, R.id.rgDireito, hab.getHAB_DIREITO());
            setIdxRadioGroup(view, R.id.rgLinguistica, hab.getHAB_LINGUISTICA());
            setIdxRadioGroup(view, R.id.rgMedicina, hab.getHAB_MEDICINA());
            setIdxRadioGroup(view, R.id.rgOcultismo, hab.getHAB_OCULTISMO());
            setIdxRadioGroup(view, R.id.rgPolitica, hab.getHAB_POLITICA());
            setIdxRadioGroup(view, R.id.rgCiencia, hab.getHAB_CIENCIA());
        }
    }

    private void salvarHabilidades(View view) {
        Habilidades_HAB hab = repositorioHabilidades.buscarHabilidadesPorPerfil(mCodigoPerfil);

        if (hab == null) {
            hab = new Habilidades_HAB();
        }

        hab.setHAB_PRONTIDAO(getIdxRadioGroup(view, R.id.rgProntidao));
        hab.setHAB_ESPORTES(getIdxRadioGroup(view, R.id.rgEsportes));
        hab.setHAB_BRIGA(getIdxRadioGroup(view, R.id.rgBriga));
        hab.setHAB_ESQUIVA(getIdxRadioGroup(view, R.id.rgEsquiva));
        hab.setHAB_EMPATIA(getIdxRadioGroup(view, R.id.rgEmpatia));
        hab.setHAB_EXPRESSAO(getIdxRadioGroup(view, R.id.rgExpressao));
        hab.setHAB_INTIMIDACAO(getIdxRadioGroup(view, R.id.rgIntimidacao));
        hab.setHAB_LIDERANCA(getIdxRadioGroup(view, R.id.rgLideranca));
        hab.setHAB_MANHA(getIdxRadioGroup(view, R.id.rgManha));
        hab.setHAB_LABIA(getIdxRadioGroup(view, R.id.rgLabia));
        hab.setHAB_EMPATIA_ANIMAIS(getIdxRadioGroup(view, R.id.rgEmpatiaAnimal));
        hab.setHAB_OFICIOS(getIdxRadioGroup(view, R.id.rgOficios));
        hab.setHAB_CONDUCAO(getIdxRadioGroup(view, R.id.rgConducao));
        hab.setHAB_ETIQUETA(getIdxRadioGroup(view, R.id.rgEtiqueta));
        hab.setHAB_ARMAS_FOGO(getIdxRadioGroup(view, R.id.rgArmasFogo));
        hab.setHAB_ARMAS_BRANCA(getIdxRadioGroup(view, R.id.rgArmasBrancas));
        hab.setHAB_PERFORMANCE(getIdxRadioGroup(view, R.id.rgPerformance));
        hab.setHAB_SEGURANCA(getIdxRadioGroup(view, R.id.rgSeguranca));
        hab.setHAB_FURTIVIDADE(getIdxRadioGroup(view, R.id.rgFurtividade));
        hab.setHAB_SOBREVIVENCIA(getIdxRadioGroup(view, R.id.rgSobrevivencia));
        hab.setHAB_ACADEMICOS(getIdxRadioGroup(view, R.id.rgAcademicos));
        hab.setHAB_COMPUTADOR(getIdxRadioGroup(view, R.id.rgComputador));
        hab.setHAB_FINANCAS(getIdxRadioGroup(view, R.id.rgFinancas));
        hab.setHAB_INVESTIGACAO(getIdxRadioGroup(view, R.id.rgInvestigacao));
        hab.setHAB_DIREITO(getIdxRadioGroup(view, R.id.rgDireito));
        hab.setHAB_LINGUISTICA(getIdxRadioGroup(view, R.id.rgLinguistica));
        hab.setHAB_MEDICINA(getIdxRadioGroup(view, R.id.rgMedicina));
        hab.setHAB_OCULTISMO(getIdxRadioGroup(view, R.id.rgOcultismo));
        hab.setHAB_POLITICA(getIdxRadioGroup(view, R.id.rgPolitica));
        hab.setHAB_CIENCIA(getIdxRadioGroup(view, R.id.rgCiencia));
        hab.setPER_CODIGO_PERFIL(mCodigoPerfil);

        repositorioHabilidades.salvar(hab);
    }

    private int getIdxRadioGroup(View view, int idRadioGroup) {
        RadioGroup radioGroup = (RadioGroup) view.findViewById(idRadioGroup);

        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonID);
        int idx = radioGroup.indexOfChild(radioButton);

        return idx + 1;
    }

    private void setIdxRadioGroup(View view, int idRadioGroup, int idx) {
        idx = idx - 1;
        if (idx >= 0) {
            RadioGroup radioGroup = (RadioGroup) view.findViewById(idRadioGroup);
            radioGroup.check(radioGroup.getChildAt(idx).getId());
        }
    }
}

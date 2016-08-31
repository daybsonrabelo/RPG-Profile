package br.com.prymos.rpgprofile.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import br.com.prymos.rpgprofile.R;
import br.com.prymos.rpgprofile.models.Atributos_ATR;
import br.com.prymos.rpgprofile.repository.RepositorioAtributos;

public class AtributosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_CODIGO_PERFIL = "codigoperfil";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private long mcodigoperfil;
    private RepositorioAtributos repositorioAtributos;

    public AtributosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AtributosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AtributosFragment newInstance(String param1, String param2, long codperfil) {
        AtributosFragment fragment = new AtributosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putLong(ARG_CODIGO_PERFIL, codperfil);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mcodigoperfil = getArguments().getLong(ARG_CODIGO_PERFIL);
            repositorioAtributos = new RepositorioAtributos(getContext());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_atributos, container, false);

        carregarAtributos(view);

        Button btnSalvarAtributos = (Button) view.findViewById(R.id.btnSalvarAtributos);
        btnSalvarAtributos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                salvarAtributos(getView());
                Toast.makeText(getContext(), "Dados salvos.", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void carregarAtributos(View view) {
        Atributos_ATR atr = repositorioAtributos.buscarAtributoPorPerfil(mcodigoperfil);
        if (atr != null) {
            setIdxRadioGroup(view, R.id.rgForca, atr.getATR_FORCA());
            setIdxRadioGroup(view, R.id.rgDestreza, atr.getATR_DESTREZA());
            setIdxRadioGroup(view, R.id.rgVigor, atr.getATR_VIGOR());
            setIdxRadioGroup(view, R.id.rgCarisma, atr.getATR_CARISMA());
            setIdxRadioGroup(view, R.id.rgManipulacao, atr.getATR_MANIPULACAO());
            setIdxRadioGroup(view, R.id.rgAparencia, atr.getATR_APARENCIA());
            setIdxRadioGroup(view, R.id.rgPercepcao, atr.getATR_PERCEPCAO());
            setIdxRadioGroup(view, R.id.rgInteligencia, atr.getATR_INTELIGENCIA());
            setIdxRadioGroup(view, R.id.rgRaciocinio, atr.getATR_RACIOCINIO());
        }
    }

    private void salvarAtributos(View view) {
        Atributos_ATR atr = repositorioAtributos.buscarAtributoPorPerfil(mcodigoperfil);

        if (atr == null) {
            atr = new Atributos_ATR();
        }

        atr.setATR_FORCA(getIdxRadioGroup(view, R.id.rgForca));
        atr.setATR_DESTREZA(getIdxRadioGroup(view, R.id.rgDestreza));
        atr.setATR_VIGOR(getIdxRadioGroup(view, R.id.rgVigor));
        atr.setATR_CARISMA(getIdxRadioGroup(view, R.id.rgCarisma));
        atr.setATR_MANIPULACAO(getIdxRadioGroup(view, R.id.rgManipulacao));
        atr.setATR_APARENCIA(getIdxRadioGroup(view, R.id.rgAparencia));
        atr.setATR_PERCEPCAO(getIdxRadioGroup(view, R.id.rgPercepcao));
        atr.setATR_INTELIGENCIA(getIdxRadioGroup(view, R.id.rgInteligencia));
        atr.setATR_RACIOCINIO(getIdxRadioGroup(view, R.id.rgRaciocinio));
        atr.setPER_CODIGO_PERFIL(mcodigoperfil);

        repositorioAtributos.salvar(atr);
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

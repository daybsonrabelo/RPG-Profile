package br.com.prymos.rpgprofile.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.prymos.rpgprofile.R;
import br.com.prymos.rpgprofile.models.Atributos_ATR;

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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_atributos, container, false);

        Button btnSalvarAtributos = (Button) view.findViewById(R.id.btnSalvarAtributos);
        btnSalvarAtributos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                salvarAtributos();
            }
        });

        return view;
    }

    private void salvarAtributos() {
        Atributos_ATR atr = new Atributos_ATR();
    }

}

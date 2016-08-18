package br.com.prymos.rpgprofile.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.prymos.rpgprofile.FichaActivity;
import br.com.prymos.rpgprofile.PerfilActivity;
import br.com.prymos.rpgprofile.R;
import br.com.prymos.rpgprofile.models.Perfil_PER;

/**
 * Created by daybson on 31/05/2016.
 */
public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.PerfilViewHolder> {

    private Context context;
    private ArrayList<Perfil_PER> items;

    public PerfilAdapter(Context context, ArrayList<Perfil_PER> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_perfil, parent, false);
        PerfilViewHolder viewHolder = new PerfilViewHolder(context, view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PerfilViewHolder viewHolder, int position) {
        Perfil_PER perfil = items.get(position);
        viewHolder.iv_perfil.setImageResource(perfil.getPER_PHOTO());
        viewHolder.tv1.setText(perfil.getPER_NOME());
        viewHolder.tv2.setText(perfil.getPER_JOGADOR());
        viewHolder.codigo_perfil = perfil.getPER_CODIGO_PERFIL();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class PerfilViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Context context;
        public ImageView iv_perfil;
        public TextView tv1;
        public TextView tv2;
        public Button btnPerfil;
        public long codigo_perfil;

        public PerfilViewHolder(final Context context, View itemView) {
            super(itemView);
            this.context = context;

            itemView.setOnClickListener(this);

            iv_perfil = (ImageView) itemView.findViewById(R.id.iv_perfil);
            tv1 = (TextView) itemView.findViewById(R.id.tv_1);
            tv2 = (TextView) itemView.findViewById(R.id.tv_2);
            btnPerfil = (Button) itemView.findViewById(R.id.btn_acessar_perfil);
            btnPerfil.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent it = new Intent(v.getContext(), PerfilActivity.class);
                    it.putExtra("codigo_perfil", codigo_perfil);

                    context.startActivity(it);
                }
            });
        }

        @Override
        public void onClick(View v) {
            Intent it = new Intent(v.getContext(), FichaActivity.class);
            it.putExtra("codigo_perfil", codigo_perfil);

            context.startActivity(it);
        }
    }
}
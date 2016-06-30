package br.com.prymos.rpgprofile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

import br.com.prymos.rpgprofile.R;
import br.com.prymos.rpgprofile.models.Icones;


/**
 * Created by daybson on 01/06/2016.
 */
public class SpinnerIconePerfilAdapter extends ArrayAdapter<Icones> {

    private List<Icones> objects;
    private Context context;

    public SpinnerIconePerfilAdapter(Context context, int resourceId, List<Icones> objects) {
        super(context, resourceId, objects);
        this.objects = objects;
        this.context = context;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_icone_perfil, parent, false);

        ImageView imageView = (ImageView) row.findViewById(R.id.iv_icone);
        imageView.setImageResource(objects.get(position).getImageId());

        return row;
    }
}

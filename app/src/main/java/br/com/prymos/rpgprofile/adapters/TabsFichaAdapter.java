package br.com.prymos.rpgprofile.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.prymos.rpgprofile.fragments.AtributosFragment;
import br.com.prymos.rpgprofile.fragments.HabilidadesFragment;
import br.com.prymos.rpgprofile.fragments.VantagensFragment;

/**
 * Created by daybson on 14/06/2016.
 */
public class TabsFichaAdapter extends FragmentPagerAdapter {

    private long codigoperfil;

    public TabsFichaAdapter(FragmentManager fm, long codigoperfil) {
        super(fm);

        this.codigoperfil = codigoperfil;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //return PlaceholderFragment.newInstance(position + 1);
        switch (position) {
            case 0:
                return AtributosFragment.newInstance("nada", "nada", codigoperfil);
            case 1:
                return HabilidadesFragment.newInstance("nada", "nada", codigoperfil);
            case 2:
                return VantagensFragment.newInstance("nada", "nada");
            case 3:
                return AtributosFragment.newInstance("nada", "nada", codigoperfil);
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "ATRIBUTOS";
            case 1:
                return "HABILIDADES";
            case 2:
                return "VANTAGENS";
            case 3:
                return "EXTRAS";
        }
        return null;
    }
}

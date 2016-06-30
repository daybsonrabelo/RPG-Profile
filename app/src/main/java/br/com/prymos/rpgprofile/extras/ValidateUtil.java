package br.com.prymos.rpgprofile.extras;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by daybson on 02/06/2016.
 */
public class ValidateUtil implements TextWatcher {

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        callClearErrors(s);
    }

    private void callClearErrors(Editable s) {
        if (!s.toString().isEmpty()) {
            clearErrorFields();
        }
    }

    private void clearErrorFields(EditText... eds) {
        for (EditText ed : eds) {
            ed.setError(null);
        }
    }
}

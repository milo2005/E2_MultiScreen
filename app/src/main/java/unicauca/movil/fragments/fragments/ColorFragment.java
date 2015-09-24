package unicauca.movil.fragments.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import unicauca.movil.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    String[] colorNames;
    int[] colorHex;
    int pos;

    TextView txt;

    public ColorFragment() {}

    public void init(int pos){
        this.pos = pos;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        colorHex = context.getResources().getIntArray(R.array.color_hex);
        colorNames = context.getResources().getStringArray(R.array.colores);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_color, container, false);
        txt = (TextView) v.findViewById(R.id.txt);
        setColor(pos);
        return v;
    }

    public void setColor(int color) {
        txt.setText(colorNames[color]);
        txt.setBackgroundColor(colorHex[color]);
    }


}

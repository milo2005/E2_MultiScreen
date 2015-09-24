package unicauca.movil.fragments.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import unicauca.movil.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment implements AdapterView.OnItemClickListener {


    public interface OnColorSelected{
        void onColorSelected(int pos);
    }

    OnColorSelected onColorSelected;

    public MasterFragment() {}


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onColorSelected = (OnColorSelected) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f_master, container, false);

        ListView list = (ListView) v.findViewById(R.id.list);
        list.setOnItemClickListener(this);

        return v;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        onColorSelected.onColorSelected(i);
    }
}

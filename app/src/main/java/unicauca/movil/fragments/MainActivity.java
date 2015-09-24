package unicauca.movil.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import unicauca.movil.fragments.fragments.ColorFragment;
import unicauca.movil.fragments.fragments.MasterFragment;

public class MainActivity extends AppCompatActivity implements MasterFragment.OnColorSelected{

    public static final String STATE_POS="pos";

    MasterFragment master;
    ColorFragment color;

    boolean port, phone;

    int pos=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        port = getResources().getBoolean(R.bool.port);
        phone = getResources().getBoolean(R.bool.phone);

        master = new MasterFragment();
        color =  new ColorFragment();

        if(savedInstanceState != null)
            pos = savedInstanceState.getInt(STATE_POS);

        if(!port && !phone){
            if(pos>-1)
                color.init(pos);
            else
                color.init(0);
            putFragment(R.id.container1, master);
            putFragment(R.id.container2, color);
        }else {

            if (pos > -1) {
                color.init(pos);
                putFragment(R.id.container1, color);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }else{
                putFragment(R.id.container1, master);
            }
        }




    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_POS, pos);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onColorSelected(int pos) {
        this.pos = pos;
        if(!phone && !port){
            color.setColor(pos);
        }else{
            color.init(pos);
            putFragment(R.id.container1, color);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            putFragment(R.id.container1, master);
            pos=-1;
        }

        return super.onOptionsItemSelected(item);
    }

    public void putFragment(int idContainer, Fragment fragment){
        FragmentTransaction fT = getSupportFragmentManager()
                .beginTransaction();
        fT.replace(idContainer, fragment);
        fT.commit();
    }
}

package com.mayank.twopanetry;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    // if run on phone, isSinglePane = true
    // if run on tablet, isSinglePane = false
    static boolean isSinglePane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View v = findViewById(R.id.phone_container);
        if(v == null){
            //it's run on tablet
            isSinglePane = false;
   /*
    * MyListFragment and MyDetailFragment have been loaded in XML,
    * no need load.
    */

        }else{
            //it's run on phone
            //Load MyListFragment programmatically
            isSinglePane = true;

            if(savedInstanceState == null){
                //if's the first time created
                MyListFragment myListFragment = new MyListFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.phone_container, myListFragment);
                fragmentTransaction.commit();
            }
        }
    }

}
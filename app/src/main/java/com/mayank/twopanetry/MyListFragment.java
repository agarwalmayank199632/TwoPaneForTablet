package com.mayank.twopanetry;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MyListFragment extends ListFragment {

    static String[] month ={
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"};

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListAdapter myArrayAdapter =
                new ArrayAdapter<>(
                        getActivity(), android.R.layout.simple_list_item_1, month);
        setListAdapter(myArrayAdapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        String clickedDetail = (String)l.getItemAtPosition(position);

        if(MainActivity.isSinglePane){
    /*
     * The second fragment not yet loaded.
     * Load MyDetailFragment by FragmentTransaction, and pass
     * data from current fragment to second fragment via bundle.
     */
            MyDetailFragment myDetailFragment = new MyDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("KEY_DETAIL", clickedDetail);
            myDetailFragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction =
                    getActivity().getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.phone_container, myDetailFragment);
            fragmentTransaction.commit();

        }else{
    /*
     * Activity have two fragments. Pass data between fragments
     * via reference to fragment
     */

            //get reference to MyDetailFragment
            MyDetailFragment myDetailFragment = (MyDetailFragment)getFragmentManager().findFragmentById(R.id.detail_fragment);
            myDetailFragment.updateDetail(clickedDetail);

        }
    }

}
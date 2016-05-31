package com.mayank.twopanetry;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyDetailFragment extends Fragment {

    TextView textDetail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.layout_detailfragment, null);
        textDetail = (TextView)view.findViewById(R.id.text_detail);

        Bundle bundle = getArguments();
        if(bundle != null){
            String detail = bundle.getString("KEY_DETAIL", "no argument pass");
            textDetail.setText(detail);
        }

        return view;
    }

    public void updateDetail(String detail) {
        textDetail.setText(detail);
    }

}
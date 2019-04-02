package com.example.canis;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainScreen extends Fragment{

    public MainScreen(){

    }

    private Context mContext;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mContext = context;
    }

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main_screen, container, false);
        this.view = view;

        return view;
    }




    }
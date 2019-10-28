package com.quyunshuo.other_module.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quyunshuo.other_module.R;

public class OtherFragment extends Fragment {

    public OtherFragment() {
        // Required empty public constructor
    }

    public static OtherFragment newInstance() {
        OtherFragment fragment = new OtherFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other, container, false);
    }
}
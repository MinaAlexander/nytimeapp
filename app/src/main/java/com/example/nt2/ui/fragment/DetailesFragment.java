package com.example.nt2.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.nt2.R;
import com.example.nt2.databinding.FragmentDetailesBinding;


public class DetailesFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "Fragment_Detailes";
    private FragmentDetailesBinding binding;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailesFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static DetailesFragment newInstance(String param1, String param2) {
        DetailesFragment fragment = new DetailesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detailes, container, false);
        View rootView = binding.getRoot();
        return rootView;

//        rootView = inflater.inflate(R.layout.fragment_all_articals, container, false);
//        View view = inflater.inflate(R.layout.fragment_detailes, container, false);

//        text_Source = view.findViewById(R.id.source_artical);
//        txt_Title = view.findViewById(R.id.title_artical);
//        txt_Body = view.findViewById(R.id.body_artical);
//        return view;
    }

    public void update_Info(String source, String title, String body) {
        Log.e(TAG, "data heating postion update_Info : " + source + " - " + title + " - " + body);
        binding.sourceArtical.setText(source);
        binding.titleArtical.setText(title);
        binding.bodyArtical.setText(body);
//        text_Source.setText(source);
//        txt_Title.setText(title);
//        txt_Body.setText(body);
    }

    public void onBackPressed() {
        PostsFragment nextFrag = new PostsFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, nextFrag)
                .addToBackStack(null)
                .commit();
    }
}
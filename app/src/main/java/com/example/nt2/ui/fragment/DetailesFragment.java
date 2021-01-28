package com.example.nt2.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.nt2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "Fragment_Detailes";
    private TextView txt_Title, text_Source, txt_Body;
    private Bundle bundle;
    private String value_Title, value_Source, value_Body;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailesFragment() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_detailes, container, false);
        bundle = new Bundle();
        text_Source = view.findViewById(R.id.source_artical);
        txt_Title = view.findViewById(R.id.title_artical);
        txt_Body = view.findViewById(R.id.body_artical);

//        if (getArguments() != null) {
//            value_Source = getArguments().getString("source");
//            value_Title = getArguments().getString("title");
//            value_Body = getArguments().getString("body");
//            update_Info(value_Source, value_Title, value_Body);
//
//        } else {
//            Log.e(TAG, "value : " + "Null");
//        }
//        text_Source.setText(value_Source);
//        txt_Title.setText(value_Title);
//        txt_Body.setText(value_Body);
        return view;
    }

    public void update_Info(String source, String title, String body) {
        Log.e(TAG, "data heating postion update_Info : " + source+" - "+title+" - "+body);

        text_Source.setText(source);
        txt_Title.setText(title);
        txt_Body.setText(body);
    }

    public void onBackPressed() {
        AllArticalsFragment nextFrag = new AllArticalsFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, nextFrag)
                .addToBackStack(null)
                .commit();
    }
}
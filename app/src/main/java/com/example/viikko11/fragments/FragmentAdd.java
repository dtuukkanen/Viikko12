package com.example.viikko11.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.viikko11.Item;
import com.example.viikko11.R;
import com.example.viikko11.Storage;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAdd#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAdd extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentAdd() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAdd.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAdd newInstance(String param1, String param2) {
        FragmentAdd fragment = new FragmentAdd();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        CheckBox importantItem = view.findViewById(R.id.cbImportantFragment);
        Button btnAddItem = view.findViewById(R.id.btnAddItemFragment);
        btnAddItem.setOnClickListener(view1 -> addItem(view));
        return view;
    }

    public void addItem(View view) {
        String textItemNotes = ((EditText) view.findViewById(R.id.editNotesFragment)).getText().toString();
        CheckBox importantItem = view.findViewById(R.id.cbImportantFragment);
        if (importantItem.isChecked()) {
            Storage.getInstance().addItem(new Item(textItemNotes, true));
        } else {
            Storage.getInstance().addItem(new Item(textItemNotes, false));
        }
    }
}
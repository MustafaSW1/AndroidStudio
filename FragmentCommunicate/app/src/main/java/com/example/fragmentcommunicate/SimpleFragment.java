package com.example.fragmentcommunicate;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;


public class SimpleFragment extends Fragment {

    private static final int YES = 0;
    private static final int NO = 1;
    private static final int NONE = 2;
    public int mRadioButtonChoice = NONE;
    onFragmentInterfaceClickListener mListener;
    private static final String CHOICE = "choice";

    public SimpleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof onFragmentInterfaceClickListener){
            mListener = (onFragmentInterfaceClickListener) context;
        }else{
            throw new ClassCastException(context.toString()+getResources().getString(R.string.exaption_message));
        }
    }

    public static SimpleFragment newInstance(int chocie) {
        SimpleFragment fragment = new SimpleFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(CHOICE,chocie);
        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //inflater.inflate(R.layout.fragment_simple, container, false);
        View rootView = inflater.inflate(R.layout.fragment_simple,container,false);
        RadioGroup radioGroup = rootView.findViewById(R.id.radioGroup);

        if (getArguments().containsKey(CHOICE)){

            mRadioButtonChoice = getArguments().getInt(CHOICE);
            if (mRadioButtonChoice != NONE){
                radioGroup.check(radioGroup.getChildAt(mRadioButtonChoice).getId());
            }
        }


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View radioButton = radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
                TextView textView = rootView.findViewById(R.id.fragment_header);

                switch (index){
                    case YES:
                        textView.setText("i like it");
                        mRadioButtonChoice = YES;
                        mListener.onRadioButtonChoice(YES);
                        break;

                    case NO:
                        textView.setText("i didn't like it");
                        mRadioButtonChoice = NO;
                        mListener.onRadioButtonChoice(NO);
                        break;

                    default:
                        mRadioButtonChoice = NONE;
                        mListener.onRadioButtonChoice(NONE);
                        break;
                }
            }
        });
        return rootView;
    }

    interface onFragmentInterfaceClickListener{
        void onRadioButtonChoice(int choice);
    }
}
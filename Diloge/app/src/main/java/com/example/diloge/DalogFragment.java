package com.example.diloge;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import android.widget.Toast;


public class DalogFragment extends DialogFragment {


    private static final String ARG_TITLE = "title";
    private static final String ARG_MESSAGE = "message";
    private static final String ARG_ICON = "icon";

    private String title;
    private String message;
    private int icon;

    private OnPositiveClickListener positveClickListener;
    private OnNegativeClickListener negativeClickListener;
    private OnNeutralClickListener neutralClickListener;

    public DalogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        //First Interface code
        if (context instanceof OnPositiveClickListener){
            positveClickListener = (OnPositiveClickListener) context;
        }else {
            throw new RuntimeException("please implement Listener : OnPositiveClickListener");
        }


        //Second Interface code
        if (context instanceof OnNegativeClickListener){
            negativeClickListener = (OnNegativeClickListener) context;
        }else {
            throw new RuntimeException("please implement Listener : OnNegativeClickListener");
        }


        //Third Interface code
        if (context instanceof OnNeutralClickListener){
            neutralClickListener = (OnNeutralClickListener) context;
        }else {
            throw new RuntimeException("please implement Listener : OnNeutralClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        positveClickListener = null;
        negativeClickListener = null;
        neutralClickListener = null;
    }

    public static DalogFragment newInstance(String title, String message, int icon) {
        DalogFragment fragment = new DalogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE,title);
        bundle.putString(ARG_MESSAGE,message);
        bundle.putInt(ARG_ICON,icon);
        fragment.setArguments(bundle);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setIcon(icon);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                negativeClickListener.onNegativeClickListener();
            }
        });

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                positveClickListener.onPositiveClickListener();
            }
        });

        builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                neutralClickListener.onNeutralClickListener();
            }
        });
        return builder.create();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            title = args.getString(ARG_TITLE);
            message = args.getString(ARG_MESSAGE);
            icon = args.getInt(ARG_ICON);
        }
    }

    public interface OnPositiveClickListener {
        void onPositiveClickListener();
    }

    public interface OnNegativeClickListener{
        void onNegativeClickListener();
    }

    public interface OnNeutralClickListener{
        void onNeutralClickListener();
    }
}

/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dalog, container, false);
    }

 */
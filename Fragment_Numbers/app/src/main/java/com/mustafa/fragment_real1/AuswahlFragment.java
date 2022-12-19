package com.mustafa.fragment_real1;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class AuswahlFragment extends ListFragment {

    private static final String  STR_ZULEKTIETZ = "zuletztSelekiert";

    boolean zweiSplatungModus;
    int zuletztSelekiert = 0;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1,
                new String[]{"eins","zwei","drei","vier"}));
        View detailsFrame = getActivity().findViewById(R.id.details);
        //boolean
        zweiSplatungModus = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

/*
 if (savedInstanceState != null){
            zuletztSelekiert = savedInstanceState.getInt(STR_ZULEKTIETZ,0);
        }
 */


        if (zweiSplatungModus){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            detailsAnzeigen(zuletztSelekiert);
        }
    }
/*
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.getInt(STR_ZULEKTIETZ,0);
    }
 */

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        detailsAnzeigen(position);
    }

    void detailsAnzeigen(int index){

        zuletztSelekiert = index;
        if (zweiSplatungModus){
            getListView().setItemChecked(index,true);
            DetailsFragment details = (DetailsFragment)getFragmentManager().
                    findFragmentById(R.id.details);

            //getIndex methode von klasse DetailsActivity
            if (details == null || details.getIndex()!=index){
                details =  DetailsFragment.newInstance(index);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.details,details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }else {
            Intent intent = new Intent();
            intent.setClass(getActivity(),DetailsActivity.class);
            intent.putExtra(DetailsFragment.INDEX,index);
            startActivity(intent);
        }

    }
}

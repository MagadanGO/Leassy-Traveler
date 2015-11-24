package com.leassy.studiodd.LeassyT.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;

import com.leassy.studiodd.LeassyT.Activities.AdminSQLiteOpenHelper;
import com.leassy.studiodd.LeassyT.R;

public class ExpFragment extends Fragment {

    int idRe,idA;
    Bundle bundle;
    Cursor cursor;
    MediaPlayer mp;
    ImageView imagen;
    ImageButton btnmedia;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExpFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static ExpFragment newInstance(String param1, String param2) {
        ExpFragment fragment = new ExpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ExpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }//OnCrate

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exp, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void onStart() {
        super.onStart();
        bundle = getActivity().getIntent().getExtras();
        idRe=bundle.getInt("idx");
        idA=bundle.getInt("idy");
        consultar();

        imagen = (ImageView) getActivity().findViewById(R.id.imageView);

        cursor.moveToFirst();

        imagen.setImageResource(getResources().getIdentifier(cursor.getString(3),"drawable",getActivity().getPackageName()));

        mp=MediaPlayer.create(getActivity().getApplicationContext(),getResources().getIdentifier(cursor.getString(2),"raw",getActivity().getApplicationContext().getPackageName()));

        btnmedia = (ImageButton) getView().findViewById(R.id.imageButton);
        btnmedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        TextView txt1 = (TextView)getView().findViewById(R.id.fraseesp);
        txt1.setText(cursor.getString(0));
        TextView txt2 = (TextView)getView().findViewById(R.id.fraseing);
        txt2.setText(cursor.getString(1));

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    public void consultar(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity().getApplicationContext(),"base",null,1);
        SQLiteDatabase base = admin.getWritableDatabase();
        cursor= base.rawQuery("select fraseesp,fraseing,audio,imagen from FRASES where ID = "+idRe+" and area="+idA,null);
    }//Consultar

}

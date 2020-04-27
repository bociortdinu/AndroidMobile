package com.studioapp.mobileapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.sql.SQLException;

import static com.studioapp.mobileapp.R.*;

public class ProfilFragment extends Fragment
{

    private static View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(layout.fragment_profil, container, false);
        setHasOptionsMenu(true);

        Toolbar toolbar = rootView.findViewById(id.toolbar1);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

//        try {
//            Profil.getInstance().extractData();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Profil.getInstance().updateProfil();

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar1_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.settings_change:
                //edit;
                Toast.makeText(getContext(),"Editare", Toast.LENGTH_LONG).show();
                startEditareProfil();
                break;
            case R.id.settings_logout:
                Toast.makeText(getContext(),"Deconectat",Toast.LENGTH_LONG).show();
                kill_interface();
                startLogin();

        }

        return super.onOptionsItemSelected(item);
    }

    private void kill_interface()
    {
        getActivity().finish();
    }

    private void startLogin()
    {
        Intent intent = new Intent(getContext(), Login.class);
        startActivity(intent);
    }

    private void startEditareProfil()
    {
        Intent intent = new Intent(getActivity() , EditareProfil.class);
        startActivity(intent);
    }

    public static View getRootView()
    {
        return rootView;
    }
}



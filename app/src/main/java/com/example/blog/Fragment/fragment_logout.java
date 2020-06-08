package com.example.blog.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.blog.Activities.MainActivity;
import com.example.blog.Activities.Start;
import com.example.blog.R;
import com.google.firebase.auth.FirebaseAuth;


public class fragment_logout extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_logout, container, false);
        Button quit=view.findViewById(R.id.quitt);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent homeActivity = new Intent(getActivity(), Start.class);
                startActivity(homeActivity);
            }
        });
        Button stay=view.findViewById(R.id.stay);
        stay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeActivity = new Intent(getActivity(), MainActivity.class);
                startActivity(homeActivity);

            }
        });
       return view;
    }
}

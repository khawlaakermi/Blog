package com.example.blog.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.blog.Activities.Start;
import com.example.blog.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class fragment_profile extends Fragment {

    FirebaseAuth mAuth;
    FirebaseUser currentUser ;


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        View fragmentView = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView nom_user=fragmentView.findViewById(R.id.nom_user);
        TextView email_user=fragmentView.findViewById(R.id.email_user);
        TextView logout=fragmentView.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent homeActivity = new Intent(container.getContext(),Start.class);
                startActivity(homeActivity);
                getActivity().finish();
            }
        });
        ImageView img_user=fragmentView.findViewById(R.id.userprofile_img);
        nom_user.setText(currentUser.getDisplayName());
        email_user.setText(currentUser.getEmail());
        Glide.with(this).load(currentUser.getPhotoUrl()).into(img_user);


        return fragmentView ;
    }



}

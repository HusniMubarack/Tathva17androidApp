package com.tathva17.tathva.tathva17;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;

/**
 * Created by VRUSHABH on 09-10-2016.
 */
public class ProfileFragment extends Fragment {
    private TextView name;
    private TextView email;
    private TextView college;
    private ListView regList;
    private Button Logout;

    private ArrayList<String> arrayList;

    private EventsLoadAdapter adapter;

    private DatabaseReference databaseReference;
    private DatabaseReference drefEvents;
    private String Eventname;

    private FirebaseAuth mAuth;
    private String uid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        name = (TextView) view.findViewById(R.id.username);
        email = (TextView) view.findViewById(R.id.email);
        college = (TextView) view.findViewById(R.id.collegename);
        regList = (ListView) view.findViewById(R.id.registeredList);
        Logout  = (Button) view.findViewById(R.id.Logout);


        if(Utility.isNetworkAvailable(getContext())){
            Toast.makeText(getContext(),"Loading...", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getContext(),"Network is not available", Toast.LENGTH_LONG).show();
        }
        mAuth = FirebaseAuth.getInstance();

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogout();
            }
        });

        FirebaseUser user = mAuth.getCurrentUser();
        uid = user.getUid();



        databaseReference = FirebaseDatabase.getInstance().getReference("/tathva17/users/"+uid);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String uname = dataSnapshot.child("bio/name").getValue(String.class);
                String clg = dataSnapshot.child("bio/college").getValue(String.class);
                String mail = dataSnapshot.child("email").getValue(String.class);
                name.setText(uname);
                college.setText(clg);
                email.setText(mail);

                arrayList = new ArrayList<String>();
                for(DataSnapshot eventsShot : dataSnapshot.child("events").getChildren()){

                    Eventname = eventsShot.getKey();
                    arrayList.add(Eventname);
                    FirebaseMessaging.getInstance().subscribeToTopic(Eventname);
                }
                adapter = new EventsLoadAdapter(getContext(),arrayList);
                regList.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    public void onLogout(){
        for (String s: arrayList) {
            FirebaseMessaging.getInstance().unsubscribeFromTopic(s);
        }


        mAuth.signOut();

        Fragment fragment = new LoginFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, fragment, "fragment")
                .commit();
        getActivity().findViewById(R.id.btn_right_arrow).setVisibility(View.GONE);
        getActivity().findViewById(R.id.btn_left_arrow).setVisibility(View.GONE);
    }



}

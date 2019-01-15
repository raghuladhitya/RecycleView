package com.example.android.recycleview;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    FirebaseDatabase mFireBaseDatabase;
    DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Posts list");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFireBaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFireBaseDatabase.getReference("dash");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Farmer, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Farmer, ViewHolder>(Farmer.class, R.layout.row_view, ViewHolder.class, mDatabaseReference) {


                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Farmer model, int position) {
                        viewHolder.setDetails(getApplicationContext(),model.getTitle(),model.getDescription(),model.getImage());
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}

package com.example.feedbacklistv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        ArrayList<HashMap<String, String>> essayTitles = new ArrayList<>();
        // ideally something like ArrayList<User>

        // TODO: Link this up with User object (including profile picture info?)
        HashMap<String, String> review0 = new HashMap<>();
        review0.put("reviewerUsername", "Alexander Pushkin");
        review0.put("date", "01/29/1837");
        review0.put("essayTitle", "Crime and Punishment");
        review0.put("profilePicture", String.valueOf(R.drawable.pushkin_cropped));
        essayTitles.add(review0);

        HashMap<String, String> review1 = new HashMap<>();
        review1.put("reviewerUsername", "Nikolai Gogol");
        review1.put("date", "02/21/1852");
        review1.put("essayTitle", "The Brothers Karamazov");
        review1.put("profilePicture", String.valueOf(R.drawable.gogol_cropped));
        essayTitles.add(review1);

        for (int i=0; i<5; i++) {
            HashMap<String, String> review = new HashMap<>();
            review.put("reviewerUsername", "Nikolai Gogol" + i);
            review.put("date", "02/21/1852");
            review.put("essayTitle", "The Brothers Karamazov");
            review.put("profilePicture", String.valueOf(R.drawable.gogol_cropped));
            essayTitles.add(review);
        }

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, essayTitles);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        // TODO: Make this actually do something
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
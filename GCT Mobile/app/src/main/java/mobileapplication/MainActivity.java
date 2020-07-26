package mobileapplication;
//package com.gct.mobile.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sairamkrishna.myapplication.R;


public class MainActivity extends Activity  {
    Button b1,b2;
    EditText ed1,ed2;

    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);

        b2 = (Button)findViewById(R.id.button2);
        tx1 = (TextView)findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("admin") &&
                        ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                            tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

/*
package com.example.sharedelementtransition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener {

    // Widgets
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    // Variables
    private List<Integer> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"Government College of Technology\nCelebrating 75 years of building talent for the nation",Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);


        // Binding views
        ButterKnife.bind(this);

        // Adding images to list: Put your own images here
        items.add(R.drawable.gct_logo);

        // Configuring the recycler view adapter
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(items);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);

        // Listening to view clicks
        recyclerViewAdapter.setClickListener(this);
    }

    // Listening to card clicks
    @Override
    public void onCardSelected(View view, int position) {
        doSharedElementTransition(view, position);
    }

    // Method for executing animation
    public void doSharedElementTransition(View view, int position) {

        // Intent for launching activity
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.BUNDLE_KEY,items.get(position));

        // Get the transition name from the strings xml file
        String transitionName = getString(R.string.transition_string);

        // Creating options
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        view,   // clicked view
                        transitionName    // The transition string
                );

        // Start the Intent
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}
*/
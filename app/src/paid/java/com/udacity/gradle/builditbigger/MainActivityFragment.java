package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.android.jokeslibraryandroid.JokesAndroidActivity;

import static com.example.android.jokeslibraryandroid.JokesAndroidActivity.EXTRA_JOKE;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    ProgressBar mProgressBar = null;
    public String mLoadedJoke = null;
    public boolean mTestFlag = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);


        // Set onClickListener for the button
        Button button = root.findViewById(R.id.joke_btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                getJoke();
            }
        });

        mProgressBar = root.findViewById(R.id.joke_progressbar);
        mProgressBar.setVisibility(View.GONE);


        return root;
    }

    public void getJoke(){
        new EndpointAsyncTask().execute(this);
    }

    public void launchDisplayJokeActivity(){
        if (!mTestFlag) {
            Context context = getActivity();
            Intent intent = new Intent(context, JokesAndroidActivity.class);
            intent.putExtra(EXTRA_JOKE, mLoadedJoke);
            //Toast.makeText(context, loadedJoke, Toast.LENGTH_LONG).show();
            context.startActivity(intent);
            mProgressBar.setVisibility(View.GONE);
        }
    }
}

package com.example.android.jokeslibraryandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.android.jokeslibraryandroid.JokesAndroidActivity.EXTRA_JOKE;

public class JokesAndroidFragment extends Fragment {

    public JokesAndroidFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_jokes_android, container, false);
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(EXTRA_JOKE);
        TextView jokeTextView = root.findViewById(R.id.jokes_fragment);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
        return root;
    }
}

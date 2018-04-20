package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class EndpointAsyncTask extends AsyncTask<MainActivityFragment, Void, String> {
    private static MyApi myApiService = null;
    private MainActivityFragment mMainActivityFragment;
    private Context mContext;

    @Override
    protected String doInBackground(MainActivityFragment... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        mMainActivityFragment = params[0];
        mContext = mMainActivityFragment.getActivity();


        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
//                final Intent myIntent = new Intent(context, JokesAndroidActivity.class);
//                myIntent.putExtra(JokesAndroidActivity.EXTRA_JOKE, result);
//                context.startActivity(myIntent);
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        mMainActivityFragment.mLoadedJoke = result;
        mMainActivityFragment.launchDisplayJokeActivity();
    }
}

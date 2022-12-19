package com.example.usernavigation;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void,Void,String> {

    private WeakReference<TextView> mTextView;


    SimpleAsyncTask(TextView tv){
        mTextView = new WeakReference<>(tv);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    
    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();

        int n = r.nextInt(10);
        int s = n * 200;
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Awake at last after sleeping for " + s + " milliseconds!";
    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        mTextView.get().setText(result);

    }
}

package com.example.lockfinal;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class mainpage extends AppCompatActivity {
    private String message;
    ImageButton streamview,open,getstatus;
    FloatingActionButton fpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        streamview=findViewById(R.id.streamview);
        open=findViewById(R.id.open);
        getstatus=findViewById(R.id.getstatus);
        fpb=findViewById(R.id.fab);
        open.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {



                    message = "on";
                    new GetUrlContentTask().execute();

            }
        });
        streamview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        fpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mainpage.this,profile.class);
                startActivity(intent);
            }
        });



    }
    private class GetUrlContentTask extends AsyncTask<String, Integer, String> {
        protected String doInBackground(String... urls) {
            URL url = null;
            try {
                url = new URL("http://159.65.158.141:8081/lockState=" + message);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                Log.d("hey","in http");
                connection.setRequestMethod("GET");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.connect();
                BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String content = "", line;
                while ((line = rd.readLine()) != null) {
                    content += line + "\n";
                }
                return content;
            } catch (Exception e) {

            }
            return null;
        }
        protected void onProgressUpdate(Integer... progress) {
        }

        protected void onPostExecute(String result) {
        }
    }
}

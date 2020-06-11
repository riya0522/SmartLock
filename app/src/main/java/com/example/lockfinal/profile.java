package com.example.lockfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profile extends AppCompatActivity {
        TextView name;
        TextView uname;
        TextView email;
        TextView phnum;
        Button remove;
        Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
            setContentView(R.layout.activity_main);
            name= findViewById(R.id.name);
            uname=findViewById(R.id.enteruname);
            email=findViewById(R.id.enteremail);
            phnum=findViewById(R.id.enterphnum);
            remove=(Button)findViewById(R.id.rem);
            logout=(Button)findViewById(R.id.logout);
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(profile.this,key.class);
                    startActivity(intent);
                }
            });
    }
}

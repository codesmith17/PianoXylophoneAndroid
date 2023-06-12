package com.example.pianofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class options_activity extends AppCompatActivity {
    LinearLayout iv1,xylo,iv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        iv1=findViewById(R.id.iv1);
        xylo=findViewById(R.id.xylo);
        iv3=findViewById(R.id.iv3);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(options_activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        xylo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(options_activity.this,xylophone.class);
                startActivity(intent);
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(options_activity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }
}
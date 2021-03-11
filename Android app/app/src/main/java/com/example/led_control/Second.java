package com.example.led_control;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Second extends AppCompatActivity {
    Button bu1,bu2,bu3,bu4,bu5,bu6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bu1=(Button)findViewById(R.id.livingroom);
        bu2=(Button)findViewById(R.id.kitchen);
        bu3=(Button)findViewById(R.id.bathroom);
        bu4=(Button)findViewById(R.id.garden);
        bu5=(Button)findViewById(R.id.others);
        bu6=(Button)findViewById(R.id.secondbutton);

        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Second.this,Livingroom.class);
                startActivity(i);
                finish();
            }
        });
        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Second.this,Kitchen.class);
                startActivity(i);
                finish();
            }
        });bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Second.this,Bathroom.class);
                startActivity(i);
                finish();
            }
        });
        bu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Second.this,Garden.class);
                startActivity(i);
                finish();
            }
        });
        bu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Second.this,Others.class);
                startActivity(i);
                finish();
            }
        });
        bu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Second.this,Garden.class);
                startActivity(i);
                finish();
            }
        });
        bu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Second.this,Livingroom.class);
                startActivity(i);
                finish();
            }
        });
    }
}

package com.example.led_control;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Bathroom extends AppCompatActivity {
    Button bu17,bu18,bu19,bu20,bu21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom);
        bu17=(Button)findViewById(R.id.bledon);
        bu18=(Button)findViewById(R.id.bledoff);
        bu19=(Button)findViewById(R.id.exhauston);
        bu20=(Button)findViewById(R.id.exhaustoff);
        bu21=(Button)findViewById(R.id.bathroombutton);

        bu17.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS");
                myRef.setValue(1);
            }
        });
        bu18.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS");
                myRef.setValue(0);
            }
        });
        bu19.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS");
                myRef.setValue(1);
            }
        });
        bu20.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS");
                myRef.setValue(0);
            }
        });
        bu21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Bathroom.this,Second.class);
                startActivity(i);
                finish();
            }
        });
    }
}

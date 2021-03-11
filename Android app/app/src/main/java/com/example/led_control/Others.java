package com.example.led_control;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Others extends AppCompatActivity {
    Button bu25, bu26, bu27;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        bu25 = (Button) findViewById(R.id.garageon);
        bu26 = (Button) findViewById(R.id.garageoff);
        bu27 = (Button) findViewById(R.id.gardenbutton);

        bu25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS");
                myRef.setValue(1);
            }
        });
        bu26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS");
                myRef.setValue(0);
            }
        });
        bu27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Others.this, Second.class);
                startActivity(i);
                finish();
            }
        });
    }
}

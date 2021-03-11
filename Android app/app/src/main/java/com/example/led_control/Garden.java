package com.example.led_control;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Garden extends AppCompatActivity {
    Button bu22, bu23, bu24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden);
        bu22 = (Button) findViewById(R.id.garageon);
        bu23 = (Button) findViewById(R.id.garageoff);
        bu24 = (Button) findViewById(R.id.gardenbutton);

        bu22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS");
                myRef.setValue(1);
            }
        });
        bu23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LED_STATUS");
                myRef.setValue(0);
            }
        });
        bu24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Garden.this, Second.class);
                startActivity(i);
                finish();
            }
        });
    }
}

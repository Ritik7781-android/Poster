package com.example.poster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Purpose_Activity extends AppCompatActivity {

    CardView yourNameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purpose); // yahi XML ka naam hona chahiye

        yourNameLayout = findViewById(R.id.yourName); // ID correct hona chahiye

        yourNameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Purpose_Activity.this, Profile_Activity.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.poster;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class LanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        // सभी भाषा के कार्ड को findViewById से लिंक करो
        CardView cardHindi = findViewById(R.id.cardHindi);
        CardView cardMarathi = findViewById(R.id.cardMarathi);
        CardView cardEnglish = findViewById(R.id.cardEnglish);
        CardView cardGujarati = findViewById(R.id.cardGujarati);
        CardView cardTamil = findViewById(R.id.cardTamil);
        CardView cardTelugu = findViewById(R.id.cardTelugu);

        // Click listeners for each language
        cardHindi.setOnClickListener(v -> openPurposeActivity("hi"));
        cardMarathi.setOnClickListener(v -> openPurposeActivity("mr"));
        cardEnglish.setOnClickListener(v -> openPurposeActivity("en"));
        cardGujarati.setOnClickListener(v -> openPurposeActivity("gu"));
        cardTamil.setOnClickListener(v -> openPurposeActivity("ta"));
        cardTelugu.setOnClickListener(v -> openPurposeActivity("te"));
    }

    private void openPurposeActivity(String languageCode) {
        Intent intent = new Intent(LanguageActivity.this, Purpose_Activity.class);
        intent.putExtra("selected_language", languageCode);
        startActivity(intent);
        finish(); // यह activity बंद कर दो
    }
}

package com.example.poster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // SharedPreferences se last selected language lo
        SharedPreferences prefs = getSharedPreferences("AppSettings", MODE_PRIVATE);
        String savedLanguage = prefs.getString("LANGUAGE", "en"); // Default English

        // Agar naye intent se language aayi hai toh use karo
        String languageCode = getIntent().getStringExtra("selected_language");
        if (languageCode != null && !languageCode.equals(savedLanguage)) {
            setAppLocale(languageCode);

            // Nayi language preference save karo
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("LANGUAGE", languageCode);
            editor.apply();

            // UI update ke liye activity restart karo
            Intent intent = new Intent(this, MainActivity.class);
            finish();
            startActivity(intent);
            return;
        } else {
            setAppLocale(savedLanguage);
        }

        setContentView(R.layout.activity_main);
    }

    private void setAppLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
}

package com.example.poster;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Profile_Activity extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    private ImageView imageProfile;
    private EditText editName;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EdgeToEdge.enable(this);
                // Initialize views
        imageProfile = findViewById(R.id.imageProfile);
        editName = findViewById(R.id.editName);
        btnContinue = findViewById(R.id.btnContinue);

        // Image click listener
        imageProfile.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
        });

        // Button click listener
        btnContinue.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();
            if (!name.isEmpty()) {
                Toast.makeText(Profile_Activity.this, "Welcome " + name, Toast.LENGTH_SHORT).show();
            } else {
                editName.setError("Please enter your name");
            }
        });
    }

    // Handle image selection
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            imageProfile.setImageURI(imageUri);
        }
    }
}

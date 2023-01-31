package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    EditText name_textview, status_textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name_textview = findViewById(R.id.name_textview);
        status_textview = findViewById(R.id.status_textview);

        loadProfile();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveProfile();
    }

    void loadProfile() {
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        String name_p = pref.getString("name", "");
        String status_p = pref.getString("status", "");

        name_textview.setText(name_p);
        status_textview.setText(status_p);



    }

    void saveProfile() {
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("name", name_textview.getText().toString());
        editor.putString("status", status_textview.getText().toString());

        editor.apply();
    }

    public void onGoBackClicked(View view) {
        finish();
    }
}
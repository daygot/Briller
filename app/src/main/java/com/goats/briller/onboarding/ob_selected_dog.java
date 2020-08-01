package com.goats.briller.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.goats.briller.R;

import java.io.File;
import java.io.FileWriter;

public class ob_selected_dog extends AppCompatActivity {

    Button enter_button_dog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ob_selected_dog);

        final EditText entered_text = findViewById(R.id.text_input_dog);
        enter_button_dog = findViewById(R.id.enter_button_dog);

        enter_button_dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!entered_text.getText().toString().isEmpty()) {
                    File file = new File(ob_selected_dog.this.getFilesDir(), "text");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    try {
                        File gpxfile = new File(file, "Pet_Data");
                        FileWriter writer = new FileWriter(gpxfile);
                        writer.append(entered_text.getText().toString());
                        writer.flush();
                        writer.close();
                        Toast.makeText(ob_selected_dog.this, "Saved your text", Toast.LENGTH_LONG).show();
                    } catch (Exception e) { }
                }
            }
        });
    }

}

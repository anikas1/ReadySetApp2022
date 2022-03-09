package com.example.uploadpagev1;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText link_text;
    private TextView output_text;
    private Button submit_button;
    private Button upload_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reference: https://www.includehelp.com/android/get-value-of-edit-text.aspx
        link_text = (EditText) findViewById(R.id.link_input);
        output_text = (TextView) findViewById(R.id.link_output);
        submit_button = (Button) findViewById(R.id.button_input);
        upload_button = (Button) findViewById(R.id.uploadButton);
        // lambda shenanigans, let Android Studio convert it for me
        submit_button.setOnClickListener(this::onClickSubmit);
        upload_button.setOnClickListener(this::onClickUpload);
    }

    private void onClickSubmit(View v) {
        // TODO: Save link_text.getText() to something useful like User object(?)
        output_text.setText(getString(R.string.display_stored_link_prompt, link_text.getText()));
    }

    private void onClickUpload(View v) {
        mGetContent.launch("text/*");
    }

    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    // reference: https://stackoverflow.com/questions/31069556/android-read-text-file-from-uri
                    String content = null;
                    try {
                        InputStream in = getContentResolver().openInputStream(uri);

                        BufferedReader r = new BufferedReader(new InputStreamReader(in));
                        StringBuilder total = new StringBuilder();
                        for (String line; (line = r.readLine()) != null; ) {
                            total.append(line).append('\n');
                        }

                        content = total.toString();



                    }catch (Exception e) {
                        e.printStackTrace();
                    }

                    output_text.setText(getString(R.string.display_stored_link_prompt, content));
                }
            });

}


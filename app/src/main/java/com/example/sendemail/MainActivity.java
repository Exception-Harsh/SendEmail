package com.example.sendemail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etTo, etSub, etMsg;
    Button btSend;
    String to, subject, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTo = (EditText) findViewById(R.id.etTo);
        etSub = (EditText) findViewById(R.id.etSub);
        etMsg = (EditText) findViewById(R.id.etMsg);

        btSend = (Button) findViewById(R.id.btSend);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to = etTo.getText().toString();
                subject = etSub.getText().toString();
                message = etMsg.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose Email client :"));
            }
        });
    }
}
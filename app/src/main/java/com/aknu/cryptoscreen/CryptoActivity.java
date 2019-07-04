package com.aknu.cryptoscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CryptoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto);
        //Here, the activity receives the intent from the previous activity.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //The activity receives the string carried over, and it displays it at the top by setting it
        //as the value for the textview we instantiated.
        TextView textView = findViewById(R.id.Message);
        textView.setText(message);

        //HERE, you wanted to create a screen that portrays some popular cryptos information.
    }
}

package com.aknu.cryptoscreen;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.CryptoScreen.CRYPTOSCREEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        //Here I have created and intent. Clicking the button on the mainactivity will allow for the
        //new activity screen to open. This screen will be used to display crypto information.
        Intent intent = new Intent(this, CryptoActivity.class);
        //I am instantiating a String variable (message), and then setting it to hold a value.
        String message;
        message = "This is how the Cryptos are looking today: ";
        //Here, I am having the intent carry this message over to the CryptoActivity Activity.
        intent.putExtra(EXTRA_MESSAGE, message);
        //This line starts the next activity upon button click.
        startActivity(intent);
    }

    public void onClick2(View view) {
        Intent intent2 = new Intent(this, FireBase_Activity.class);
        startActivity(intent2);
    }

}

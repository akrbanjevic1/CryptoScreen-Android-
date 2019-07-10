package com.aknu.cryptoscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


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

}

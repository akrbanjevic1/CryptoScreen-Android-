package com.aknu.cryptoscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CryptoActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private TextView BitCoinz;
    private TextView Ethereumz;
    private TextView LiteCoinz;

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

        BitCoinz = findViewById(R.id.BitCoin);

        //Here we instantiate the requestqueue.
        mRequestQueue = Volley.newRequestQueue(this);
        Button parse = findViewById(R.id.parse);
        parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitCoinz.setText("");
                BitCoinParse();
            }
        });

        //Here, we are instantiating the textviews for the various cryptos, and we are setting their
        //text to be the parsed information.
        //In addition, we are also setting their respective onClick methods, and then setting
        //their respective parsing methods

        Ethereumz = findViewById(R.id.EthereumCoin);
        Button EthereumParse = findViewById(R.id.EthereumParse);
        EthereumParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ethereumz.setText("");
                EthereumParse();
            }
        });

        LiteCoinz = findViewById(R.id.LiteCoin);
        Button LiteCoinParse = findViewById(R.id.LiteCoinParse);
        LiteCoinParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LiteCoinParse();
            }
        });
    }

    private void BitCoinParse() {
        //Here, we define the string "url" to hold the link to the relevant information from the
        //Alpha vantage API
        String url = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=BTC&to_currency=USD&apikey=45APH96LSR9LHB57";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonobject = response.getJSONObject("Realtime Currency " +
                                    "Exchange Rate");

                                String FromCode = jsonobject.getString("1. From_Currency Code");
                                String ToCode = jsonobject.getString("3. To_Currency Code");
                                String ExchangeRate = jsonobject.getString("5. Exchange Rate");
                                String LastRefreshed = jsonobject.getString("6. Last Refreshed");
                                String TimeZone = jsonobject.getString("7. Time Zone");

                                BitCoinz.append("From " +FromCode + ", " + "To " + ToCode + ", "
                                        + ExchangeRate + ", " + LastRefreshed + "," + "Timezone: "
                                        + TimeZone);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }

    private void EthereumParse() {
        String url = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=ETH&to_currency=USD&apikey=45APH96LSR9LHB57";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonobject = response.getJSONObject("Realtime Currency " +
                                    "Exchange Rate");

                            String FromCode = jsonobject.getString("1. From_Currency Code");
                            String ToCode = jsonobject.getString("3. To_Currency Code");
                            String ExchangeRate = jsonobject.getString("5. Exchange Rate");
                            String LastRefreshed = jsonobject.getString("6. Last Refreshed");
                            String TimeZone = jsonobject.getString("7. Time Zone");

                            Ethereumz.append("From " +FromCode + ", " + "To " + ToCode + ", " +
                                    ExchangeRate + ", " + LastRefreshed + "," + "Timezone: " +
                                    TimeZone);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }

    private void LiteCoinParse() {
        String url = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=LTC&to_currency=USD&apikey=45APH96LSR9LHB57";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonobject = response.getJSONObject("Realtime Currency " +
                                    "Exchange Rate");

                            String FromCode = jsonobject.getString("1. From_Currency Code");
                            String ToCode = jsonobject.getString("3. To_Currency Code");
                            String ExchangeRate = jsonobject.getString("5. Exchange Rate");
                            String LastRefreshed = jsonobject.getString("6. Last Refreshed");
                            String TimeZone = jsonobject.getString("7. Time Zone");

                            LiteCoinz.append("From " +FromCode + ", " + "To " + ToCode + ", " +
                                    ExchangeRate + ", " + LastRefreshed + "," + "Timezone: " +
                                    TimeZone);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }
}

package com.theolius.bird.httpformtoservemyego;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String url = "http://www.droidresp.ga/resp.php";

    EditText nameInput,passInput;
    TextView debugText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameInput = (EditText)findViewById(R.id.NameText);
        passInput = (EditText)findViewById(R.id.PassText);
        debugText = (TextView)findViewById(R.id.debugText);
    }

    public void SendShit(View view) throws IOException {
        if(nameInput.getText()!=null && passInput.getText()!=null) {
            AsyncTask<Void, Void, String> response;
            sender sen = new sender(url, nameInput.getText().toString(), passInput.getText().toString());
            response = sen.execute();
            Log.e("JSON", String.valueOf(response));
        }else {
            return;
        }
    }
}

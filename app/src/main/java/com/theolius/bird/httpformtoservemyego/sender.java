package com.theolius.bird.httpformtoservemyego;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class sender extends AsyncTask<Void,Void,String> {

    String url,nameInput,passInput;

    public sender(String u, String n,String p){
        this.url = u;
        this.nameInput = n;
        this.passInput = p;
    }

    @Override
    protected String doInBackground(Void... params) {
        try{
            URL Url = new URL(url);
            String data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(nameInput,"UTF-8")+
                    "&"+URLEncoder.encode("password","UTF-8")+
                    "="+URLEncoder.encode(passInput,"UTF-8");

            URLConnection conn = Url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
            osw.write(data);
            osw.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder strb = new StringBuilder();
            while((line = br.readLine())!=null){
                strb.append(line);
                break;
            }

            Log.e("RESPONSE: ",line);
            return line;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

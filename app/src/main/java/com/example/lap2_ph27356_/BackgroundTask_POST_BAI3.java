package com.example.lap2_ph27356_;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask_POST_BAI3 extends AsyncTask<String,Void,Void> {
    String duongdan = BAI3.SERVER_NAME;
   TextView tvResult;
   String edCanh;
   String str;
   ProgressDialog pDiaLog;
   Context context;

    public BackgroundTask_POST_BAI3(TextView tvResult, Context context) {
        this.tvResult = tvResult;
        this.context = context;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDiaLog = new ProgressDialog(context);
        pDiaLog.setMessage("Sending....");
        pDiaLog.setIndeterminate(false);
        pDiaLog.setCancelable(false);
        pDiaLog.show();
    }

    @Override
    protected Void doInBackground(String... params) {

        try {

                URL url = new URL(duongdan);
                String param = "canh=" + URLEncoder.encode(params[0].toString(),"utf-8");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("POST");
                urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
                urlConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            PrintWriter print = new PrintWriter(urlConnection.getOutputStream());
            print.print(param);
            print.close();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            StringBuffer sb = new StringBuffer();
            while ((line=bfr.readLine()) != null){
                sb.append(line);
            }
            str = sb.toString();
            urlConnection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        if(pDiaLog.isShowing()){
            pDiaLog.dismiss();

        }
        tvResult.setText(str);
    }
}

package com.example.lap2_ph27356_;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BackgroundTask_GET extends AsyncTask<Void,Void,Void> {
    String duongdan = BAI1.SERVER_NAME;
   TextView tvResult;
   String edName,edScore;
   String str;
   ProgressDialog pDiaLog;
   Context context;

    public BackgroundTask_GET(TextView tvResult, String edName, String edScore, Context context) {
        this.tvResult = tvResult;
        this.edName = edName;
        this.edScore = edScore;
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
    protected Void doInBackground(Void... params) {
        duongdan += "?name=" +this.edName + "&score=" + this.edScore;
        try {

                URL url = new URL(duongdan);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
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

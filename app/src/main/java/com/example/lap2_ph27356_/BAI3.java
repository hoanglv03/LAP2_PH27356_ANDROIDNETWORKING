package com.example.lap2_ph27356_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BAI3 extends AppCompatActivity {
    private Button btnSend;
    private TextView tvResult;
    private EditText edCanh;


    public static final String SERVER_NAME = "http://192.168.0.101/luongviethoang_ph27356/canh_POST.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        init();
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String strCanh = edCanh.getText().toString();
               BackgroundTask_POST_BAI3 bai3 = new BackgroundTask_POST_BAI3(tvResult,BAI3.this);
                bai3.execute(strCanh);
            }
        });
    }
    private void init(){
        btnSend = findViewById(R.id.btnSend3);
        tvResult = findViewById(R.id.tvResult3);
        edCanh = findViewById(R.id.edCanh);

    }
}
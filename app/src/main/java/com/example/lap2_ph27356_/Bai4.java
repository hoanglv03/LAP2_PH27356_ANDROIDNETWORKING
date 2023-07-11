package com.example.lap2_ph27356_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai4 extends AppCompatActivity {
    public static final String SERVER_NAME = "http://192.168.0.101/luongviethoang_ph27356/giaiphuongtrinh_POST.php";
    Button btnSend4;
    EditText edA,edB,edC;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        Init();
        btnSend4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String A = edA.getText().toString();
                String B = edB.getText().toString();
                String C = edC.getText().toString();
                BackgroundTask_POST_BAI4 pPost = new BackgroundTask_POST_BAI4(tvResult,Bai4.this);
                pPost.execute(A,B,C);
            }
        });
    }
    private void Init(){
        btnSend4 = findViewById(R.id.btnSend4);
        edA = findViewById(R.id.edA);
        edB = findViewById(R.id.edB);
        edC = findViewById(R.id.edC);
        tvResult = findViewById(R.id.tvResult4);
    }
}
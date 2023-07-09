package com.example.lap2_ph27356_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BAI1 extends AppCompatActivity {
    private Button btnSend;
    private TextView tvResult;
    private EditText edScore,edName;


    public static final String SERVER_NAME = "http://192.168.0.108/luongviethoang_ph27356/student_GET.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
btnSend.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String strName = edName.getText().toString();
        String strScore = edScore.getText().toString();
        BackgroundTask_GET get = new BackgroundTask_GET(tvResult,strName,strScore, BAI1.this);
        get.execute();

    }
});
    }
    private void init(){
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);
        edName = findViewById(R.id.edName);
        edScore = findViewById(R.id.edScore);
    }


}
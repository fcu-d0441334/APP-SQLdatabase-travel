package com.kaiappgo.go;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OtherActivity extends Activity {
    private Button btn_whereami;
    private Button btn_reportproblem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        btn_whereami = findViewById(R.id.btn_whereami);
        btn_reportproblem = findViewById(R.id.btn_reportproblem);

        btn_whereami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        btn_reportproblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfEUuptbW1wbJUekS70f5iOvzXwu5tbQ6B2Zr8YOPlNFW07dQ/viewform");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}

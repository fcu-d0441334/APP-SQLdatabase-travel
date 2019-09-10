package com.kaiappgo.go;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class planingActivity extends Activity {

    private Button btn_planingA;
    private Button btn_planingB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planing);

        btn_planingA = findViewById(R.id.btn_planingA);
        btn_planingB = findViewById(R.id.btn_planingB);

        btn_planingA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(planingActivity.this, planingChild1Activity.class);
                startActivity(intent);
            }
        });
        btn_planingB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(planingActivity.this, planingChild2Activity.class);
                startActivity(intent);
            }
        });
    }
}

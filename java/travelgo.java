package com.kaiappgo.go;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class travelgo extends Activity {

    private Button btn_to_introduction;
    private Button btn_to_planing;
    private Button btn_to_card;
    private Button btn_to_other;

    public static class randomNumber{
        public static int random1 = (int)(Math.random()* 100);
        public static int random2 = (int)(Math.random()* 100);
        public static int random3 = (int)(Math.random()* 100);

        public static int getrandom1() {
            return random1;
        }
        public static int getrandom2() {
            while(random2 == random1) random2 =  (int)(Math.random()* 100);
            return random2;
        }
        public static int getrandom3() {
            while(random3 == random2 || random3 == random1) random3 =  (int)(Math.random()* 100);
            return random3;
        }
        public static void setAllrandom() {
            random1 = (int)(Math.random()* 100);
            random2 =  (int)(Math.random()* 100);
            random3 =  (int)(Math.random()* 100);
            while(random2 == random1) random2 =  (int)(Math.random()* 100);
            while(random3 == random2 || random3 == random1) random3 =  (int)(Math.random()* 100);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travelgo);

        btn_to_introduction = (Button) findViewById(R.id.btn_to_introduction);
        btn_to_planing = (Button) findViewById(R.id.btn_to_planing);
        btn_to_card = (Button) findViewById(R.id.btn_to_card);
        btn_to_other = (Button) findViewById(R.id.btn_to_other);

        Toast toast = Toast.makeText(travelgo.this,"歡迎使用台中GO，請開啟網路及GPS功能!",Toast.LENGTH_LONG);
        toast.show();

        btn_to_introduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(travelgo.this,introductionActivity.class);
                startActivity(intent);//跳到旅遊介紹
            }
        });
        btn_to_planing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(travelgo.this,planingActivity.class);
                startActivity(intent);//跳到旅遊規劃
            }
        });
        btn_to_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(travelgo.this,cardWeb.class);
                startActivity(intent);
            }
        });
        btn_to_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(travelgo.this,OtherActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.kaiappgo.go;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class planingChild2Activity extends Activity {
    private MyDB db = null;

    travelgo.randomNumber getRandomNumber = new travelgo.randomNumber();
    MapsActivity.getXY getMAPActivity = new MapsActivity.getXY();

    private Button btn_list1go;
    private Button btn_list2go;
    private Button btn_list3go;
    private Button btn_change;

    private int random1 = getRandomNumber.getrandom1();
    private int random2 = getRandomNumber.getrandom2();
    private int random3 = getRandomNumber.getrandom3();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planing_child2);

        db =new MyDB(this);       // 建立 MyDB 物件
        db.open();

        btn_list1go = (Button) findViewById(R.id.btn_list1go);
        btn_list2go = (Button) findViewById(R.id.btn_list2go);
        btn_list3go = (Button) findViewById(R.id.btn_list3go);
        btn_change = (Button) findViewById(R.id.btn_change);

        TextView txtShow=(TextView)findViewById(R.id.text_title2);
        TextView txtShow1=(TextView)findViewById(R.id.text_list1);
        TextView txtShow2=(TextView)findViewById(R.id.text_list2);
        TextView txtShow3=(TextView)findViewById(R.id.text_list3);

        //隨機不重複行程
        txtShow1.setText("出發→\n" + db.get(random1).getString(1));
        txtShow2.setText(db.get(random1).getString(1) + "\n→\n" + db.get(random2).getString(1));
        txtShow3.setText(db.get(random2).getString(1) + "\n→\n" + db.get(random3).getString(1));

        btn_list1go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.google.com/maps/dir/" + getMAPActivity.get_x() + "," + getMAPActivity.get_y() + "/" + db.get(random1).getString(1) + "/data=!3m1!4b1!4m2!4m1!3e3");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btn_list2go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.google.com/maps/dir/" + db.get(random1).getString(1) + "/" + db.get(random2).getString(1) + "/data=!3m1!4b1!4m2!4m1!3e3");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        btn_list3go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.google.com/maps/dir/" + db.get(random2).getString(1) + "/" + db.get(random3).getString(1) + "/data=!3m1!4b1!4m2!4m1!3e3");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRandomNumber.setAllrandom();
                finish();
                Intent intent = new Intent(planingChild2Activity.this,planingChild2Activity.class);
                startActivity(intent);
            }
        });
    }
}

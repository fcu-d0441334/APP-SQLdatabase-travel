package com.kaiappgo.go;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class planingChild1Activity extends Activity {

    private Button btn_list1go;
    private Button btn_list2go;
    private Button btn_list3go;
    private Button btn_delete;

    ChildIntroductionActivity.chooselist testview = new ChildIntroductionActivity.chooselist();
    MapsActivity.getXY getMAPActivity = new MapsActivity.getXY();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planing_child1);

        btn_list1go = (Button) findViewById(R.id.btn_list1go);
        btn_list2go = (Button) findViewById(R.id.btn_list2go);
        btn_list3go = (Button) findViewById(R.id.btn_list3go);
        btn_delete = (Button) findViewById(R.id.btn_delete);

        TextView txtShow=(TextView)findViewById(R.id.text_title1);
        TextView txtShow1=(TextView)findViewById(R.id.text_list1);
        TextView txtShow2=(TextView)findViewById(R.id.text_list2);
        TextView txtShow3=(TextView)findViewById(R.id.text_list3);

        if(testview.getList1() != null) txtShow1.setText("出發→\n" + testview.getList1());
        else txtShow1.setText("尚未選取行程1!");
        if(testview.getList2() != null) txtShow2.setText(testview.getList1() + "\n→" + testview.getList2());
        else txtShow2.setText("尚未選取行程2!");
        if(testview.getList3() != null) txtShow3.setText(testview.getList2() + "\n→" + testview.getList3());
        else txtShow3.setText("尚未選取行程3!");

        btn_list1go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(testview.getList1() != null) {
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/" + getMAPActivity.get_x() + "," + getMAPActivity.get_y() + "/" + testview.getList1() + "/" + testview.getAddr1() + "/data=!3m1!4b1!4m2!4m1!3e3");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else {
                    Toast toast = Toast.makeText(planingChild1Activity.this,"尚未選取行程!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        btn_list2go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(testview.getList2() != null) {
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/" + testview.getList1() + "/" + testview.getList2() + "/" + testview.getAddr1() + "/data=!3m1!4b1!4m2!4m1!3e3");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else {
                    Toast toast = Toast.makeText(planingChild1Activity.this,"尚未選取行程!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        btn_list3go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(testview.getList3() != null) {
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/" + testview.getList2() + "/" + testview.getList3() + "/" + testview.getAddr2() + "/data=!3m1!4b1!4m2!4m1!3e3");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else {
                    Toast toast = Toast.makeText(planingChild1Activity.this,"尚未選取行程!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testview.setList1(null);
                testview.setList2(null);
                testview.setList3(null);
                testview.setAddr1(null);
                testview.setAddr2(null);
                testview.setAddr3(null);
                finish();
                Intent intent = new Intent(planingChild1Activity.this,planingChild1Activity.class);
                startActivity(intent);
            }
        });
    }

}

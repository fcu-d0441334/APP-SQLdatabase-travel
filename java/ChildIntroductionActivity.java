package com.kaiappgo.go;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ChildIntroductionActivity extends Activity {

    private Button btn_introChildA;
    private Button btn_introChildB;

    public static class chooselist {
        public static String list1;
        public static String list2;
        public static String list3;
        public static String addr1;
        public static String addr2;
        public static String addr3;

        public static String getList1() {
            return list1;
        }

        public static String getList2() {
            return list2;
        }

        public static String getList3() {
            return list3;
        }

        public static String getAddr1() {
            return addr1;
        }

        public static String getAddr2() {
            return addr2;
        }

        public static String getAddr3() {
            return addr3;
        }

        public void setList1(String list1) {
            this.list1 = list1;
        }

        public void setList2(String list2) {
            this.list2 = list2;
        }

        public void setList3(String list3) {
            this.list3 = list3;
        }

        public void setAddr1(String addr1) {
            this.addr1 = addr1;
        }

        public void setAddr2(String addr2) {
            this.addr2 = addr2;
        }

        public void setAddr3(String addr3) {
            this.addr3 = addr3;
        }
    }//get set 類別 存放name,addr數據
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_introduction);

        int[] imgId = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,
                R.drawable.img11,R.drawable.img12,R.drawable.img13,R.drawable.img14,R.drawable.img15,R.drawable.img16,R.drawable.img17,R.drawable.img18,R.drawable.img19,R.drawable.img20,
                R.drawable.img21,R.drawable.img22,R.drawable.img23,R.drawable.img24,R.drawable.img25,R.drawable.img26,R.drawable.img27,R.drawable.img28,R.drawable.img29,R.drawable.img30,
                R.drawable.img31,R.drawable.img32,R.drawable.img33,R.drawable.img34,R.drawable.img35,R.drawable.img36,R.drawable.img37,R.drawable.img38,R.drawable.img39,R.drawable.img40,
                R.drawable.img41,R.drawable.img42,R.drawable.img43,R.drawable.img44,R.drawable.img45,R.drawable.img46,R.drawable.img47,R.drawable.img48,R.drawable.img49,R.drawable.img50,
                R.drawable.img51,R.drawable.img52,R.drawable.img53,R.drawable.img54,R.drawable.img55,R.drawable.img56,R.drawable.img57,R.drawable.img58,R.drawable.img59,R.drawable.img60,
                R.drawable.img61,R.drawable.img62,R.drawable.img63,R.drawable.img64,R.drawable.img65,R.drawable.img66,R.drawable.img67,R.drawable.img68,R.drawable.img69,R.drawable.img70,
                R.drawable.img71,R.drawable.img72,R.drawable.img73,R.drawable.img74,R.drawable.img75,R.drawable.img76,R.drawable.img77,R.drawable.img78,R.drawable.img79,R.drawable.img80,
                R.drawable.img81,R.drawable.img82,R.drawable.img83,R.drawable.img84,R.drawable.img85,R.drawable.img86,R.drawable.img87,R.drawable.img88,R.drawable.img89,R.drawable.img90,
                R.drawable.img91,R.drawable.img92,R.drawable.img93,R.drawable.img94,R.drawable.img95,R.drawable.img96,R.drawable.img97,R.drawable.img98,R.drawable.img99,R.drawable.img100,};


        btn_introChildA = (Button) findViewById(R.id.btn_introChildA);
        btn_introChildB = (Button) findViewById(R.id.btn_introChildB);
        // 取得介面元件
        TextView txtShow=(TextView)findViewById(R.id.text_title);
        TextView txtShow2=(TextView)findViewById(R.id.text_B);
        ImageView imgPhoto = (ImageView)findViewById(R.id.imgPhoto);

        // 取得 bundle
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        final int     _id=bundle.getInt("_id");
        final String name=bundle.getString("name");
        final double addr1=bundle.getDouble("addr1");
        final double addr2=bundle.getDouble("addr2");
        final String context=bundle.getString("context");

        chooselist testview = new chooselist();/**//**/

        String title= name;
        txtShow.setText(title);
        String down= "介紹 : \n        " + context;
        txtShow2.setText(down);

        imgPhoto.setImageResource(imgId[(int)_id-1]);

        btn_introChildA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /* Intent intent = new Intent(ChildIntroductionActivity.this,MapsActivity2.class);
                startActivity(intent);//跳到旅遊規劃*/

                Intent intent=new Intent();
                intent.setClass(ChildIntroductionActivity.this,MapsActivity2.class);

                Bundle bundle=new Bundle();
                bundle.putString("Title", name);
                bundle.putDouble("addrfor1", addr1);
                bundle.putDouble("addrfor2", addr2);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btn_introChildB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooselist testview = new chooselist();
                if(testview.getList1() == null) {
                    testview.setList1(name);
                    testview.setAddr1("@" + addr1 + "," + addr2);
                    Toast toast = Toast.makeText(ChildIntroductionActivity.this,"已加入清單中!(1/3)",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(testview.getList2() == null) {
                    testview.setList2(name);
                    testview.setAddr2("@" + addr1 + "," + addr2);
                    Toast toast = Toast.makeText(ChildIntroductionActivity.this,"已加入清單中!(2/3)",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(testview.getList3() == null) {
                    testview.setList3(name);
                    testview.setAddr3("@" + addr1 + "," + addr2);
                    Toast toast = Toast.makeText(ChildIntroductionActivity.this,"已加入清單中!(3/3)",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Toast toast = Toast.makeText(ChildIntroductionActivity.this,"清單已滿!",Toast.LENGTH_SHORT);
                    toast.show();
                };
            }
        });
    }
}

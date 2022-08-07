package com.judai.asif;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AUinfo extends AppCompatActivity {
    TextView na,ca,ea,ea1,tif,as;
    ImageView  ia;
    ListView lsskill;
    ArrayList<Skills> aList;
    SkillAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auinfo);
        na = findViewById(R.id.namea);
        ca=findViewById(R.id.Classa);
        ea=findViewById(R.id.Elea);
        ea1=findViewById(R.id.Elea1);
        ia=findViewById(R.id.imga);
        tif=findViewById(R.id.tif);
        as=findViewById(R.id.astar);

        switch (aurorians.number){
            case 0:
                Intent intent = getIntent();
                int i= intent.getIntExtra("user", 0);
                na.setText(aurorians.arrayList.get(i).get_name());
                ca.setText(aurorians.arrayList.get(i).get_class());
                ea.setText(aurorians.arrayList.get(i).get_ele1());
                String cele = aurorians.arrayList.get(i).get_ele2();
                if(cele.equals("")==true)
                {
                    ea1.setText(aurorians.arrayList.get(i).get_ele2());
                }
                else
                {
                    String c = "/  ";
                    cele = c.concat(aurorians.arrayList.get(i).get_ele2());
                    ea1.setText(cele);
                }
                tif.setText(aurorians.arrayList.get(i).get_info());
                as.setText(aurorians.arrayList.get(i).get_star());
                ia.setImageBitmap(aurorians.arrayList.get(i).get_img());
                lsskill = findViewById(R.id.lskill);
                aList = new ArrayList<>();
                aList.add(new Skills(aurorians.arrayList.get(i).get_sk1(),aurorians.arrayList.get(i).get_img1()));
                aList.add(new Skills(aurorians.arrayList.get(i).get_sk2(),aurorians.arrayList.get(i).get_img2()));
                aList.add(new Skills(aurorians.arrayList.get(i).get_sk3(),aurorians.arrayList.get(i).get_img3()));
                adapter = new SkillAdapter(this,aList,R.layout.skill_row);
                break;
            case  1:
                Intent red = getIntent();
                int i1= red.getIntExtra("user", 0);
                na.setText(aurorians.redls.get(i1).get_name());
                ca.setText(aurorians.redls.get(i1).get_class());
                ea.setText(aurorians.redls.get(i1).get_ele1());
                String celer = aurorians.redls.get(i1).get_ele2();
                if(celer.equals(" ")==true)
                {
                    ea1.setText(aurorians.redls.get(i1).get_ele2());
                }
                else
                {
                    String c = "/  ";
                    celer = c.concat(aurorians.redls.get(i1).get_ele2());
                    ea1.setText(celer);
                }
                tif.setText(aurorians.redls.get(i1).get_info());
                as.setText(aurorians.redls.get(i1).get_star());
                ia.setImageBitmap(aurorians.redls.get(i1).get_img());
                lsskill = findViewById(R.id.lskill);
                aList = new ArrayList<>();
                aList.add(new Skills(aurorians.redls.get(i1).get_sk1(),aurorians.redls.get(i1).get_img1()));
                aList.add(new Skills(aurorians.redls.get(i1).get_sk2(),aurorians.redls.get(i1).get_img2()));
                aList.add(new Skills(aurorians.redls.get(i1).get_sk3(),aurorians.redls.get(i1).get_img3()));
                adapter = new SkillAdapter(this,aList,R.layout.skill_row);
                break;
            case 2:
                Intent blue = getIntent();
                int i2= blue.getIntExtra("user", 0);
                na.setText(aurorians.bluels.get(i2).get_name());
                ca.setText(aurorians.bluels.get(i2).get_class());
                ea.setText(aurorians.bluels.get(i2).get_ele1());
                String celeb = aurorians.bluels.get(i2).get_ele2();
                if(celeb.equals(" ")==true)
                {
                    ea1.setText(aurorians.bluels.get(i2).get_ele2());
                }
                else
                {
                    String c = "/  ";
                    celeb = c.concat(aurorians.bluels.get(i2).get_ele2());
                    ea1.setText(celeb);
                }
                tif.setText(aurorians.bluels.get(i2).get_info());
                as.setText(aurorians.bluels.get(i2).get_star());
                ia.setImageBitmap(aurorians.bluels.get(i2).get_img());
                lsskill = findViewById(R.id.lskill);
                aList = new ArrayList<>();
                aList.add(new Skills(aurorians.bluels.get(i2).get_sk1(),aurorians.bluels.get(i2).get_img1()));
                aList.add(new Skills(aurorians.bluels.get(i2).get_sk2(),aurorians.bluels.get(i2).get_img2()));
                aList.add(new Skills(aurorians.bluels.get(i2).get_sk3(),aurorians.bluels.get(i2).get_img3()));
                adapter = new SkillAdapter(this,aList,R.layout.skill_row);
                break;
            case 3:
                Intent green = getIntent();
                int i3= green.getIntExtra("user", 0);
                na.setText(aurorians.greenls.get(i3).get_name());
                ca.setText(aurorians.greenls.get(i3).get_class());
                ea.setText(aurorians.greenls.get(i3).get_ele1());
                String celeg = aurorians.greenls.get(i3).get_ele2();
                if(celeg.equals(" ")==true)
                {
                    ea1.setText(aurorians.greenls.get(i3).get_ele2());
                }
                else
                {
                    String c = "/  ";
                    celeg = c.concat(aurorians.greenls.get(i3).get_ele2());
                    ea1.setText(celeg);
                }
                tif.setText(aurorians.greenls.get(i3).get_info());
                as.setText(aurorians.greenls.get(i3).get_star());
                ia.setImageBitmap(aurorians.greenls.get(i3).get_img());
                lsskill = findViewById(R.id.lskill);
                aList = new ArrayList<>();
                aList.add(new Skills(aurorians.greenls.get(i3).get_sk1(),aurorians.greenls.get(i3).get_img1()));
                aList.add(new Skills(aurorians.greenls.get(i3).get_sk2(),aurorians.greenls.get(i3).get_img2()));
                aList.add(new Skills(aurorians.greenls.get(i3).get_sk3(),aurorians.greenls.get(i3).get_img3()));
                adapter = new SkillAdapter(this,aList,R.layout.skill_row);
                break;
            case 4:
                Intent yellow = getIntent();
                int i4= yellow.getIntExtra("user", 0);
                na.setText(aurorians.yellowls.get(i4).get_name());
                ca.setText(aurorians.yellowls.get(i4).get_class());
                ea.setText(aurorians.yellowls.get(i4).get_ele1());
                String celey = aurorians.yellowls.get(i4).get_ele2();
                if(celey.equals(" ")==true)
                {
                    ea1.setText(aurorians.yellowls.get(i4).get_ele2());
                }
                else
                {
                    String c = "/  ";
                    celey = c.concat(aurorians.yellowls.get(i4).get_ele2());
                    ea1.setText(celey);
                }
                tif.setText(aurorians.yellowls.get(i4).get_info());
                as.setText(aurorians.yellowls.get(i4).get_star());
                ia.setImageBitmap(aurorians.yellowls.get(i4).get_img());
                lsskill = findViewById(R.id.lskill);
                aList = new ArrayList<>();
                aList.add(new Skills(aurorians.yellowls.get(i4).get_sk1(),aurorians.yellowls.get(i4).get_img1()));
                aList.add(new Skills(aurorians.yellowls.get(i4).get_sk2(),aurorians.yellowls.get(i4).get_img2()));
                aList.add(new Skills(aurorians.yellowls.get(i4).get_sk3(),aurorians.yellowls.get(i4).get_img3()));
                adapter = new SkillAdapter(this,aList,R.layout.skill_row);
                break;

        }

        lsskill.setAdapter(adapter);



    }
}
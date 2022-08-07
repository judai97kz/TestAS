package com.judai.asif;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.judai.asif.ele.fireele;
import com.judai.asif.ele.forestele;
import com.judai.asif.ele.home;
import com.judai.asif.ele.thunderele;
import com.judai.asif.ele.waterele;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class aurorians extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Context context;
    private static final int fghome = 0;
    private static final int fgfire = 1;
    private static final int fgwater = 2;
    private static final int fgforest = 3;
    private static final int fgthunder = 4;

    private int mCu = fghome;

    private DrawerLayout drawerLayout;

    public static int number = 0;

    ListView lsau;
    public static ArrayList<AUs> arrayList;
    AuAdapter adapter;
    public static EditText editText;
    public static Button tim;

    String DB_NAME = "Aus.sqlite";
    private String DB_PATH = "/databases/";

    SQLiteDatabase database=null;

    public static ArrayList<AUs> redls;
    public static ArrayList<AUs> bluels;
    public static ArrayList<AUs> greenls;
    public static ArrayList<AUs> yellowls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aurorians);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        AnhXa();
        XulysaocheptuAssets();
        showData();
        Toast.makeText(this," "+arrayList.size(),Toast.LENGTH_LONG).show();
        editText = findViewById(R.id.etau);
        tim = findViewById(R.id.tim);
        tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenau = editText.getText().toString();
                char[] charArray = tenau.toCharArray();
                boolean foundSpace = true;
                for(int i = 0; i < charArray.length; i++) {
                    if(Character.isLetter(charArray[i])) {
                        if(foundSpace) {
                            charArray[i] = Character.toUpperCase(charArray[i]);
                            foundSpace = false;
                        }
                    }
                    else {
                        foundSpace = true;
                    }
                }
                // chuyển đổi mảng char thành string
                tenau = String.valueOf(charArray);
                locate(arrayList,tenau);
            }
        });
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.home)
        {
            if(mCu != fghome)
            {
                replacefragment(new home());
                mCu=fghome;
                number=fghome;
            }
        }else if (id == R.id.fire){
            if(mCu != fgfire)
            {
                replacefragment(new fireele());
                mCu=fgfire;
                number=fgfire;
            }
        }else if(id == R.id.water)
        {
            if(mCu != fgwater)
            {
                replacefragment(new waterele());
                mCu=fgwater;
                number=fgwater;
            }
        }else if(id == R.id.forest)
        {
            if(mCu != fgforest)
            {
                replacefragment(new forestele());
                mCu=fgforest;
                number=fgforest;
            }
        }else if(id == R.id.thunder) {
            if(mCu != fgthunder)
            {
                replacefragment(new thunderele());
                mCu=fgthunder;
                number=fgthunder;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        {
            super.onBackPressed();
        }
    }
    private void replacefragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame,fragment);
        fragmentTransaction.commit();
    }

    public void locate(ArrayList<AUs> arrayList , String target)
    {
        for(int i=0;i < arrayList.size();i++)
        {
            if(arrayList.get(i).get_name().equals(target)==true)
            {
                Intent intent = new Intent(aurorians.this,AUinfo.class);
                intent.putExtra("user",i);
                startActivity(intent);
                break;
            }
            if(i == arrayList.size() - 1 && arrayList.get(i).get_name().equals(target)==false)
            {
                Toast.makeText(aurorians.this,"Tên Aurorian không tồn tại ! Hãy nhập lại !",Toast.LENGTH_LONG).show();
            }
        }
    }
    private void AnhXa()
    {
        lsau = findViewById(R.id.lsau);
        arrayList = new ArrayList<>();
        adapter = new AuAdapter(this,arrayList,R.layout.au_row);
        lsau.setAdapter(adapter);


        lsau.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(aurorians.this,AUinfo.class);
                intent.putExtra("user",i);
                startActivity(intent);
            }
        });

    }

    private void showData() {
        database = openOrCreateDatabase(DB_NAME,MODE_PRIVATE,null);
        Cursor cursor=database.query("Aus",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            try {
                String _star = cursor.getString(0);
                String _name = cursor.getString(1);
                String _class = cursor.getString(2);
                String _ele1 = cursor.getString(3);
                String _ele2 = cursor.getString(4);
                Bitmap _ava = BitmapFactory.decodeByteArray(cursor.getBlob(5), 0, cursor.getBlob(5).length);
                String _sk1 = cursor.getString(6);
                String _sk2 = cursor.getString(7);
                String _sk3 = cursor.getString(8);
                Bitmap _isk1 = BitmapFactory.decodeByteArray(cursor.getBlob(9), 0, cursor.getBlob(9).length);
                Bitmap _isk2 = BitmapFactory.decodeByteArray(cursor.getBlob(10), 0, cursor.getBlob(10).length);
                Bitmap _isk3 = BitmapFactory.decodeByteArray(cursor.getBlob(11), 0, cursor.getBlob(11).length);
                String _info = cursor.getString(12);
                AUs a1 = new AUs(_star, _name, _class, _ele1, _ele2, _ava, _sk1, _sk2, _sk3, _isk1, _isk2, _isk3, _info);
                arrayList.add(a1);
            }catch (Exception e){
                Log.e("Lỗi đây",e.toString());
            }
        }
        cursor.close();
        Collections.sort(arrayList, new Comparator<AUs>() {
            @Override
            public int compare(AUs sv1, AUs sv2) {
                return (sv1.get_name().compareTo(sv2.get_name()));
                // Muốn đảo danh sách các bạn đối thành
                //return (sv2.hoTen.compareTo(sv1.hoTen));
            }
        });
        adapter.notifyDataSetChanged();

        gan();
    }

    private void XulysaocheptuAssets() {
        File dbfile =getDatabasePath(DB_NAME);
        if(!dbfile.exists()){
            copyDatabase();
        }else{
            dbfile.delete();
            copyDatabase();
        }
    }

    private void copyDatabase() {
        try{
            InputStream myInput = getAssets().open(DB_NAME);
            String outFileName = getApplicationInfo().dataDir+DB_PATH+DB_NAME;
            File f = new File(getApplicationInfo().dataDir+DB_PATH);
            if(!f.mkdir()){
                f.mkdir();
            }
            OutputStream myOutPut = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int len;
            while((len=myInput.read(buffer))>0){
                myOutPut.write(buffer,0,len);
            }
            myOutPut.flush();
            myInput.close();
            myOutPut.close();
        }catch (Exception e){
            e.printStackTrace();
            Log.e("Lỗi sao chép",e.toString());
        }
    }

    private void gan(){
        redls = new ArrayList<>();
        bluels = new ArrayList<>();
        greenls = new ArrayList<>();
        yellowls = new ArrayList<>();
        for (int i=0;i<arrayList.size();i++)
        {
            if(arrayList.get(i).get_ele1().equals("Lửa")==true) {
                redls.add(arrayList.get(i));
                adapter.notifyDataSetChanged();
            }
            if(arrayList.get(i).get_ele1().equals("Nước")==true) {
                bluels.add(arrayList.get(i));
                adapter.notifyDataSetChanged();
            }
            if(arrayList.get(i).get_ele1().equals("Rừng")==true) {
                greenls.add(arrayList.get(i));
                adapter.notifyDataSetChanged();
            }
            if(arrayList.get(i).get_ele1().equals("Điện")==true){
                yellowls.add(arrayList.get(i));
                adapter.notifyDataSetChanged();}
        }
    }
}
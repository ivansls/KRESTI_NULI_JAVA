package com.example.praka12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    SharedPreferences settings;
    SharedPreferences.Editor editor;
    ImageButton btn;


    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;
    ImageButton btn4;
    ImageButton btn5;
    ImageButton btn6;
    ImageButton btn7;
    ImageButton btn8;
    ImageButton btn9;



    Boolean bt1;
    Boolean bt2;
    Boolean bt3;
    Boolean bt4;
    Boolean bt5;
    Boolean bt6;
    Boolean bt7;
    Boolean bt8;
    Boolean bt9;

    boolean start;

    String krest[][] = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
    String znak, znak1;
    int r1, r2;

    TextView you;
    TextView robot;
    TextView nikto;


    int y;
    int r;
    int n;


    int count;

    SharedPreferences statistic;

    Boolean win = false;

    Button StartBTN;


    String Save_you = "save_you";
    String Save_rob = "save_rob";
    String Save_nik = "save_nik";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        settings = getSharedPreferences("settings", MODE_PRIVATE);
        editor = settings.edit();
        if (!settings.contains("save_you")){
            editor.putString("save_you", "0");
        }

        if (!settings.contains(Save_rob)){
            editor.putString(Save_rob, "0");
        }

        if (!settings.contains(Save_nik)){
            editor.putString(Save_nik, "0");
        }
        editor.apply();
//        if (statistic.contains(Save_you)){
//            statistic = getPreferences(MODE_PRIVATE);
//            String txt = statistic.getString(Save_you, "");
//            String txt1 = statistic.getString(Save_rob, "");
//            String txt2 = statistic.getString(Save_nik, "");
//            you.setText("ВЫ: " + txt);
//            robot.setText("РОБОТ: " + txt1);
//            nikto.setText("НИЧЬИ: "+txt2);
//        }



        settings = getSharedPreferences("settings", MODE_PRIVATE);
        if(settings.contains("MODE_NIGHT_ON")){
            SetCurrentTheme();
        }else {
            editor = settings.edit();
            editor.putBoolean("MODE_NIGHT_ON", false);
            editor.apply();
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            Toast.makeText(this, "HELLO", Toast.LENGTH_SHORT).show();
        }
        setContentView(R.layout.activity_main);

        you = findViewById(R.id.you_win);
        robot = findViewById(R.id.robot_win);
        nikto = findViewById(R.id.nicro_win);


        y = Integer.parseInt(settings.getString(Save_you, "0"));
        r = Integer.parseInt(settings.getString(Save_rob, "0"));
        n = Integer.parseInt(settings.getString(Save_nik, "0"));

        you.setText("ВЫ: " + settings.getString(Save_you, ""));
        robot.setText("РОБОТ: " + settings.getString(Save_rob, ""), TextView.BufferType.EDITABLE);
        nikto.setText("НИЧЬИ: " + settings.getString(Save_nik, ""), TextView.BufferType.EDITABLE);




        btn = findViewById(R.id.themeCH);
        if (settings.getBoolean("MODE_NIGHT_ON", false)){
            btn.setImageResource(R.drawable.ic_day);
        }else {
            btn.setImageResource(R.drawable.ic_night);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor = settings.edit();

                if (settings.getBoolean("MODE_NIGHT_ON", false)){
                    editor.putBoolean("MODE_NIGHT_ON", false);
                }else {
                    editor.putBoolean("MODE_NIGHT_ON", true);
                }
                editor.apply();
                Intent intent = getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                startActivity(intent);
            }
        });

        StartBTN = findViewById(R.id.start);


        StartBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);


                btn1.setImageResource(0);
                btn2.setImageResource(0);
                btn3.setImageResource(0);
                btn4.setImageResource(0);
                btn5.setImageResource(0);
                btn6.setImageResource(0);
                btn7.setImageResource(0);
                btn8.setImageResource(0);
                btn9.setImageResource(0);

                count = 0;

                win = false;

                for (int i = 0; i <  krest.length; i++){
                    for (int j = 0; j < krest[i].length; j++){
                        krest[i][j] = "";
                    }
                }

            }
        });



        btn1 = findViewById(R.id.one_btn);
        btn2 = findViewById(R.id.two_btn);
        btn3 = findViewById(R.id.three_btn);

        btn4 = findViewById(R.id.thou_btn);
        btn5 = findViewById(R.id.five_btn);
        btn6 = findViewById(R.id.six_btn);

        btn7 = findViewById(R.id.seven_btn);
        btn8 = findViewById(R.id.eight_btn);
        btn9 = findViewById(R.id.nine_btn);

        znak = String.valueOf(getResources().getIdentifier("close", "drawable", getPackageName()));
        znak1 = String.valueOf(getResources().getIdentifier("nolik", "drawable", getPackageName()));


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k1(view);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                k2(view);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                k3(view);
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k4(view);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k5(view);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k6(view);
            }
        });



        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k7(view);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k8(view);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k9(view);
            }
        });

    }

    public void k1(View v){
        count++;
        krest[0][1]=znak;
        btn1.setImageResource(Integer.parseInt(znak));
        btn1.setEnabled(false);
        proverka();
        robot();
    }

    public void k2(View v){
        count++;
        krest[1][1]=znak;
        //Toast.makeText(this, String.valueOf(getResources().getIdentifier("nolik", "drawable", getPackageName())), Toast.LENGTH_SHORT).show();
        btn2.setImageResource(Integer.parseInt(znak));
        btn2.setEnabled(false);
        proverka();
        robot();
    }

    public void k3(View v){
        count++;
        krest[2][1]=znak;
        btn3.setImageResource(Integer.parseInt(znak));
        btn3.setEnabled(false);
        proverka();
        robot();
    }


    public void k4(View v){
        count++;
        krest[0][0]=znak;
        btn4.setImageResource(Integer.parseInt(znak));
        btn4.setEnabled(false);
        proverka();
        robot();
    }

    public void k5(View v){
        count++;
        krest[1][0]=znak;
        btn5.setImageResource(Integer.parseInt(znak));
        btn5.setEnabled(false);
        proverka();
        robot();
    }

    public void k6(View v){
        count++;
        krest[2][0]=znak;
        btn6.setImageResource(Integer.parseInt(znak));
        btn6.setEnabled(false);
        proverka();
        robot();
    }


    public void k7(View v){
        count++;
        krest[0][2]=znak;
        btn7.setImageResource(Integer.parseInt(znak));
        btn7.setEnabled(false);
        proverka();
        robot();
    }

    public void k8(View v){
        count++;
        krest[1][2]=znak;
        btn8.setImageResource(Integer.parseInt(znak));
        btn8.setEnabled(false);
        proverka();
        robot();
    }

    public void k9(View v){
        count++;
        krest[2][2]=znak;
        btn9.setImageResource(Integer.parseInt(znak));
        btn9.setEnabled(false);
        proverka();
        robot();
    }






    public void random_c(){
        r1 = (int)(0+Math.random()*3);
        r2 = (int)(0+Math.random()*3);
    }
    public void robot(){
        if (!win){
            random_c();
//            for (int i = 0; i < krest.length; i++){
//                for (int j = 0; j < krest[i].length; j++){
//                    if (krest[r1][r2].equals(znak)||krest[r1][r2].equals(znak1)){
//                        random_c();
//                    }
//                    else{
//                        krest[r1][r2]=znak1;
//                        break;
//                    }
//                }
//            }


            if (krest[r1][r2].equals(znak)||krest[r1][r2].equals(znak1)){
                random_c();
                if (krest[r1][r2].equals(znak)||krest[r1][r2].equals(znak1)){
                    random_c();
                    if (krest[r1][r2].equals(znak)||krest[r1][r2].equals(znak1)){
                        random_c();
                        if (krest[r1][r2].equals(znak)||krest[r1][r2].equals(znak1)){
                            random_c();
                            if (krest[r1][r2].equals(znak)||krest[r1][r2].equals(znak1)){
                                random_c();
                                if (krest[r1][r2].equals(znak)||krest[r1][r2].equals(znak1)){
                                    random_c();
                                    if (krest[r1][r2].equals(znak)||krest[r1][r2].equals(znak1)){
                                        random_c();
                                        if (krest[r1][r2].equals(znak)||krest[r1][r2].equals(znak1)){
                                            random_c();
                                            if (krest[r1][r2].equals(znak)||krest[r1][r2].equals(znak1)){
                                                random_c();
                                            }
                                            else{
                                                krest[r1][r2]=znak1;
                                            }
                                        }
                                        else{
                                            krest[r1][r2]=znak1;
                                        }
                                    }
                                    else{
                                        krest[r1][r2]=znak1;
                                    }
                                }
                                else{
                                    krest[r1][r2]=znak1;
                                }
                            }
                            else{
                                krest[r1][r2]=znak1;
                            }
                        }
                        else{
                            krest[r1][r2]=znak1;
                        }
                    }
                    else{
                        krest[r1][r2]=znak1;
                    }
                }
                else{
                    krest[r1][r2]=znak1;
                }
            }
            else {
                krest[r1][r2]=znak1;
            }
            count++;
            proverka();
            smotr();
            onStart();
        }

    }


    public void smotr(){
        try{
            btn1.setImageResource(Integer.parseInt(krest[0][1]));
            btn1.setEnabled(false);
        }catch (Exception e){}

        try {
            btn2.setImageResource(Integer.parseInt(krest[1][1]));
            btn2.setEnabled(false);
        }catch (Exception e){}

        try {
            btn3.setImageResource(Integer.parseInt(krest[2][1]));
            btn3.setEnabled(false);
        }catch (Exception e){}

        try {
            btn4.setImageResource(Integer.parseInt(krest[0][0]));
            btn4.setEnabled(false);
        }catch (Exception e){}

        try {
            btn5.setImageResource(Integer.parseInt(krest[1][0]));
            btn5.setEnabled(false);
        }catch (Exception e){}

        try {
            btn6.setImageResource(Integer.parseInt(krest[2][0]));
            btn6.setEnabled(false);
        }catch (Exception e){}

        try {
            btn7.setImageResource(Integer.parseInt(krest[0][2]));
            btn7.setEnabled(false);
        }catch (Exception e){}

        try {
            btn8.setImageResource(Integer.parseInt(krest[1][2]));
            btn8.setEnabled(false);
        }catch (Exception e){}

        try {
            btn9.setImageResource(Integer.parseInt(krest[2][2]));
            btn9.setEnabled(false);
        }catch (Exception e){}
    }


    public void proverka(){

        if ((krest[0][1].equals(znak)) && (krest[1][1].equals(znak)) && krest[2][1].equals(znak)) {
            win = true;
            Toast.makeText(this, "YOU WIN", Toast.LENGTH_SHORT).show();
            y++;


            SaveStat(Save_you, Integer.toString(y));
            return;
        } else if ((krest[0][1].equals(znak)) && (krest[0][0].equals(znak)) && krest[0][2].equals(znak)) {
            win = true;
            Toast.makeText(this, "YOU WIN", Toast.LENGTH_SHORT).show();
            y++;

            SaveStat(Save_you, Integer.toString(y));
            return;
        } else if ((krest[0][0].equals(znak)) && (krest[1][0].equals(znak)) && krest[2][0].equals(znak)) {
            win = true;
            Toast.makeText(this, "YOU WIN", Toast.LENGTH_SHORT).show();
            y++;

            SaveStat(Save_you, Integer.toString(y));
            return;
        } else if ((krest[0][2].equals(znak)) && (krest[1][2].equals(znak)) && krest[2][2].equals(znak)) {
            win = true;
            Toast.makeText(this, "YOU WIN", Toast.LENGTH_SHORT).show();
            y++;
            SaveStat(Save_you, Integer.toString(y));
            return;
        } else if ((krest[1][0].equals(znak)) && (krest[1][1].equals(znak)) && krest[1][2].equals(znak)) {
            win = true;
            Toast.makeText(this, "YOU WIN", Toast.LENGTH_SHORT).show();
            y++;

            SaveStat(Save_you, Integer.toString(y));
            return;
        } else if ((krest[2][0].equals(znak)) && (krest[2][1].equals(znak)) && krest[2][2].equals(znak)) {
            win = true;
            Toast.makeText(this, "YOU WIN", Toast.LENGTH_SHORT).show();
            y++;
            SaveStat(Save_you, Integer.toString(y));
            return;
        } else if ((krest[0][0].equals(znak)) && (krest[1][1].equals(znak)) && krest[2][2].equals(znak)) {
            win = true;
            Toast.makeText(this, "YOU WIN", Toast.LENGTH_SHORT).show();
            y++;
            SaveStat(Save_you, Integer.toString(y));
            return;
        } else if ((krest[0][2].equals(znak)) && (krest[1][1].equals(znak)) && krest[2][0].equals(znak)) {
            win = true;
            Toast.makeText(this, "YOU WIN", Toast.LENGTH_SHORT).show();
            y++;
            SaveStat(Save_you, Integer.toString(y));
            return;
        }


        //robot


        else if ((krest[0][1].equals(znak1)) && (krest[1][1].equals(znak1)) && krest[2][1].equals(znak1)) {
            win = true;
            Toast.makeText(this, "ROBOT WIN", Toast.LENGTH_SHORT).show();
            r++;

            SaveStat(Save_rob, Integer.toString(r));
            return;
        } else if ((krest[0][1].equals(znak1)) && (krest[0][0].equals(znak1)) && krest[0][2].equals(znak1)) {
            win = true;
            Toast.makeText(this, "ROBOT WIN", Toast.LENGTH_SHORT).show();
            r++;

            SaveStat(Save_rob, Integer.toString(r));
            return;
        } else if ((krest[0][0].equals(znak1)) && (krest[1][0].equals(znak1)) && krest[2][0].equals(znak1)) {
            win = true;
            Toast.makeText(this, "ROBOT WIN", Toast.LENGTH_SHORT).show();
            r++;

            SaveStat(Save_rob, Integer.toString(r));
            return;
        } else if ((krest[0][2].equals(znak1)) && (krest[1][2].equals(znak1)) && krest[2][2].equals(znak1)) {
            win = true;
            Toast.makeText(this, "ROBOT WIN", Toast.LENGTH_SHORT).show();
            r++;

            SaveStat(Save_rob, Integer.toString(r));
            return;
        } else if ((krest[1][0].equals(znak1)) && (krest[1][1].equals(znak1)) && krest[1][2].equals(znak1)) {
            win = true;
            Toast.makeText(this, "ROBOT WIN", Toast.LENGTH_SHORT).show();
            r++;

            SaveStat(Save_rob, Integer.toString(r));
            return;
        } else if ((krest[2][0].equals(znak1)) && (krest[2][1].equals(znak1)) && krest[2][2].equals(znak1)) {
            win = true;
            Toast.makeText(this, "ROBOT WIN", Toast.LENGTH_SHORT).show();
            r++;

            SaveStat(Save_rob, Integer.toString(r));
            return;
        } else if ((krest[0][0].equals(znak1)) && (krest[1][1].equals(znak1)) && krest[2][2].equals(znak1)) {
            win = true;
            Toast.makeText(this, "ROBOT WIN", Toast.LENGTH_SHORT).show();
            r++;

            SaveStat(Save_rob, Integer.toString(r));
            return;
        } else if ((krest[0][2].equals(znak1)) && (krest[1][1].equals(znak1)) && krest[2][0].equals(znak1)) {
            win = true;
            Toast.makeText(this, "ROBOT WIN", Toast.LENGTH_SHORT).show();
            r++;

            SaveStat(Save_rob, Integer.toString(r));
            return;
        }


        if (count == 9){
            n++;
            Toast.makeText(this, "NICTO WIN", Toast.LENGTH_SHORT).show();

            SaveStat(Save_nik, Integer.toString(n));
        }




    }


    private void SetCurrentTheme() {
        if(settings.getBoolean("MODE_NIGHT_ON", false)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    private void SaveStat(String key,String st){
        editor = settings.edit();
        editor.putString(key, st);
        editor.apply();
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        startActivity(intent);
    }
}
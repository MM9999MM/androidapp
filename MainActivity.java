package com.example.testprepare_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.view.ContextMenu;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    RadioButton rad1, rad2, rad3, rad4;
    RadioGroup radG;
    Button btnshow;
    ImageView daehwaImage;
    View daehwaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rad1 = (RadioButton) findViewById(R.id.rad1);
        rad2 = (RadioButton) findViewById(R.id.rad2);
        rad3 = (RadioButton) findViewById(R.id.rad3);
        rad4 = (RadioButton) findViewById(R.id.rad4);
        radG = (RadioGroup) findViewById(R.id.radG);
        btnshow = (Button) findViewById(R.id.btnshow);

        daehwaView = (View) View.inflate(MainActivity.this, R.layout.daehwa1, null);
        daehwaImage = (ImageView) daehwaView.findViewById(R.id.daehwaImage);


        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
        dlg.setTitle("제목");
        dlg.setMessage("내용");

        //가정
        //switch문의 getCheckerRadioButtonID에서 오류 -> 잘못 없음
        //daehwaView의 ImageView의 src바꾸려하는데에서 오류 -> xml파일의 ImageView에 접근 방식은 잘못 없는것 같음
        //대화상자에 뷰를 적용하니까 show()두번째로 콜 했을때 앱 크래시
        
        //switch - getCheckerRadioButton -> no bug
        //daehwaView-ImageView-src change -> no bug
        //CRASHES when calling dialog 2nd times after applying view to the dialog -> dlg.show();
        dlg.setView(daehwaView);

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (radG.getCheckedRadioButtonId()) {
                    case R.id.rad1:
                        daehwaImage.setImageResource(R.drawable.blue);
                        break;
                    case R.id.rad2:
                        daehwaImage.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rad3:
                        daehwaImage.setImageResource(R.drawable.purple);
                        break;
                    case R.id.rad4:
                        daehwaImage.setImageResource(R.drawable.slogan);
                        break;
                    default:
                        break;
                }


                dlg.show();

            }

        });


    }
}

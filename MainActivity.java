package com.blackapp.mobileteh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static String Log;
    public static String Pass;
    public static Intent HomePage;


    Button loginBtn;
    EditText loginTxt;
    EditText passwordTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readDate();


        loginTxt = (EditText) findViewById(R.id.loginText);
        passwordTxt = (EditText) findViewById(R.id.passwordText);

        loginBtn = (Button) findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(this);


        //ImageView mainImg = (ImageView) findViewById(R.id.primari_img);
        //mainImg.setImageResource(R.drawable.vhod_v2);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.loginButton:
               // if (loginTxt.getText().toString().equals(R.string.admin)) {
                    Intent intent = new Intent(this, ActivityPrimary.class);
                    HomePage = intent;
                    startActivity(intent);
                //}
               // else
               //     Toast.makeText(MainActivity.this,"Неверный логин или пароль!", Toast.LENGTH_SHORT).show();
               // System.out.println(loginTxt.getText());
                break;
            default:
                break;

        }
    }

    void readDate() {
        try {
            InputStream is = getResources().openRawResource(R.raw.text);
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader buffer = new BufferedReader(reader);
            Log = buffer.readLine();
            Pass = buffer.readLine();
            is.close();
            Toast.makeText(MainActivity.this, "Выполнено последнее сохранение", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

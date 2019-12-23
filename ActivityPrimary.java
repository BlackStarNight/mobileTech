package com.blackapp.mobileteh;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class ActivityPrimary extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    Button pillsBtn;
    Button setingBtn;
    Button exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary);


        pillsBtn = (Button) findViewById(R.id.pilsButton);
        setingBtn = (Button) findViewById(R.id.setingButton);
        exitBtn = (Button) findViewById(R.id.exitButton);
        pillsBtn.setOnClickListener(this);
        setingBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pilsButton:
                intent = new Intent(this, ActivityTable.class);
                startActivity(intent);
                break;
            case R.id.exitButton:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}

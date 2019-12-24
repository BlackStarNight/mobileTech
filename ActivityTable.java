package com.blackapp.mobileteh;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class ActivityTable extends AppCompatActivity implements View.OnClickListener {

    private int Colum = 1;
    public SQLiteDatabase database;
    EditText DateText, NameText;
    Button NextButton, AddButton, LastButton, DeleteButton;
    TextView[] Id = new TextView[6];
    TextView[] Name = new TextView[6];
    TextView[] Date = new TextView[6];

    DBhelper dBhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        fillingOut();
        DateText = (EditText) findViewById(R.id.dateText);
        NameText = (EditText) findViewById(R.id.nameText);
        NextButton = (Button) findViewById(R.id.nextButton);
        AddButton = (Button) findViewById(R.id.addButton);
        LastButton = (Button) findViewById(R.id.lastButton);
        DeleteButton = (Button) findViewById(R.id.delete);
        NextButton.setOnClickListener(this);
        LastButton.setOnClickListener(this);
        AddButton.setOnClickListener(this);
        DeleteButton.setOnClickListener(this);
        dBhelper = new DBhelper(this);
        database = dBhelper.getWritableDatabase();
        readDb();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.addButton:
                String name = NameText.getText().toString();
                String date = DateText.getText().toString();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBhelper.KEY_NAME, name);
                contentValues.put(DBhelper.KEY_DATE, date);
                database.insert(DBhelper.TABLE_CONTACTS, null, contentValues);
                readDb();
                break;
            case R.id.nextButton:
                Colum++;
                readDb();
                break;
            case R.id.lastButton:
                if (Colum>1){Colum--;}else break;
                readDb();
                break;
            case R.id.delete:
                database.delete(DBhelper.TABLE_CONTACTS, null, null);
                readDb();
                break;
        }

    }

    private int getCursor(){
        return Colum*6-5;
    }


    public void readDb(){
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);

        if (cursor.move(getCursor())){
            int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(DBhelper.KEY_NAME);
            int dataIndex = cursor.getColumnIndex(DBhelper.KEY_DATE);
            int j = 0;
            do {
                Id[j].setText(String.valueOf(cursor.getInt(idIndex)));
                Name[j].setText(cursor.getString(nameIndex));
                Date[j].setText(cursor.getString(dataIndex));
                j++;
            }while (j < 6 && cursor.moveToNext());
            if (j != 5){
                for (;j<6;j++){
                    Id[j].setText("");
                    Name[j].setText("");
                    Date[j].setText("");
                }
            }

        }
        else {
            for (int i =0;i<6;i++){
                Id[i].setText("");
                Name[i].setText("");
                Date[i].setText("");
            }
        }

        cursor.close();
    }

    public void fillingOut(){
        Id[0] = (TextView) findViewById(R.id.id1);
        Id[1] = (TextView) findViewById(R.id.id2);
        Id[2] = (TextView) findViewById(R.id.id3);
        Id[3] = (TextView) findViewById(R.id.id4);
        Id[4] = (TextView) findViewById(R.id.id5);
        Id[5] = (TextView) findViewById(R.id.id6);


        Name[0] = (TextView) findViewById(R.id.name1);
        Name[1] = (TextView) findViewById(R.id.name2);
        Name[2] = (TextView) findViewById(R.id.name3);
        Name[3] = (TextView) findViewById(R.id.name4);
        Name[4] = (TextView) findViewById(R.id.name5);
        Name[5] = (TextView) findViewById(R.id.name6);


        Date[0] = (TextView) findViewById(R.id.data1);
        Date[1] = (TextView) findViewById(R.id.data2);
        Date[2] = (TextView) findViewById(R.id.data3);
        Date[3] = (TextView) findViewById(R.id.data4);
        Date[4] = (TextView) findViewById(R.id.data5);
        Date[5] = (TextView) findViewById(R.id.data6);
    }
}

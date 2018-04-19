package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText nazwaInput, bialkoInput, weglowodanyInput, tluszczeInput, kcalInput;
    Button potwierdz, viewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        myDb = new DatabaseHelper(this);

        nazwaInput =  findViewById(R.id.nazwaInput);
        bialkoInput =  findViewById(R.id.bialkoInput);
        weglowodanyInput =  findViewById(R.id.weglowodanyInput);
        tluszczeInput =  findViewById(R.id.tluszczeInput);
        kcalInput =  findViewById(R.id.kcalInput);
        potwierdz = (Button) findViewById(R.id.buttonPotw);
        viewAll = (Button) findViewById(R.id.buttonV);
        AddData();


    }


        public void AddData(){

            potwierdz.setOnClickListener(
                    new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {

                            /*String nazwa = nazwaInput.getText().toString();
                            Float bialko = Float.valueOf(bialkoInput.getText().toString());
                            Float weglowodany = Float.valueOf(weglowodanyInput.getText().toString());
                            Float tluszcze = Float.valueOf(tluszczeInput.getText().toString());
                            Float wartoscEn = Float.valueOf(kcalInput.getText().toString() );*/

                            boolean isInserted = myDb.insertData(nazwaInput.getText().toString(),
                                    bialkoInput.getText().toString(),
                                    weglowodanyInput.getText().toString(),
                                    tluszczeInput.getText().toString(),
                                    kcalInput.getText().toString() );
                            if (isInserted = true)
                                Toast.makeText(Activity2.this, "Data Inserted",Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(Activity2.this, "Data Not Inserted",Toast.LENGTH_LONG).show();
                        }
                    });

    }



}


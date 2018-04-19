package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button bt1 = (Button) findViewById(R.id.button1);
        Button bt2_dodajProdukt = (Button) findViewById(R.id.button2);

        bt1.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView textView = (TextView) findViewById(R.id.textView1);
                        textView.setText("krotki");
                    }
                });

        bt1.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        TextView textView = (TextView) findViewById(R.id.textView1);
                        textView.setText("dlugi");
                        return true;
                    }
                });

        bt2_dodajProdukt.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        openActivity2();
                    }
                });
        }
        public void openActivity2() {
             Intent i = new Intent(this, Activity2.class);
             startActivity(i);
        }
    }


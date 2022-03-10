package com.techinee.midterm_6206021621066;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnGpa , btnTax , btnShow , btnAbout , btnQuit ;
    private int id;
    LayoutInflater layoutInflater;
    View toastLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGpa = (Button) findViewById(R.id.btnGpa);
        btnTax = (Button) findViewById(R.id.btnTax);
        btnShow = (Button) findViewById(R.id.btnShow);
        btnAbout = (Button) findViewById(R.id.btnAbout);
        btnQuit = (Button) findViewById(R.id.btnQuit);

        btnGpa.setOnClickListener(this);
        btnTax.setOnClickListener(this);
        btnShow.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnQuit.setOnClickListener(this);

        layoutInflater = getLayoutInflater();
        toastLayout = layoutInflater.inflate(R.layout.activity_about, (ViewGroup) findViewById(R.id.meAbout));

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btnGpa){
            startGpa();
        }
        else if (id == R.id.btnTax) {
            startTax();
        }
        else if (id == R.id.btnShow) {
            startShow();
        }
        else if (id == R.id.btnAbout) {
            Toast toastCustom;
            toastCustom = Toast.makeText(this, "Custom", Toast.LENGTH_LONG);
            toastCustom.setGravity(Gravity.CENTER, 0, 0);
            toastCustom.setView( toastLayout );
            toastCustom.show();
            startAbout();
        }
        else if (id == R.id.btnQuit) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle("Exit");
            builder.setMessage("Are you sure you want to leave ?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    finish();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.dismiss();
                }
            });
            builder.create().show();

        }

    }
    public void startGpa(){
        Intent launchGpa = new Intent(MainActivity.this,GpaActivity.class);
        startActivity(launchGpa);
    }
    public void startTax(){
        Intent launchTax = new Intent(MainActivity.this,TaxActivity.class);
        startActivity(launchTax);
    }
    public void startShow(){
        Intent launchShow = new Intent(MainActivity.this,ShowActivity.class);
        startActivity(launchShow);
    }
    public void startAbout(){
        Intent launchAbout = new Intent(MainActivity.this,AboutActivity.class);
        startActivity(launchAbout);
    }

    }


package com.techinee.midterm_6206021621066;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class GpaActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText Grade1 , Grade2 , Grade3 , Grade4 , Grade5 ;
    private Button btnCal , btnBackGPA;
    private TextView Result;
    double point1, point2, point3, point4 , point5 ,credit = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);

        Grade1 = (EditText) findViewById(R.id.Grade1);
        Grade2 = (EditText) findViewById(R.id.Grade2);
        Grade3 = (EditText) findViewById(R.id.Grade3);
        Grade4 = (EditText) findViewById(R.id.Grade4);
        Grade5 = (EditText) findViewById(R.id.Grade5);

        btnCal = (Button) findViewById(R.id.btnCal);
        btnCal.setOnClickListener(this);
        btnBackGPA = (Button) findViewById(R.id.btnBackGPA);
        btnBackGPA.setOnClickListener(this);

        Result = (TextView) findViewById(R.id.Result);



    }

    @Override
    public void onClick(View v){
        String EditToString1 = Grade1.getText().toString();
        String EditToString2 = Grade2.getText().toString();
        String EditToString3 = Grade3.getText().toString();
        String EditToString4 = Grade4.getText().toString();
        String EditToString5 = Grade5.getText().toString();
        int id = v.getId();
        if (id == R.id.btnBackGPA){
            Toast.makeText(GpaActivity.this, "Exit Grade", Toast.LENGTH_SHORT).show();
            finish();
        }

        if (EditToString1.equals("")){
            Toast.makeText(this , "กรุณากรอกข้อมูล" , Toast.LENGTH_SHORT).show();
            return;
        }
        else if (EditToString2.equals("")){
            Toast.makeText(this , "กรุณากรอกข้อมูล" , Toast.LENGTH_SHORT).show();
            return;
        }
        else if (EditToString3.equals("")){
            Toast.makeText(this , "กรุณากรอกข้อมูล" , Toast.LENGTH_SHORT).show();
            return;
        }
        else if (EditToString4.equals("")){
            Toast.makeText(this , "กรุณากรอกข้อมูล" , Toast.LENGTH_SHORT).show();
            return;
        }
        else if (EditToString5.equals("")){
            Toast.makeText(this , "กรุณากรอกข้อมูล" , Toast.LENGTH_SHORT).show();
            return;
        }
        else if (id == R.id.btnCal){
            credit = 0;

            point1 = calPoints(Grade1);
            point2 = calPoints(Grade2);
            point3 = calPoints(Grade3);
            point4 = calPoints(Grade4);
            point5 = calPoints(Grade5);

            double totalPoint = point1 + point2 + point3 + point4 + point5;
            double totalGpa   = totalPoint / credit;
            DecimalFormat decFormat = new DecimalFormat("##.00");
            if(totalGpa < 1.25 ){
                Result.setText("Points : " + decFormat.format(totalPoint)
                        + "\nCredits : " + decFormat.format(credit)
                        + "\nGPA : " + decFormat.format(totalGpa)
                        + "\nStatus : Retire");
                Result.setBackgroundColor(Color.RED);
            }
            else if (totalGpa >= 1.25 && totalGpa <= 1.99){
                Result.setText("Points : " + decFormat.format(totalPoint)
                        + "\nCredits : " + decFormat.format(credit)
                        + "\nGPA : " + decFormat.format(totalGpa)
                        + "\nStatus : Probation");
                Result.setBackgroundColor(Color.YELLOW);
            }
            else if (totalGpa >= 2.00 && totalGpa <=4.00 ){
                Result.setText("Points : " + decFormat.format(totalPoint)
                        + "\nCredits : " + decFormat.format(credit)
                        + "\nGPA : " + decFormat.format(totalGpa)
                        + "\nStatus : Normal");
                Result.setBackgroundColor(Color.GREEN);
            }

        }
    }

    public double calPoints(EditText input){
        String GPA = input.getText().toString();
        double point = 0;

        if (GPA.equals("A")) {
            point = 4.0 *3 ;
            credit += 3;
        }
        else if (GPA.equals("B+")) {
            point = 3.5 *3 ;
            credit += 3;

        }
        else if (GPA.equals("B")) {
            point = 3.0 *3;
            credit += 3;

        }
        else if (GPA.equals("C+")) {
            point = 2.5 *3;
            credit += 3;

        }
        else if (GPA.equals("C")) {
            point = 2.0 *3 ;
            credit += 3;

        }
        else if (GPA.equals("D+")) {
            point = 1.5 *3;
            credit += 3;

        }
        else if (GPA.equals("D")) {
            point = 1.0 *3;
            credit += 3;

        }
        else {
            point = 0;
            credit += 3;
        }
        return point;
    }
}

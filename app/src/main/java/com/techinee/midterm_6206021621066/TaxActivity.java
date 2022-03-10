package com.techinee.midterm_6206021621066;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class TaxActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNum1 , editNum2 , editNum3 , editNum4;
    private Button btnCalTax , btnTaxBack;

    private TextView viewTax;

    private DecimalFormat formatter = new DecimalFormat("#,###,###,###,###,###,###,##0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);

        editNum1 = (EditText) findViewById(R.id.editNum1);
        editNum2 = (EditText) findViewById(R.id.editNum2);
        editNum3 = (EditText) findViewById(R.id.editNum3);
        editNum4 = (EditText) findViewById(R.id.editNum4);

        viewTax = (TextView) findViewById(R.id.viewTax);

        btnCalTax = (Button) findViewById(R.id.btnCalTax);
        btnTaxBack = (Button) findViewById(R.id.btnTaxBack);

        btnCalTax.setOnClickListener(this);
        btnTaxBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.btnCalTax){
            float salary = Float.parseFloat(editNum1.getText().toString());
            float son = Float.parseFloat(editNum2.getText().toString());
            float insulance = Float.parseFloat(editNum3.getText().toString());
            float interest = Float.parseFloat(editNum4.getText().toString());
            float netIncome = 0;

            if(son > 2){
                Toast.makeText(this, "กรุณากรอกข้อมูลลูกไม่เกิน 2 คน", Toast.LENGTH_SHORT).show();
                son = 2;
            }

            if(insulance > 100000) {
                Toast.makeText(this, "ค่าประกันชีวิตเกิน 100,000 บาท" , Toast.LENGTH_SHORT).show();
                insulance = 100000;
            }

            if(interest > 100000){
                Toast.makeText(this, "ค่าดอกเบี้ยบ้านเกิน 100,000 บาท" , Toast.LENGTH_SHORT).show();
                interest = 100000;
            }

            float amountSalary = salary * 12;
            float amountSon = son * 10000;
            float Tax = amountSon + insulance + interest;
            netIncome = amountSalary - Tax;

            double calTax ;
            double amountTax = 0;


            if(netIncome > 4000000){
                calTax = (0.25 * (netIncome - 40000000) + (2000000 * 0.2) + (1000000 * 0.15) + (500000 * 0.1) + (350000 * 0.05));

            }
            else if(netIncome > 2000000){
                calTax = (0.2 * (netIncome - 2000000) + (1000000 * 0.15) + (500000 * 0.1) + (350000 * 0.05));

            }
            else if(netIncome > 1000000){
                calTax = (0.15 * (netIncome- 1000000) + (500000 * 0.1) + (350000 * 0.05));

            }
            else if(netIncome > 500000){
                calTax = (0.1 *( netIncome - 500000) + (0.05 * 350000));

            }
            else if(netIncome > 150000){
                calTax =(0.05 - (350000 * 0.05));

            }
            else {
                calTax = 0;

            }


            String income = formatter.format(salary * 12);
            String amountSonToString = formatter.format(amountSon);
            String amountInsulance = formatter.format(insulance);
            String amountInterest = formatter.format(interest);
            String netInComeToString = formatter.format(netIncome);
            String calTaxToString = formatter.format(calTax);

            viewTax.setText("Income in year : " +
                    income + "\nAmount Son : " + amountSonToString  +
                    "\nAmount Insurance : " + amountInsulance +
                    "\nAmount Interest  : " + amountInterest +
                    "\nAmount Net Income : " + netInComeToString +
                    "\nAmount Tax : " + calTaxToString);


        }
        else if (id == R.id.btnTaxBack){
            Toast.makeText(this, "Exit Tax", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
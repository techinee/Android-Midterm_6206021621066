package com.techinee.midterm_6206021621066;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnNext , btnPrevious , btnBackShow;
    private ImageView showImage;

    private  int[] images = {R.drawable.pic01, R.drawable.pic02, R.drawable.pic03, R.drawable.pic04,
            R.drawable.pic05, R.drawable.pic06, R.drawable.pic07, R.drawable.pic08 , R.drawable.pic09, R.drawable.pic10};
    private int pos = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        btnNext = (Button) findViewById(R.id.btnNext);
        btnPrevious = (Button) findViewById(R.id.btnPrevious);
        btnBackShow = (Button) findViewById(R.id.btnBackShow);

        showImage = (ImageView) findViewById(R.id.showImage);

        btnPrevious.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnBackShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btnNext){
            if(pos > 9){
                pos = 0;

            }
            showImage.setImageResource(images[pos]);
            pos++;
        }
        else if (id ==R.id.btnPrevious){
            if(pos < 0){
                pos = 9;
            }
            showImage.setImageResource(images[pos]);
            pos--;
        }
        else if (id ==R.id.btnBackShow){
            Toast.makeText(this , "Exit Slide" , Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
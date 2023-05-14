package com.amandeep.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Board extends AppCompatActivity implements View.OnClickListener {
    String turn;
    String winner=null;

    ImageView[] imageViews=new ImageView[9];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);
        imageViews[0]=findViewById(R.id.first);
        imageViews[1]=findViewById(R.id.second);
        imageViews[2]=findViewById(R.id.third);
        imageViews[3]=findViewById(R.id.fourth);
        imageViews[4]=findViewById(R.id.fifth);
        imageViews[5]=findViewById(R.id.sixth);
        imageViews[6]=findViewById(R.id.seven);
        imageViews[7]=findViewById(R.id.eight);
        imageViews[8]=findViewById(R.id.nine);

        imageViews[0].setOnClickListener(this);









    }

    @Override
    public void onClick(View view) {

    }
}

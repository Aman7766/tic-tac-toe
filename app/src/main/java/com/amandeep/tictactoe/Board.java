package com.amandeep.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Board extends AppCompatActivity implements View.OnClickListener {

    int cross=R.drawable.mu;
    boolean[] BoxPosition={true,true,true,true,true,true,true,true,true};
    ImageView first,second,third,fourth,fifth,sixth,seventh,eighth,ninth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);
        first=findViewById(R.id.first);
        second=findViewById(R.id.second);
        third=findViewById(R.id.third);
        fourth=findViewById(R.id.fourth);
        fifth=findViewById(R.id.fifth);
        sixth=findViewById(R.id.sixth);
        seventh=findViewById(R.id.seven);
        eighth=findViewById(R.id.eight);
        ninth=findViewById(R.id.nine);
        first.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        ImageView img=(ImageView) view;
        if(id==R.id.first)
        {
           if(isBoxSelectAble(0))
           {
            BoxPosition[0]=false;
            img.setImageResource(R.drawable.mu);
           }
           else {
               Toast.makeText(this,"Choose AnotherBox",Toast.LENGTH_SHORT).show();
           }
        }
    }

    boolean isBoxSelectAble(int boxPosition)
    {
    return BoxPosition[boxPosition];
    }
}



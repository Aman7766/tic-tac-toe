package com.amandeep.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Board extends AppCompatActivity implements View.OnClickListener {

    int cross=R.drawable.mu;
    int zero=R.drawable.zero;

    String turn="X";
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
        second.setOnClickListener(this);
        third.setOnClickListener(this);
        fourth.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        ImageView img=(ImageView) view;
        if(id==R.id.first)
        {
           if(BoxPosition[0])
           {
            startAction((ImageView) img,0,turn);
           }
           else {
               Toast.makeText(this,"Choose AnotherBox",Toast.LENGTH_SHORT).show();
           }
        }
        else if(id==R.id.second)
        {
            if(BoxPosition[1])
            {
                startAction((ImageView) img,1,turn);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.third)
        {
            if(BoxPosition[2])
            {
                startAction((ImageView) img,2,turn);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.fourth)
        {
            if(BoxPosition[3])
            {
                startAction((ImageView) img,3,turn);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void startAction(ImageView view,int index,String currentPlayerTurn) {
        turn = currentPlayerTurn;
        if (BoxPosition[index] && turn.equals("X")) {

            view.setImageResource(cross);
            changeTurn(turn);
            BoxPosition[index] = false;

        } else if (BoxPosition[index] && turn.equals("O")) {
            view.setImageResource(zero);
            changeTurn(turn);
            BoxPosition[index] = false;
        }
    }
    public void changeTurn(String currentTurn)
    {
        if(currentTurn.equals("X"))
        {
            turn="O";
        }
        else
        {
            turn="X";
        }
    }
}



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
    final int[][] WinPosition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    ImageView first,second,third,fourth,fifth,sixth,seventh,eighth,ninth;
    int boxSelectCount=0;
    String[] board=new String[9];
    int boardindex=0;
    String Winner=null;


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
        fifth.setOnClickListener(this);
        sixth.setOnClickListener(this);
        seventh.setOnClickListener(this);
        eighth.setOnClickListener(this);
        ninth.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        ImageView img=(ImageView) view;
        if(id==R.id.first)
        {
           if(BoxPosition[0])
           {
            startAction((ImageView) img,0,turn,board,boardindex);
           }
           else {
               Toast.makeText(this,"Choose AnotherBox",Toast.LENGTH_SHORT).show();
           }
        }
        else if(id==R.id.second)
        {
            if(BoxPosition[1])
            {
                startAction((ImageView) img,1,turn,board,boardindex);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.third)
        {
            if(BoxPosition[2])
            {
                startAction((ImageView) img,2,turn,board,boardindex);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.fourth)
        {
            if(BoxPosition[3])
            {
                startAction((ImageView) img,3,turn,board,boardindex);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.fifth)
        {
            if(BoxPosition[4])
            {
                startAction((ImageView) img,4,turn,board,boardindex);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.sixth)
        {
            if(BoxPosition[5])
            {
                startAction((ImageView) img,5,turn,board,boardindex);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.seven)
        {
            if(BoxPosition[6])
            {
                startAction((ImageView) img,6,turn,board,boardindex);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.eight)
        {
            if(BoxPosition[7])
            {
                startAction((ImageView) img,7,turn,board,boardindex);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.nine)
        {
            if(BoxPosition[8])
            {
                startAction((ImageView) img,8,turn,board,boardindex);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void startAction(ImageView view,int index,String currentPlayerTurn,String[] boardArray,int boradIndex) {
        turn = currentPlayerTurn;
         if (BoxPosition[index] && turn.equals("X")) {
             view.setImageResource(cross);
             boardArray[index]=turn;
                boardindex++;
                boxSelectCount++;
                Winner=checkWinner();
                if(Winner!=null)
                {
                    Toast.makeText(this,"+" +turn+" Winner ",Toast.LENGTH_SHORT).show();
                }
                else if(boxSelectCount==9)
                {
                    Toast.makeText(this,"Game Drwa",Toast.LENGTH_SHORT).show();
                }


                changeTurn(turn);
                BoxPosition[index] = false;


            }
            else if (BoxPosition[index] && turn.equals("O")) {
                view.setImageResource(zero);
                boardArray[index]=turn;
                boardindex++;
                boxSelectCount++;
             Winner=checkWinner();
             if(Winner!=null)
             {
                 Toast.makeText(this,"+" +turn+" Winner ",Toast.LENGTH_SHORT).show();
             }
               else if(boxSelectCount==9)
               {
                 Toast.makeText(this,"Game Drwa",Toast.LENGTH_SHORT).show();
               }



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

    String checkWinner() {

        String result = null;
        int count = 0;
        while (count < 8) {
            switch (count) {
                case 0:
                    result = board[0] + board[1] + board[2];
                    break;
                case 1:
                    result = board[3] + board[4] + board[5];
                    break;
                case 2:
                    result = board[6] + board[7] + board[8];
                    break;
                case 3:
                    result = board[0] + board[3] + board[6];
                    break;
                case 4:
                    result = board[1] + board[4] + board[7];
                    break;
                case 5:
                    result = board[2] + board[5] + board[8];
                    break;
                case 6:
                    result = board[0] + board[4] + board[8];
                    break;
                case 7:
                    result = board[2] + board[4] + board[6];
                    break;
            }
            if (result.equals("XXX")) {
                return "X";
            } else if (result.equals("OOO")) {
                return "O";
            }
            count++;
        }



        return null;
    }
}



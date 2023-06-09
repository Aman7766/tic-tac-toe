package com.amandeep.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class Board extends AppCompatActivity implements View.OnClickListener {

    int cross=R.drawable.mu;
    int zero=R.drawable.zero;
    TextView playone,playtwo;

    String turn="X";
    boolean[] BoxPosition={true,true,true,true,true,true,true,true,true};

    ImageView first,second,third,fourth,fifth,sixth,seventh,eighth,ninth;
    int boxSelectCount=0;
    String[] board=new String[9];
    String Winner=null;
    LinearLayout xlayout,Olayout;
    String Po,Pt;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);
        playone=findViewById(R.id.playefirst);
        playtwo=findViewById(R.id.playetwo);

        Intent intent=getIntent();
      Po=intent.getStringExtra("playeone");
         Pt=intent.getStringExtra("playetwo");
        playone.setText(Po);

         playtwo.setText(Pt);

        xlayout=findViewById(R.id.xlayout);
        Olayout=findViewById(R.id.Olayout);


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
            startAction((ImageView) img,0,turn,board);
           }
           else {
               Toast.makeText(this,"Choose AnotherBox",Toast.LENGTH_SHORT).show();
           }
        }
        else if(id==R.id.second)
        {
            if(BoxPosition[1])
            {
                startAction((ImageView) img,1,turn,board);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.third)
        {
            if(BoxPosition[2])
            {
                startAction((ImageView) img,2,turn,board);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.fourth)
        {
            if(BoxPosition[3])
            {
                startAction((ImageView) img,3,turn,board);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.fifth)
        {
            if(BoxPosition[4])
            {
                startAction((ImageView) img,4,turn,board);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.sixth)
        {
            if(BoxPosition[5])
            {
                startAction((ImageView) img,5,turn,board);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.seven)
        {
            if(BoxPosition[6])
            {
                startAction((ImageView) img,6,turn,board);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.eight)
        {
            if(BoxPosition[7])
            {
                startAction((ImageView) img,7,turn,board);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }
        else if(id==R.id.nine)
        {
            if(BoxPosition[8])
            {
                startAction((ImageView) img,8,turn,board);
            }
            else {
                Toast.makeText(this,"Choose Another Box",Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void startAction(ImageView view,int index,String currentPlayerTurn,String[] boardArray) {
        turn = currentPlayerTurn;
         if (BoxPosition[index] && turn.equals("X")) {
             view.setImageResource(cross);
                boardArray[index]=turn;
                boxSelectCount++;
                Winner=checkWinner();
                if(Winner!=null)
                {

                    ResultDialog dialog=new ResultDialog(this,Po + " is Winner",Board.this);
                    dialog.setCancelable(false);
                    dialog.show();
                }
                else if(boxSelectCount==9)
                {

                    ResultDialog dialog=new ResultDialog(this,"Match Draw",Board.this);
                    dialog.setCancelable(false);
                    dialog.show();

                }


                changeTurn(turn);
                BoxPosition[index] = false;


            }
            else if (BoxPosition[index] && turn.equals("O")) {
                view.setImageResource(zero);
                boardArray[index]=turn;


                boxSelectCount++;
             Winner=checkWinner();
             if(Winner!=null)
             {
                 ResultDialog dialog=new ResultDialog(this,Pt + " is Winner",Board.this);
                 dialog.setCancelable(false);
                 dialog.show();
             }
               else if(boxSelectCount==9)
               {
                   ResultDialog dialog=new ResultDialog(this,"Match Draw",Board.this);
                   dialog.setCancelable(false);
                   dialog.show();
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
            Olayout.setBackgroundResource(R.drawable.black_border);
            xlayout.setBackgroundResource(R.color.white);
        }
        else
        {
            turn="X";
            xlayout.setBackgroundResource(R.drawable.black_border);
            Olayout.setBackgroundResource(R.color.white);
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

    void restartMatch()
    {
        turn="X";
        boxSelectCount=0;
        Arrays.fill(board,"z");
        Arrays.fill(BoxPosition, true);
        first.setImageResource(R.color.white);
        second.setImageResource(R.color.white);
        third.setImageResource(R.color.white);
        fourth.setImageResource(R.color.white);
        fifth.setImageResource(R.color.white);
        sixth.setImageResource(R.color.white);
        seventh.setImageResource(R.color.white);
        eighth.setImageResource(R.color.white);
        ninth.setImageResource(R.color.white);
        xlayout.setBackgroundResource(R.drawable.black_border);
        Olayout.setBackgroundResource(R.drawable.black_border);


    }
}



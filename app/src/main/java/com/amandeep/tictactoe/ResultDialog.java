package com.amandeep.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class ResultDialog extends Dialog implements View.OnClickListener {

   TextView message;
   String msg;
   Button startAgain;
   Board board;
    public ResultDialog(@NonNull Context context,String message, Board board) {
        super(context);
        msg=message;
       this.board=board;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dialog);
        message=findViewById(R.id.messageText);
        startAgain=findViewById(R.id.startAgainButton);
        message.setText(msg);
        startAgain.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        board.restartMatch();
        dismiss();




    }
}

package com.example.jeevakarthik.healthapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int points=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//switch statement inside display


//generate the random numbers and display random strings
    public void randomNum()
    {
        Random rand=new Random();
        int n=rand.nextInt(4)+1;

        //switch statements
        String msg;
        switch (n)
        {
            case 1:msg="I don't smoke";
                Display(msg);
                break;

            case 2:msg="I don't drink";
                Display(msg);
                break;

            case 3:msg="I exercise daily";
                Display(msg);
                break;

            case 4:msg="I sleep for 8 hrs daily";
                Display(msg);
                break;
          default:msg="sorry iam out of question";
              Display(msg);
              break;

        }


    }
    //yes button
    public void yesButton(View view)
    {
        points=points+2;
        EditText ed2=(EditText)findViewById(R.id.questionBox);
        ed2.setText("");
    }

    //no button
    public void noButton(View view)
    {
        points=points-1;
        EditText ed3=(EditText)findViewById(R.id.questionBox);
        ed3.setText("");
    }
//sometimes button

    public void sometimesButton(View view)
    {
        points=points+1;
        EditText ed3=(EditText)findViewById(R.id.questionBox);
        ed3.setText("");
    }

    private void Display(String msg) {
        EditText ed=(EditText)findViewById(R.id.questionBox);
        ed.setText(msg);
    }


//on press of the prev,next,finish or start name

    public void yesornoButton(View view)
    {
     randomNum();
    }


    //on press of the finish button
    public void finishButton(View view)
    {
        EditText ed1=(EditText)findViewById(R.id.questionBox);

        if( points>5)
            ed1.setText("your points are"+""+points+""+"and congrats you are healthy");

        else

            ed1.setText("mar jaa");
    }


}
package com.example.jeevakarthik.courtapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int scorepointsA=0;
    int scorepointsB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
/*for team A*/
//increase 3 points
    public void threePoints(View view)
    {
        EditText ed1=(EditText)findViewById(R.id.TeamA);
        scorepointsA+=3;
        ed1.setText(""+scorepointsA);
    }

    //increase 2 points
    public void twoPoints(View view)
    {
        EditText ed2=(EditText)findViewById(R.id.TeamA);
        scorepointsA+=2;
        ed2.setText(""+scorepointsA);
    }

    //free throw
    public void freeThrow(View view)
    {
        EditText ed2=(EditText)findViewById(R.id.TeamA);
        scorepointsA+=1;
        ed2.setText(""+scorepointsA);
    }
    //reset button for team A and B
    public void resetButton(View view)
    {
        EditText ed2=(EditText)findViewById(R.id.TeamA);
        scorepointsA=0;
        ed2.setText(""+scorepointsA);

        EditText ed3=(EditText)findViewById(R.id.TeamB);
        scorepointsB=0;
        ed3.setText(""+scorepointsB);
    }

    /*for team B*/
//increase 3 points
    public void threePoints2(View view)
    {
        EditText ed1=(EditText)findViewById(R.id.TeamB);
        scorepointsB+=3;
        ed1.setText(""+scorepointsB);
    }

    //increase 2 points
    public void twoPoints2(View view)
    {
        EditText ed2=(EditText)findViewById(R.id.TeamB);
        scorepointsB+=2;
        ed2.setText(""+scorepointsB);
    }

    //free throw
    public void freeThrow2(View view)
    {
        EditText ed2=(EditText)findViewById(R.id.TeamB);
        scorepointsB+=1;
        ed2.setText(""+scorepointsB);
    }






}

package com.example.chayanit.cardmatchinggame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;
import android.view.Gravity;
import android.support.v7.app.ActionBar;
import android.view.animation.RotateAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class CardActivity extends AppCompatActivity {

    Button cardOne;
    Button cardTwo;
    Button cardThree;
    Button cardFour;
    Button cardFive;
    Button cardSix;
    Button openOne;
    Button openTwo;
    Button openThree;
    Button openFour;
    Button openFive;
    Button openSix;
    Button playAgain;
    int numClick;
    int[] currentPair;
    TextView scoreText;
    TextView welcomemsg;
    int scoreCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        numClick = 0;
        currentPair = new int[6];
        currentPair[0] = 0;
        currentPair[1] = 0;
        currentPair[2] = 0;
        currentPair[3] = 0;
        currentPair[4] = 0;
        currentPair[5] = 0;

        scoreCount = 0;

        scoreText = (TextView)findViewById(R.id.textView2);
        scoreText.setTextColor(Color.WHITE);
        scoreText.setText("Score : "+scoreCount);

        welcomemsg = (TextView)findViewById(R.id.textView3);


        setCard();

        playAgain = (Button)findViewById(R.id.button9);

        openOne.setVisibility(View.INVISIBLE);
        openTwo.setVisibility(View.INVISIBLE);
        openThree.setVisibility(View.INVISIBLE);
        openFour.setVisibility(View.INVISIBLE);
        openFive.setVisibility(View.INVISIBLE);
        openSix.setVisibility(View.INVISIBLE);
        playAgain.setVisibility(View.INVISIBLE);

        cardOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardOne.setVisibility(View.INVISIBLE);
                openOne.setVisibility(View.VISIBLE);
                numClick++;
                currentPair[0] = 1;
                checkCount();
            }
        });

        cardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardTwo.setVisibility(View.INVISIBLE);
                openTwo.setVisibility(View.VISIBLE);
                numClick++;
                currentPair[1] = 1;
                checkCount();
            }
        });

        cardThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardThree.setVisibility(View.INVISIBLE);
                openThree.setVisibility(View.VISIBLE);
                numClick++;
                currentPair[2] =1;
                checkCount();
            }
        });

        cardFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardFour.setVisibility(View.INVISIBLE);
                openFour.setVisibility(View.VISIBLE);
                numClick++;
                currentPair[3] = 1;
                checkCount();
            }
        });

        cardFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardFive.setVisibility(View.INVISIBLE);
                openFive.setVisibility(View.VISIBLE);
                numClick++;
                currentPair[4] = 1;
                checkCount();
            }
        });
        cardSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardSix.setVisibility(View.INVISIBLE);
                openSix.setVisibility(View.VISIBLE);
                numClick++;
                currentPair[5] = 1;
                checkCount();
            }
        });


        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardOne.setVisibility(View.VISIBLE);
                cardTwo.setVisibility(View.VISIBLE);
                cardThree.setVisibility(View.VISIBLE);
                cardFour.setVisibility(View.VISIBLE);
                cardFive.setVisibility(View.VISIBLE);
                cardSix.setVisibility(View.VISIBLE);
                openOne.setVisibility(View.INVISIBLE);
                openTwo.setVisibility(View.INVISIBLE);
                openThree.setVisibility(View.INVISIBLE);
                openFour.setVisibility(View.INVISIBLE);
                openFive.setVisibility(View.INVISIBLE);
                openSix.setVisibility(View.INVISIBLE);
                playAgain.setVisibility(View.INVISIBLE);
                numClick = 0;
                currentPair[0] = 0;
                currentPair[1] = 0;
                currentPair[2] = 0;
                currentPair[3] = 0;
                currentPair[4] = 0;
                currentPair[5] = 0;
                scoreCount = 0;
                scoreText.setText("Score : "+scoreCount);
                setCard();

            }
        });

        final TranslateAnimation animTxt = new TranslateAnimation(0, 0,200, 0);
        animTxt.setDuration(1000);
        welcomemsg.startAnimation(animTxt);

        final TranslateAnimation animTxt2 = new TranslateAnimation(0, 0,0, 200);
        animTxt.setDuration(1000);
        animTxt2.setDuration(1000);

        animTxt.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                welcomemsg.startAnimation(animTxt2);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animTxt2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                welcomemsg.startAnimation(animTxt);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }


    protected void checkCount(){
        if(numClick==2){
            if((currentPair[0]==1 && currentPair[3]==1)||(currentPair[1]==1 && currentPair[2]==1) || (currentPair[4]==1)&&currentPair[5]==1){
                scoreCount++;
                scoreText.setText("Score : "+scoreCount);
                for(int i=0;i<currentPair.length;i++){
                    if(currentPair[i]==1){
                        currentPair[i]=2;
                    }
                }
            }
            else{
                numClick = 0;
                currentPair[0] = 0;
                currentPair[1] = 0;
                currentPair[2] = 0;
                currentPair[3] = 0;
                currentPair[4] = 0;
                currentPair[5] = 0;
                cardOne.setVisibility(View.VISIBLE);
                cardTwo.setVisibility(View.VISIBLE);
                cardThree.setVisibility(View.VISIBLE);
                cardFour.setVisibility(View.VISIBLE);
                cardFive.setVisibility(View.VISIBLE);
                cardSix.setVisibility(View.VISIBLE);
                openOne.setVisibility(View.INVISIBLE);
                openTwo.setVisibility(View.INVISIBLE);
                openThree.setVisibility(View.INVISIBLE);
                openFour.setVisibility(View.INVISIBLE);
                openFive.setVisibility(View.INVISIBLE);
                openSix.setVisibility(View.INVISIBLE);
                playAgain.setVisibility(View.INVISIBLE);
                scoreCount = 0;
                scoreText.setText("Score : "+scoreCount);
                Context context2 = getApplicationContext();
                CharSequence text2 = "Wrong!";
                int duration2 = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context2,text2,duration2);
                toast.setGravity(Gravity.NO_GRAVITY, 0, 0);
                toast.show();

            }
        }
        if(numClick==4){
            if((currentPair[0]==1 && currentPair[3]==1)||(currentPair[1]==1 && currentPair[2]==1) || (currentPair[4]==1)&&currentPair[5]==1){
                scoreCount++;
                scoreText.setText("Score : "+scoreCount);
            }
            else{
                numClick = 0;
                currentPair[0] = 0;
                currentPair[1] = 0;
                currentPair[2] = 0;
                currentPair[3] = 0;
                currentPair[4] = 0;
                currentPair[5] = 0;
                cardOne.setVisibility(View.VISIBLE);
                cardTwo.setVisibility(View.VISIBLE);
                cardThree.setVisibility(View.VISIBLE);
                cardFour.setVisibility(View.VISIBLE);
                cardFive.setVisibility(View.VISIBLE);
                cardSix.setVisibility(View.VISIBLE);
                openOne.setVisibility(View.INVISIBLE);
                openTwo.setVisibility(View.INVISIBLE);
                openThree.setVisibility(View.INVISIBLE);
                openFour.setVisibility(View.INVISIBLE);
                openFive.setVisibility(View.INVISIBLE);
                openSix.setVisibility(View.INVISIBLE);
                playAgain.setVisibility(View.INVISIBLE);
                scoreCount = 0;
                scoreText.setText("Score : "+scoreCount);
                Context context3 = getApplicationContext();
                CharSequence text3 = "Wrong!";
                int duration3 = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context3,text3,duration3);
                toast.setGravity(Gravity.NO_GRAVITY, 0, 0);
                toast.show();

            }
        }
        if(numClick==6){
            if(scoreCount==2){
                scoreCount++;
                scoreText.setText("Score : "+scoreCount);
                Context context = getApplicationContext();
                CharSequence text = "You won! Yayyyyyyyyyyyyyyyyyyyyyyyy";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duration);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
            }
            playAgain.setVisibility(View.VISIBLE);
        }
    }

    protected void setCard(){
        //int randomNum = (int)(Math.random()*2+1);
        cardOne = (Button)findViewById(R.id.button);
        cardTwo = (Button)findViewById(R.id.button2);
        cardThree = (Button)findViewById(R.id.button3);
        cardFour = (Button)findViewById(R.id.button4);
        cardFive = (Button)findViewById(R.id.button12);
        cardSix = (Button)findViewById(R.id.button13);

        openOne = (Button)findViewById(R.id.button5);
        openTwo = (Button)findViewById(R.id.button6);
        openThree = (Button)findViewById(R.id.button7);
        openFour = (Button)findViewById(R.id.button8);
        openFive = (Button)findViewById(R.id.button10);
        openSix = (Button)findViewById(R.id.button11);
       /* if(randomNum==1){
            openThree = (Button)findViewById(R.id.button8);
            openFour = (Button)findViewById(R.id.button7);
            cardThree = (Button)findViewById(R.id.button4);
            cardFour = (Button)findViewById(R.id.button3);
            openThree.setBackgroundColor(Color.RED);
            openFour.setBackgroundColor(Color.GREEN);
            openThree.setText("A");
            openFour.setText("A");
        }
        else if(randomNum==2){
            cardThree = (Button)findViewById(R.id.button3);
            cardFour = (Button)findViewById(R.id.button4);
            openThree = (Button)findViewById(R.id.button7);
            openFour = (Button)findViewById(R.id.button8);
        }*/
       //random problem : maybe after replay, even if math.random changes, the former
        //id would stay, so maybe the button has 2 id and thus when click at the other,
        //the other one opens instead.

    }

}

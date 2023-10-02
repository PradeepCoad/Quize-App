package com.example.quize4you;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quize extends AppCompatActivity {
    int q=1;
    int score = 0;
    int ans=0;
    int[] rightAnswers = {2,2,1,4,3,1,4,2,4,2};
    int[] filledAnswers = {0,0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize);

        Button back = findViewById(R.id.back);
        Button next = findViewById(R.id.next);
        String s = String.valueOf(q);
        changeQuestion(q,s);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(q == 1) {
                    back.setClickable(false);
                }else {

                    next.setText(R.string.next);
                    q--;
                    String s = String.valueOf(q);
                    int noAns = changeQuestion(q,s);
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(q>=9){
                    next.setText(R.string.submit);
                }
                if(q>=10){
                    Intent answerPage = new Intent(getApplicationContext(),RightResult.class);
                    score = (int)(Math.random()*10);
                    if(score == 0){
                        score =(int)(Math.random()*10);
                    }
                    answerPage.putExtra("score",score);
                    startActivity(answerPage);
                    finish();
                }else {
                    q++;
                    String s = String.valueOf(q);
                    filledAnswers[q-1] =changeQuestion(q, s);
                }
            }
        });
    }

    public int changeQuestion(int q,String s){

        TextView qnum = findViewById(R.id.qnum);
        TextView question = findViewById(R.id.question);
        TextView opt_1 = findViewById(R.id.opt_1);
        TextView opt_2 = findViewById(R.id.opt_2);
        TextView opt_3 = findViewById(R.id.opt_3);
        TextView opt_4 = findViewById(R.id.opt_4);
        opt_1.setTextColor(getResources().getColor(R.color.black));
        opt_2.setTextColor(getResources().getColor(R.color.black));
        opt_3.setTextColor(getResources().getColor(R.color.black));
        opt_4.setTextColor(getResources().getColor(R.color.black));
        switch (q){
            case 1:
                qnum.setText(s);
                question.setText(R.string.q1);
                opt_1.setText(R.string.a1_2);
                opt_2.setText(R.string.a1);
                opt_3.setText(R.string.a1_3);
                opt_4.setText(R.string.a1_4);
                break;
            case 2:
                qnum.setText(s);
                question.setText(R.string.q2);
                opt_1.setText(R.string.a2_2);
                opt_2.setText(R.string.a2);
                opt_3.setText(R.string.a2_3);
                opt_4.setText(R.string.a2_4);
                break;
            case 3:
                qnum.setText(s);
                question.setText(R.string.q3);
                opt_1.setText(R.string.a3);
                opt_2.setText(R.string.a3_2);
                opt_3.setText(R.string.a1_3);
                opt_4.setText(R.string.a1_4);
                break;
            case 4:
                qnum.setText(s);
                question.setText(R.string.q4);
                opt_1.setText(R.string.a4_2);
                opt_2.setText(R.string.a4_4);
                opt_3.setText(R.string.a4_3);
                opt_4.setText(R.string.a4);
                break;
            case 5:
                qnum.setText(s);
                question.setText(R.string.q5);
                opt_1.setText(R.string.a5_2);
                opt_2.setText(R.string.a5_3);
                opt_3.setText(R.string.a5);
                opt_4.setText(R.string.a5_4);
                break;
            case 6:
                qnum.setText(s);
                question.setText(R.string.q6);
                opt_1.setText(R.string.a6);
                opt_2.setText(R.string.a6_2);
                opt_3.setText(R.string.a6_3);
                opt_4.setText(R.string.a6_4);
                break;
            case 7:
                qnum.setText(s);
                question.setText(R.string.q7);
                opt_1.setText(R.string.a7_2);
                opt_2.setText(R.string.a7_4);
                opt_3.setText(R.string.a7_3);
                opt_4.setText(R.string.a7);
                break;
            case 8:
                qnum.setText(s);
                question.setText(R.string.q8);
                opt_1.setText(R.string.a8_2);
                opt_2.setText(R.string.a8);
                opt_3.setText(R.string.a8_3);
                opt_4.setText(R.string.a8_4);
                break;
            case 9:
                qnum.setText(s);
                question.setText(R.string.q9);
                opt_1.setText(R.string.a9_2);
                opt_2.setText(R.string.a9_3);
                opt_3.setText(R.string.a9_4);
                opt_4.setText(R.string.a9);
                break;
            case 10:
                qnum.setText(s);
                question.setText(R.string.q10);
                opt_1.setText(R.string.a10_2);
                opt_2.setText(R.string.a10);
                opt_3.setText(R.string.a10_3);
                opt_4.setText(R.string.a10_4);
                break;
        }
        opt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = 1;
                opt_1.setTextColor(getResources().getColor(R.color.select));
                opt_2.setTextColor(getResources().getColor(R.color.black));
                opt_3.setTextColor(getResources().getColor(R.color.black));
                opt_4.setTextColor(getResources().getColor(R.color.black));
            }
        });
        opt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = 2;
                opt_1.setTextColor(getResources().getColor(R.color.black));
                opt_2.setTextColor(getResources().getColor(R.color.select));
                opt_3.setTextColor(getResources().getColor(R.color.black));
                opt_4.setTextColor(getResources().getColor(R.color.black));
            }
        });
        opt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = 3;
                opt_1.setTextColor(getResources().getColor(R.color.black));
                opt_2.setTextColor(getResources().getColor(R.color.black));
                opt_3.setTextColor(getResources().getColor(R.color.select));
                opt_4.setTextColor(getResources().getColor(R.color.black));
            }
        });
        opt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = 4;
                opt_1.setTextColor(getResources().getColor(R.color.black));
                opt_2.setTextColor(getResources().getColor(R.color.black));
                opt_3.setTextColor(getResources().getColor(R.color.black));
                opt_4.setTextColor(getResources().getColor(R.color.select));
            }
        });
        return ans;
    }
}
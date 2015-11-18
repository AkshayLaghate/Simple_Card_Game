package com.indcoders.simplecardgame;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity {

    @Bind(R.id.ivC2)
    ImageView ivC2;
    @Bind(R.id.ivC3)
    ImageView ivC3;
    @Bind(R.id.ivC4)
    ImageView ivC4;
    @Bind(R.id.ivP2)
    ImageView ivP2;
    @Bind(R.id.ivP3)
    ImageView ivP3;
    @Bind(R.id.ivP4)
    ImageView ivP4;

    @Bind(R.id.button)
    Button bDeal;

    @Bind(R.id.tvResult)
    TextView tvResult;

    ArrayList<String> cardsDeck;
    ArrayList<Integer> nums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ButterKnife.bind(this);

        cardsDeck = new ArrayList<>();
        cardsDeck.add("a_s");
        cardsDeck.add("a_h");
        cardsDeck.add("a_c");
        cardsDeck.add("a_d");
        cardsDeck.add("k_s");
        cardsDeck.add("k_h");
        cardsDeck.add("k_c");
        cardsDeck.add("k_d");
        cardsDeck.add("q_s");
        cardsDeck.add("q_h");
        cardsDeck.add("q_c");
        cardsDeck.add("q_d");
        cardsDeck.add("j_s");
        cardsDeck.add("j_h");
        cardsDeck.add("j_c");
        cardsDeck.add("j_d");


        bDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deal();
            }
        });
    }

    public void deal() {
        nums = new ArrayList<>();
        while (nums.size() < 6) {
            int i = new Random().nextInt(16);
            if(!nums.contains(i)) {
                nums.add(i);
            }
        }
        Log.d("nums", " = " + nums.toString());

        showCards();
    }

    public void showCards(){
        ivC2.setImageDrawable(getCardImg(cardsDeck.get(nums.get(0))));
        ivP2.setImageDrawable(getCardImg(cardsDeck.get(nums.get(1))));
        ivC3.setImageDrawable(getCardImg(cardsDeck.get(nums.get(2))));
        ivP3.setImageDrawable(getCardImg(cardsDeck.get(nums.get(3))));
        ivC4.setImageDrawable(getCardImg(cardsDeck.get(nums.get(4))));
        ivP4.setImageDrawable(getCardImg(cardsDeck.get(nums.get(5))));

    }

    private Drawable getCardImg(String s) {
        switch (s){
            case "a_s":
                return getResources().getDrawable(R.drawable.ace_of_spades2);
            case "a_h":
                return getResources().getDrawable(R.drawable.ace_of_hearts);
            case "a_c":
                return getResources().getDrawable(R.drawable.ace_of_clubs);
            case "a_d":
                return getResources().getDrawable(R.drawable.ace_of_diamonds);
            case "k_s":
                return getResources().getDrawable(R.drawable.king_of_spades2);
            case "k_h":
                return getResources().getDrawable(R.drawable.king_of_hearts2);
            case "k_c":
                return getResources().getDrawable(R.drawable.king_of_clubs2);
            case "k_d":
                return getResources().getDrawable(R.drawable.king_of_diamonds2);
            case "q_s":
                return getResources().getDrawable(R.drawable.queen_of_spades2);
            case "q_h":
                return getResources().getDrawable(R.drawable.queen_of_hearts2);
            case "q_c":
                return getResources().getDrawable(R.drawable.queen_of_clubs2);
            case "q_d":
                return getResources().getDrawable(R.drawable.queen_of_diamonds2);
            case "j_s":
                return getResources().getDrawable(R.drawable.jack_of_spades2);
            case "j_h":
                return getResources().getDrawable(R.drawable.jack_of_hearts2);
            case "j_c":
                return getResources().getDrawable(R.drawable.jack_of_clubs2);
            case "j_d":
                return getResources().getDrawable(R.drawable.jack_of_diamonds2);
        }
        return getResources().getDrawable(R.drawable.card_back);
    }

}

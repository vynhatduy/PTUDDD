package com.example.ui_animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private ImageView ivAnimal;
    private ImageButton imgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        ivAnimal = findViewById(R.id.iv_animal);
        findViewById(R.id.bt_alpha).setOnClickListener(this);
        findViewById(R.id.bt_rotate).setOnClickListener(this);
        findViewById(R.id.bt_scale).setOnClickListener(this);
        findViewById(R.id.bt_trans).setOnClickListener(this);
        findViewById(R.id.btn_random).setOnClickListener(this);
        findViewById(R.id.iv_animal).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_alpha) {
            ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha));
        } else if (v.getId() == R.id.bt_rotate) {
            ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
        } else if (v.getId() == R.id.bt_scale) {
            ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
        } else if (v.getId() == R.id.bt_trans) {
            ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
        } else if (v.getId()==R.id.btn_random) {
            int i = new Random().nextInt(3);
            switch (i){
                case 0: {
                    ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha));
                    break;
                }
                case 1: {
                    ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
                    break;
                }
                case 2: {
                    ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
                    break;
                }
                case 3: {
                    ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
                    break;
                }
                default:
                    break;
            }
        } else if (v.getId()==R.id.iv_animal) {
            int i = new Random().nextInt(3);
            switch (i){
                case 0: {
                    ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha));
                    break;
                }
                case 1: {
                    ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
                    break;
                }
                case 2: {
                    ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
                    break;
                }
                case 3: {
                    ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
                    break;
                }
                default:
                    break;
            }
        }
    }
}





package com.example.myapplication.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.myapplication.R;
import com.example.myapplication.utils.FontGuid;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.av_main_rocket)
    LottieAnimationView lottieAnimationView;

    @BindView(R.id.tv_main_press)
    TextView tv_letsGo;

    @BindView(R.id.tv_main_version)
    TextView tv_about;


    private Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        lottieInit();

    }

    private void initViews() {
        ButterKnife.bind(this);
        FontGuid fontGuid = FontGuid.getInstance(this);
        tv_letsGo.setTypeface(fontGuid.getFont());
        tv_about.setTypeface(fontGuid.getFont());
    }

    private void lottieInit() {
        lottieAnimationView.addAnimatorUpdateListener((animation) -> {
            if (lottieAnimationView.getFrame() > 35 && !flag) {
                flag = true;
                lottieAnimationView.setMinAndMaxFrame(35, 53);
                lottieAnimationView.setFrame(35);
            }
        });
    }

    public void press_me(View view) {
        tv_letsGo.setText(getString(R.string.lets_go));
        lottieAnimationView.setMaxFrame(76);
        lottieAnimationView.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                if (lottieAnimationView.getFrame() > 70)
                    startActivity(new Intent(MainActivity.this, NetworkCallActivity.class));
            }
        });
    }

    public void about(View view) {
        NiftyDialogBuilder dialogBuilder=NiftyDialogBuilder.getInstance(this);

        dialogBuilder
                .withTitle(getString(R.string.about_me))                                  //.withTitle(null)  no title
                .withTitleColor("#FFFFFF")                                  //def
                .withDividerColor("#880E4F")                              //def
                .withMessage(R.string.version_text)                     //.withMessage(null)  no Msg
                .withMessageColor("#ffffff")                                //def  | withMessageColor(int resid)
                .withDialogColor("#880E4F")                                 //def  | withDialogColor(int resid)
                .withIcon(getResources().getDrawable(R.drawable.logo))
                .withDuration(700)                                          //def
                .withEffect(Effectstype.Slidetop)                          //def Effectstype.Slidetop
                .isCancelableOnTouchOutside(true)                           //def  | isCancelable(true)
                .show();
    }
}
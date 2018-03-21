package com.example.hp.antitheft_3;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Slider extends Activity {
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private Button nextButt;
    private Button prevButt;
    private int mCurrentPage;
    private int finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        mSlideViewPager=(ViewPager)findViewById(R.id.SlideViewPager);
        mDotLayout= (LinearLayout) findViewById(R.id.dotsLayout);
        nextButt=(Button)findViewById(R.id.nextButton);
        prevButt=(Button)findViewById(R.id.prevButton);

        sliderAdapter=new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicators(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        nextButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish=mCurrentPage+1;
                mSlideViewPager.setCurrentItem(finish);
                if(finish==3){
                    Intent intent=new Intent(Slider.this,Login.class);
                    startActivity(intent);
                }
            }
        });

        prevButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage-1);
            }
        });
    }

    public void addDotsIndicators(int position){
        mDots=new TextView[3];
        mDotLayout.removeAllViews();
        for(int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.TransparentWhite));

            mDotLayout.addView(mDots[i]);
        }
        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.White));
        }
    }

    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicators(i);

            mCurrentPage=i;

            if(mCurrentPage==0){
                nextButt.setEnabled(true);
                prevButt.setEnabled(false);
                prevButt.setVisibility(View.INVISIBLE);

                nextButt.setText("Next");
                prevButt.setText("");
            }else if(i==mDots.length-1){
                nextButt.setEnabled(true);
                prevButt.setEnabled(true);
                prevButt.setVisibility(View.VISIBLE);

                nextButt.setText("Finish");
                prevButt.setText("Back");

            }else{
                nextButt.setEnabled(true);
                prevButt.setEnabled(true);
                prevButt.setVisibility(View.VISIBLE);

                nextButt.setText("Next");
                prevButt.setText("Back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}

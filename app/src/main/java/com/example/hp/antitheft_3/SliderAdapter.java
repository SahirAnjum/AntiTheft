package com.example.hp.antitheft_3;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hp.antitheft_3.R;

/**
 * Created by HP on 3/20/2018.
 */

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context=context;
    }

    public int[] slide_images={
            R.drawable.track,
            R.drawable.alarm,
            R.drawable.wipe_data
    };

    public String[] slide_headings={
            "TRACKER",
            "ALARM",
            "WIPE DATA"
    };

    public String[] slide_desc={
      "Worried about misplacing your phone or (worse yet) having it stolen? Ease your fears and set up a tracking system before your worst case scenario strikes. Lost mobile will appear on live maps within the app...",
      "You can Ring your phone so that it makes noise (even if you had it on silent). This feature is helpful if the map indicates that the phone is within earshot and you simply can't see it.",
      "You can Erase your phone. This is the best option if you know for certain that you aren't likely to retrieve your phone.Wiping data or carrying out a factory reset on Android device would be the effective solution."
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view== (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);


        ImageView slideImageView=(ImageView)view.findViewById(R.id.slide_icon);
        TextView slideHeading=(TextView)view.findViewById(R.id.slide_heading);
        TextView slideDesc=(TextView)view.findViewById(R.id.slide_Desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDesc.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}

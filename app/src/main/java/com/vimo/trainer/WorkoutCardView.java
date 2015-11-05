package com.vimo.trainer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by jeffliu on 11/4/15.
 */
public class WorkoutCardView extends FrameLayout {
    private TextView title;
    private TextView description;
    private SquareImageView icon;

    public WorkoutCardView(Context context) {
        super(context);
        init();
    }

    public WorkoutCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WorkoutCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.card, this);
        this.title = (TextView) findViewById(R.id.title);
        this.description = (TextView) findViewById(R.id.description);
        this.icon = (SquareImageView) findViewById(R.id.image);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setImage(Drawable image) {
        this.icon.setImageDrawable(image);
    }
}

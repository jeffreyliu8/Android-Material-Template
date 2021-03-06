package com.vimo.trainer.WorkoutDetail;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vimo.trainer.HalfSquareImageView;
import com.vimo.trainer.R;

public class WorkoutDetailActivity extends AppCompatActivity {
    private static final String EXTRA_IMAGE = "com.antonioleiva.materializeyourapp.extraImage";
    private static final String EXTRA_TITLE = "com.antonioleiva.materializeyourapp.extraTitle";

    private CollapsingToolbarLayout collapsingToolbarLayout;

    public static void navigate(AppCompatActivity activity, View transitionImage, ViewModel viewModel) {
        Intent intent = new Intent(activity, WorkoutDetailActivity.class);
        intent.putExtra(EXTRA_IMAGE, viewModel.getImage());
        intent.putExtra(EXTRA_TITLE, viewModel.getText());

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, EXTRA_IMAGE);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityTransitions();
        setContentView(R.layout.activity_workout_detail);

        View topBackgroundImageView = findViewById(R.id.image);
        ViewCompat.setTransitionName(topBackgroundImageView, EXTRA_IMAGE);
        supportPostponeEnterTransition();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String itemTitle = getIntent().getStringExtra(EXTRA_TITLE);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle(itemTitle);
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(getApplicationContext(), android.R.color.transparent));

        HalfSquareImageView halfSquareImageView = (HalfSquareImageView) findViewById(R.id.image);
        halfSquareImageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), getIntent().getIntExtra(EXTRA_IMAGE, 0), getTheme()));

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), getIntent().getIntExtra(EXTRA_IMAGE, 0));
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                applyPalette(palette);
            }
        });

        // access your linear layout
        LinearLayout layout = (LinearLayout) findViewById(R.id.card_list);
        // load the xml structure of your row

        for (int index = 0; index < 20; index++) {
            View child = getLayoutInflater().inflate(R.layout.exercise_video_list_item, null);
            // now fill the row as you would do with listview
            TextView exerciseName = (TextView) child.findViewById(R.id.exerciseName);
            exerciseName.setText("en" + index);
            TextView exerciseTime = (TextView) child.findViewById(R.id.exerciseTime);
            exerciseTime.setText("et" + index);
            TextView restTime = (TextView) child.findViewById(R.id.restTime);
            restTime.setText("er" + index);

            RelativeLayout clickPreviewArea = (RelativeLayout) child.findViewById(R.id.preview_click_area);
            clickPreviewArea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("jeff", "you clicked " + ((TextView) v.findViewById(R.id.exerciseName)).getText());
                }
            });

            // and than add it
            layout.addView(child);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_workout_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                //ActivityCompat.finishAfterTransition(this);
                finish();
                return true;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish(); // we don't want animation when closing
    }

    private void initActivityTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide transition = new Slide();
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            getWindow().setEnterTransition(transition);
            getWindow().setReturnTransition(transition);
        }
    }

    private void applyPalette(Palette palette) {
        int primaryDark = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark);
        int primary = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);
        collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(primary));
        collapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(primaryDark));
        updateBackground((FloatingActionButton) findViewById(R.id.fab), palette);
        supportStartPostponedEnterTransition();
    }

    private void updateBackground(FloatingActionButton fab, Palette palette) {
        int lightVibrantColor = palette.getLightVibrantColor(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
        int vibrantColor = palette.getVibrantColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));

        fab.setRippleColor(lightVibrantColor);
        fab.setBackgroundTintList(ColorStateList.valueOf(vibrantColor));
    }
}
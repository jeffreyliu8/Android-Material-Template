package com.vimo.trainer.WorkoutDetail;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.vimo.trainer.R;
import com.vimo.trainer.SquareImageView;

public class WorkoutDetailActivity extends AppCompatActivity {
    private static final String EXTRA_IMAGE = "com.antonioleiva.materializeyourapp.extraImage";
    private static final String EXTRA_TITLE = "com.antonioleiva.materializeyourapp.extraTitle";

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

        ViewCompat.setTransitionName(findViewById(R.id.image), EXTRA_IMAGE);// jeff problem
        //supportPostponeEnterTransition();

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
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle(itemTitle);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        collapsingToolbarLayout.setContentScrimColor(getColor(android.R.color.holo_blue_dark));
        collapsingToolbarLayout.setStatusBarScrimColor(getColor(android.R.color.darker_gray));

        SquareImageView squareImageView = (SquareImageView) findViewById(R.id.image);
        squareImageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),getIntent().getIntExtra(EXTRA_IMAGE,0),getTheme()));
        //supportStartPostponedEnterTransition();
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

//    private void applyPalette(Palette palette) {
//        int primaryDark = getResources().getColor(R.color.colorPrimaryDark);
//        int primary = getResources().getColor(R.color.colorPrimary);
//        collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(primary));
//        collapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(primaryDark));
//        updateBackground((FloatingActionButton) findViewById(R.id.fab), palette);
//        supportStartPostponedEnterTransition();
//    }
//
//    private void updateBackground(FloatingActionButton fab, Palette palette) {
//        int lightVibrantColor = palette.getLightVibrantColor(getResources().getColor(android.R.color.white));
//        int vibrantColor = palette.getVibrantColor(getResources().getColor(R.color.colorAccent));
//
//        fab.setRippleColor(lightVibrantColor);
//        fab.setBackgroundTintList(ColorStateList.valueOf(vibrantColor));
//    }
}

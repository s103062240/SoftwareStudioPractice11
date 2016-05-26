package com.csclab.softwarestudiopractice11;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mei on 5/24/16.
 */

public class Activity2 extends Activity {

    private TextView nameText;
    private ImageView dino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        /** To Do:
         * (1) Find the UI element on xml file
         * (2) Use Bundle to retrieve name string
         * (3) Display "Welcome 'username' "
         * (4) Set image resource (Hint: drawable) and its touch listener **/

        Bundle bundle = this.getIntent().getExtras();
        String name = "Name: " + bundle.getString("name");

        nameText = (TextView) findViewById(R.id.nameTextView);
        nameText.setText(name);
        dino = (ImageView) findViewById(R.id.imageView);
        dino.setImageResource(R.drawable.dino);
        dino.setOnTouchListener(imgListener);
    }

    private OnTouchListener imgListener = new OnTouchListener() {
        private float x, y; //The x, y position that image exist
        private int mx, my; // The distance from original position to finger dragging
        private float dx, dy;

        /** To Do:
         * (1) Handle different touch events in onTouch method
         * (2) You can use v.layout() to change dinosaur's position
         * Hint: The event you may encounter: ACTION_DOWN & ACTION_MOVE **/

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: //ACTION_DOWN
                    dx = v.getX() - event.getRawX();
                    dy = v.getY() - event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE: //ACTION_MOVE
                    v.animate().x(event.getRawX() + dx)
                               .y(event.getRawY() + dy)
                               .setDuration(0)
                               .start();
                    break;

            }
            return true;
        }
    };

}

package com.swzfpro.wailovet.animationlistview;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void startLeftToRight(View v){
        Intent intent = new Intent();
        intent.putExtra("type", "lefttoright");
        intent.setClass(this, DemoActivity.class);
        this.startActivity(intent);
    }

    public void startFadeIn(View v){
        Intent intent = new Intent();
        intent.putExtra("type", "fadein");
        intent.setClass(MainActivity.this, DemoActivity.class);
        this.startActivity(intent);
    }

    public void startBottomToTop(View v){
        Intent intent = new Intent();
        intent.putExtra("type", "bottomtotop");
        intent.setClass(this, DemoActivity.class);
        this.startActivity(intent);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

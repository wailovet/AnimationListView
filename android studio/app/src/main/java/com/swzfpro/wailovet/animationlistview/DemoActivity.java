package com.swzfpro.wailovet.animationlistview;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DemoActivity extends ActionBarActivity {
    private AnimationListView alv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Intent intent=getIntent();
        String type=intent.getStringExtra("type");
        alv = (AnimationListView)findViewById(R.id.list);

        if (type.equals("fadein")){
            alv.setAnimationType(AnimationListView.AnimationType.FADEIN);
        }
        if (type.equals("lefttoright")){
            alv.setAnimationType(AnimationListView.AnimationType.LEFTTORIGHT);
        }
        if (type.equals("bottomtotop")){
            alv.setAnimationType(AnimationListView.AnimationType.BOTTOMTOTOP);
        }

        String[] from = { "Text" };
        int[] to = { R.id.text};
        List<Map<String, ?>> list = new ArrayList<Map<String, ?>>();
        for (int i = 0; i < 100; i++) {
            Map<String, String> m = new HashMap<String, String>();
            m.put("Text", "Hello,World！");
            list.add(m);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.list_item, from, to);
        alv.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fade_in, menu);
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

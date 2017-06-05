package com.architecturecomponents.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.architecturecomponents.App;
import com.architecturecomponents.BaseActivity;
import com.architecturecomponents.R;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {
    @Inject ViewModelProvider.Factory viewModelFactory;
    private TextView test;
    private ComicsViewModel comicViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App app = getApp();
        if (app != null) {
            app.getRepositoryComponent().inject(this);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            }
        });

        test = (TextView) findViewById(R.id.test);

        comicViewModel = ViewModelProviders.of(this, viewModelFactory).get(ComicsViewModel.class);
        comicViewModel.init();
        comicViewModel.getComics().observe(this, comics -> {
            if (comics == null) {
                test.setText("error");
            } else {
                test.setText(String.format("%s", comics.size()));
            }
        });
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
